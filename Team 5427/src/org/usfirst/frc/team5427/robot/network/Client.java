package org.usfirst.frc.team5427.robot.network;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

import org.usfirst.frc.team5427.robot.util.Log;

public class Client implements Runnable {

	public static final String DEFAULT_IP = "10.54.27.236";
	public static final int DEFAULT_PORT = 25565;
	public static int MAX_BYTE_BUFFER = 256;

	public static String ip;
	public static int port;

	public static GoalData lastReceivedGoal = null;

	Thread networkThread;

	private Socket clientSocket;
	private ObjectInputStream is;
	private ObjectOutputStream os;

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
	public boolean reconnect() {
		try {
			clientSocket = new Socket(ip, port);
			is = new ObjectInputStream(clientSocket.getInputStream());
			os = new ObjectOutputStream(clientSocket.getOutputStream());
			Log.debug(clientSocket.toString());

			Log.info("Connection to the server has been established successfully.");

			return true;
		} catch (Exception e) {
			// TODO removed due to spam
			// System.out.println("Connection failed to establish.");
		//	Log.info("Connection failed to establish.");
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

	/**
	 * Sends a command to the server
	 *
	 * @param byteType
	 *            the command from ByteDictionary
	 * @return true if byte sent successfully, false if otherwise
	 */
	public synchronized boolean sendCommand(byte byteType) {
		if (byteType == ByteDictionary.TELEOP_START || byteType == ByteDictionary.AUTO_START) {
			byte[] buff = new byte[1];
			buff[0] = byteType;
			send(buff);
		}

		return false;
	}

	public synchronized boolean send(byte[] buff) {

		if (isConnected()) {

			try {
				os.write(buff);
				os.reset();
				os.flush();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	public synchronized boolean send(String s) {
		if (isConnected()) {
			try {
				os.writeChars(s);
				os.reset();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
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

	public void interpretData(byte[] buff, int numFromStream) {

		switch (buff[0]) {
		case ByteDictionary.GOAL_ATTACHED:

			lastReceivedGoal = new GoalData(buff);
			Log.debug("Data from goal: Motor Value-" + lastReceivedGoal.getMotorValue() + " X Angle-"
					+ Math.toDegrees(lastReceivedGoal.getHorizontalAngle()));
			Log.debug("Data from received bytes: " + getStringByteBuffer(buff));

			break;

		case ByteDictionary.LOG:

			Log.vision(new String(getBufferedSegment(buff, 1, numFromStream - 1)));

			break;

		}

	}

	/**
	 * Running method that receives data from the server.
	 */
	@Override
	public void run() {

		reconnect();

		while (!networkThread.isInterrupted()) {

			if (clientSocket != null && !clientSocket.isClosed() && is != null) {
				try {
					byte buffer[] = new byte[MAX_BYTE_BUFFER];
					int numFromStream = is.read(buffer, 0, buffer.length);

					Log.debug("num from stream: " + numFromStream);
					interpretData(buffer, numFromStream);
					Log.debug("\n===========================\n");

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
//				Log.info("Connection lost, attempting to re-establish with driver station.");
				reconnect();
			}
		}
	}

	public static String getStringByteBuffer(byte[] buff) {
		String str = "[";

		for (int i = 0; i < buff.length; i++)
			str += buff[i] + ",";

		return str + "]";
	}

	public static byte[] getBufferedSegment(byte[] buff, int startPos, int length) {
		byte[] temp = new byte[length];

		for (int i = 0; i < length; i++) {
			System.out.println("buffereing");
			temp[i] = buff[startPos + i];
		}
		return temp;

	}

	public static double getMotorValue() {
		if (lastReceivedGoal == null)
			return 1;

		return lastReceivedGoal.getMotorValue();
	}
}