package org.usfirst.frc.team5427.robot.network;

import org.usfirst.frc.team5427.robot.util.Log;
import org.usfirst.frc.team5427.robot.network.Task;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client implements Runnable {

	public static final String DEFAULT_IP = "10.54.27.236";
	public static final int DEFAULT_PORT = 25565;

	public static String ip;
	public static int port;

	Thread networkThread;
	public ArrayList<Object> inputStreamData = null;

	private Socket clientSocket;
	private ObjectInputStream is;
	private ObjectOutputStream os;

	public static GoalData lastRecievedGoal = null;

	public Client() {
		ip = DEFAULT_IP;
		port = DEFAULT_PORT;
	}

	public Client(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	/**
	 * Reconnect to the client to the server
	 *
	 * @return true if connection is a success, false if failed
	 */
	public boolean reconnect() {
		try {
			clientSocket = new Socket(ip, port);
			is = new ObjectInputStream(clientSocket.getInputStream());
			os = new ObjectOutputStream(clientSocket.getOutputStream());
			Log.debug(clientSocket.toString());

			inputStreamData = new ArrayList<>();

			Log.info("Connection to the server has been established successfully.");

			return true;
		} catch (Exception e) {
			Log.info("Connection failed to establish.");
			return false;
		}
	}

	/**
	 * Checks if the client is connected to a server
	 *
	 * @return true if server connection is established, false if not.
	 */
	public boolean isConnected() {
		return clientSocket != null && !clientSocket.isClosed();
	}

	public static String getIp() {
		return ip;
	}

	public static void setIp(String ip) {
		Client.ip = ip;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		Client.port = port;
	}

	public ArrayList<Object> getInputStreamData() {
		return inputStreamData;
	}

	/**
	 * Sends an object to the server
	 *
	 * @param t
	 *            object to be sent to the server
	 * @return true if the object is sent successfully, false if otherwise.
	 */
	public synchronized boolean send(Task t) {

		if (networkThread != null && !networkThread.isInterrupted()) {
			try {
				os.writeObject(t);
				os.reset();
				return true;
			} catch (NotSerializableException e) {
				Log.error(getClass() + ":: send(Serializable o)\n\tThe object to be sent is not serializable.");
			} catch (SocketException e) {
				Log.error("Socket Exception");
			} catch (NullPointerException e) {
				Log.error("\n\tThere was an error connecting to the server.");
			} catch (Exception e) {
				Log.error(e.getMessage());
			}
		}

		return false;
	}

	/**
	 * Enables the thread to start receiving data from a network
	 *
	 * @return true if the thread starts successfully, false if otherwise.
	 */
	public synchronized boolean start() {
		if (networkThread == null && (clientSocket == null || !clientSocket.isClosed())) {
			networkThread = new Thread(this);
			networkThread.start();
			return true;
		}

		return false;
	}

	/**
	 * Stops the thread from receiving data from the server
	 *
	 * @return true if the thread is stopped successfully, false if otherwise.
	 */
	public synchronized boolean stop() {
		networkThread.interrupt();

		try {
			clientSocket.close();
			os.close();
			is.close();
		} catch (Exception e) {
			Log.error(e.getMessage());
		}

		clientSocket = null;
		os = null;
		is = null;

		if (!networkThread.isAlive()) { // The thread is found running and is
										// told to stop
			return true;
		} else { // The thread is not running in the first place
			return false;
		}
	}

	/**
	 * Running method that receives data from the server.
	 */
	@Override
	public void run() {

		reconnect();
		Scanner taskReader;

		while (!networkThread.isInterrupted()) {

			if (clientSocket != null && !clientSocket.isClosed() && is != null) {
				try {

					String s = is.readUTF();

					if (s.contains(StringDictionary.TASK)) {

						s = s.substring(StringDictionary.TASK.length(), s.length() - 1);

						if (s.contains(StringDictionary.GOAL_ATTACHED)) {

							s = s.substring(StringDictionary.GOAL_ATTACHED.length(), s.length() - 1);
							taskReader = new Scanner(s);

							lastRecievedGoal = new GoalData(taskReader.nextDouble(), taskReader.nextDouble(),
									taskReader.nextDouble(), taskReader.nextDouble());

						} else if (s.contains(StringDictionary.LOG)) {

						} else if (s.contains(StringDictionary.MESSAGE)) {

						} else if (s.contains(StringDictionary.TELEOP_START)) {
							
							Log.warn("Driver station has told the robot TELEOP_START, and that should not happen.");

						} else if (s.contains(StringDictionary.AUTO_START)) {
							
							Log.warn("Driver station has told the robot AUTO_START, and that should not happen.");

						} else {
							System.out.println("Valid task was recieved, but with unrecognized contents.");
						}

					} else {
						System.out.println("unrecognized task");
					}

					/*
					 * Object o = is.readObject(); if (o.toString().contains(
					 * "Team 5427 - Task ")) { System.out.println(
					 * "recieved a valid object"); Task t = (Task) o; switch
					 * (t.getTask()) { case AUTO_START: Log.warn(
					 * "driver station has told the robot AUTO_START, and this should not happen."
					 * ); break; case DEFAULT_MODE: Log.warn(
					 * "driver station has told the robot DEFAULT_MODE, and this should not happen."
					 * ); break; case GOAL_ATTACHED: lastRecievedGoal =
					 * (GoalData) t.getObject(); break; case LOG:
					 * Log.vision((String) t.getObject()); break; case MESSAGE:
					 * break; case TELEOP_START: Log.warn(
					 * "driver station has told the robot TELEOP_START, and this should not happen."
					 * ); break; default: Log.warn(
					 * "driver station has sent the robot " + t.getTask() +
					 * ", and is unrecognized by the robot."); break;
					 * 
					 * }
					 * 
					 * 
					 * }
					 */

				} catch (SocketException e) {
					reconnect();
				} catch (Exception e) {
					Log.error(e.getMessage());
				}

				try {
					networkThread.sleep(10);
				} catch (InterruptedException e) {
					Log.info("Thread has been interrupted, client thread will stop.");
				} catch (Exception e) {
					Log.error(e.getMessage());
				}
			} else {
				Log.info("Connection lost, attempting to re-establish with driver station.");
				reconnect();
			}
		}
	}

}