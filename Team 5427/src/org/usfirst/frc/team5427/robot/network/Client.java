package org.usfirst.frc.team5427.robot.network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Client {

	public static final String DEFAULT_IP = "10.54.27.1";
	public static final int DEFAULT_PORT = 25565;

	private static Socket clientSocket;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;

	private static boolean running = false;

	private static Thread networkThread = new Thread(new Runnable() {

		@Override
		public void run() {

			reconnect();

			while (running && clientSocket != null && !clientSocket.isClosed() && is != null) {
				try {
					Object o = in.readObject();

					if (o.toString().contains("Task")) {
						Task t = (Task) o;

						switch (t.getTask()) {
						case GOAL_ATTACHED:
							break;

						case LOG:
							break;

						default:
							System.out.println("TaskDescription \"" + t.getTask().toString() + "\" is not recognized.");

						}
					}

				} catch (SocketException e) {
					reset();
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					Thread.sleep(10); // TODO not sure if this works, eclipse
										// said that it had to be done.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	});

	/**
	 * Reconnect to the client to the server
	 *
	 * @return true if connection is a success, false if failed
	 */
	public static boolean reconnect() {
		try {
			clientSocket = new Socket(DEFAULT_IP, DEFAULT_PORT);
			in = new ObjectInputStream(clientSocket.getInputStream());
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			System.out.println(clientSocket);

			System.out.println("Connection to the server has been established successfully.");

			return true;
		} catch (Exception e) {
			System.out.println("Connection failed to establish.");
			return false;
		}
	}

	/**
	 * Enables the thread to start receiving data from a network
	 *
	 * @return true if the thread starts successfully, false if otherwise.
	 */
	public static synchronized boolean start() {
		if (!running && (clientSocket == null || !clientSocket.isClosed())) {
			running = true;
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
		running = false;

		try {
			clientSocket.close();
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
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

	public static synchronized boolean reset() {
		stop();
		start();

		return false;
	}

}
