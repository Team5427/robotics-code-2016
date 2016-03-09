package org.usfirst.frc.team5427.robot.network;

import org.usfirst.frc.team5427.robot.util.Log;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Charlemagne Wong on 3/6/2016.
 */
public class SteelServer implements Runnable{

    public static final String DEFAULT_IP = "10.54.27.1";
    public static final int DEFAULT_PORT  = 20161;

    public static String ip;
    public static int port;

    Thread networkThread;
    public ArrayList<Object> inputStreamData = null;

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectOutputStream os;
    private ObjectInputStream is;

    private boolean running = false;

    public SteelServer() {
        port = DEFAULT_PORT;
    }

    public SteelServer(int port) {
        this.port = port;
    }

    /**
     * Initializes the server
     */
    public void initialize() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            Log.error("SteelServer failed to initialize");
        }
    }

    /**
     * Waits to find connection from the client
     *
     * @return true if connection is a success, false if failed
     */
    public boolean findClient() {
        clientSocket = new ClientSearcher(serverSocket).getClient(500);


        if (clientSocket != null) {
            establishStream();

            return true;
        }

        return false;
    }

    /**
     * Establishes the input and output stream between client and server
     *
     * @return true if stream established sucessfully, false if otherwise
     */
    public boolean establishStream() {
        if (clientSocket != null) {
            try {
                serverSocket = new ServerSocket(port);
                is = new ObjectInputStream(clientSocket.getInputStream());
                os = new ObjectOutputStream(clientSocket.getOutputStream());
                inputStreamData = new ArrayList<>();
                return true;
            } catch (Exception e) {
                Log.error("Input and Output stream failed to establish with the driver station.");
                return false;
            }
        }

        return false;
    }

    /**
     * Checks if the client is connected to a server
     *
     * @return true if server connection is established, false
     *         if not.
     */
    public boolean isConnected() {
        return serverSocket != null;
    }

    public static String getIp() {
        return ip;
    }


    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        SteelServer.port = port;
    }

    public ArrayList<Object> getInputStreamData() {
        return inputStreamData;
    }

    public void setInputStreamData(ArrayList<Object> inputStreamData) {
        this.inputStreamData = inputStreamData;
    }

    /**
     * Sends an object to the server
     *
     * @param o object to be sent to the server
     * @return true if the object is sent successfully, false
     *         if otherwise.
     */
    public boolean send(Object o) {
        try {
            os.writeObject(o);
            os.reset();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Enables the thread to start receiving data from a network
     *
     * @return true if the thread starts successfully, false if
     *         otherwise.
     */
    public boolean startRecieve() {
        if (serverSocket != null) {
            networkThread = new Thread(this);
            networkThread.start();
            running = true;
            return true;
        }

        return false;
    }

    /**
     * Stops the thread from receiving data from the server
     *
     * @return true if the thread is stopped successfully, false
     *         if otherwise.
     */
    public boolean stopRecieve() {
        if (networkThread.isAlive()) {      // The thread is found running and is stopped
            running = false;
            return true;
        } else {                            // The thread is not running in the first place
            return false;
        }
    }

    /**
     * Running method that receives data from the server.
     */
    @Override
    public void run() {

        while (clientSocket == null || clientSocket.isClosed()) {
            findClient();

            if (clientSocket == null) {
                try {
                    networkThread.sleep(10);
                } catch (Exception e) {
                    Log.error("Error in sleeping SteelServer");
                }
            }
        }

        while (running) {
            if (clientSocket.isClosed()) {
                running = false;
                break;
            }

            try {
                inputStreamData.add(is.readObject());
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                networkThread.sleep(10);
            } catch (Exception e) {
                Log.error("Error in sleeping SteelServer");
            }
        }
    }
}