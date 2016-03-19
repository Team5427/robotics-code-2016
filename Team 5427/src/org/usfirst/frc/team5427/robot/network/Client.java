package org.usfirst.frc.team5427.robot.network;

import org.usfirst.frc.team5427.robot.util.Log;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client {

	public static final String DEFAULT_IP = "10.54.27.236";
	public static final int DEFAULT_PORT = 25565;

	public static String ip;
	public static int port;

	static Thread networkThread;

	private static Socket clientSocket;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;

	public static GoalData lastRecievedGoal = null;

	public Client() {
		ip = DEFAULT_IP;
		port = DEFAULT_PORT;
	}

	public Client(String ip, int port) {
		Client.ip = ip;
		Client.port = port;
	}

	/**
	 * Reconnect to the client to the server
	 *
	 * @return true if connection is a success, false if failed
	 */
	public static boolean reconnect() {
		try {
			clientSocket = new Socket(ip, port);
			in = new ObjectInputStream(clientSocket.getInputStream());
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			Log.debug(clientSocket.toString());

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
	public static boolean isConnected() {
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

	/**
	 * Sends an String to the server
	 *
	 * @param s
	 *            String to be sent to the server
	 * @return true if the String is sent successfully, false if otherwise.
	 */
	public synchronized static boolean send(String s) {

		if (networkThread != null && !networkThread.isInterrupted()) {
			try {
				out.writeUTF(s);
				out.reset();
				return true;
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
	public static synchronized boolean start() {
		if (networkThread == null && (clientSocket == null || !clientSocket.isClosed())) {
			networkThread = new Thread(new Runnable() {

				/**
				 * Running method that receives data from the server.
				 */
				@Override
				public void run() {

					reconnect();
					Scanner taskReader;

					while (!networkThread.isInterrupted()) {

						if (clientSocket != null && !clientSocket.isClosed() && in != null) {
							try {

								String s = in.readUTF();

								
								//TODO make sure that these are all working
								if (s.contains(StringDictionary.TASK)) {

									s = s.substring(StringDictionary.TASK.length(), s.length() - 1);

									if (s.contains(StringDictionary.GOAL_ATTACHED)) {

										s = s.substring(StringDictionary.GOAL_ATTACHED.length(), s.length() - 1);
										taskReader = new Scanner(s);

										lastRecievedGoal = new GoalData(taskReader.nextDouble(),
												taskReader.nextDouble(), taskReader.nextDouble(),
												taskReader.nextDouble());

									} else if (s.contains(StringDictionary.LOG)) {

										s = s.substring(StringDictionary.LOG.length(), s.length() - 1);

										Log.info(s);

									} else if (s.contains(StringDictionary.MESSAGE)) {

									} else if (s.contains(StringDictionary.TELEOP_START)) {

										Log.warn(
												"Driver station has told the robot TELEOP_START, and that should not happen.");

									} else if (s.contains(StringDictionary.AUTO_START)) {

										Log.warn(
												"Driver station has told the robot AUTO_START, and that should not happen.");

									} else {
										System.out.println("Valid task was recieved, but with unrecognized contents.");
									}

								} else {
									System.out.println("unrecognized task");
								}

							} catch (SocketException e) {
								reconnect();
							} catch (Exception e) {
								Log.error(e.getMessage());
							}

							try {
								Thread.sleep(10);
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
			});
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
	public static synchronized boolean stop() {
		networkThread.interrupt();

		try {
			clientSocket.close();
			out.close();
			in.close();
		} catch (Exception e) {
			Log.error(e.getMessage());
		}

		clientSocket = null;
		out = null;
		in = null;

		if (!networkThread.isAlive()) { // The thread is found running and is
										// told to stop
			return true;
		} else { // The thread is not running in the first place
			return false;
		}
	}

}