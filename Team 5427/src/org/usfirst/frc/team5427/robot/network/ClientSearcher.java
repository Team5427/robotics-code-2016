/**
 * This class is dedicated to finding a client for a server
 */

package org.usfirst.frc.team5427.robot.network;

import java.net.ServerSocket;
import java.net.Socket;

public class ClientSearcher implements Runnable{

    ServerSocket serverSocket = null;
    Socket clientSocket;

    public ClientSearcher(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    /**
     * Returns a client for a server socket
     *
     * @param timeoutNano time the thread will look for a client
     * @return a client socket if found, null if non is found
     */
    public Socket getClient(long timeoutNano) {
        clientSocket = null;

        long startTime = System.nanoTime();
        long endTime = System.nanoTime() + timeoutNano;

        Thread t = new Thread(this);
        t.start();


        try {
            do {
                if (serverSocket != null) {
                    t.stop();                   // TODO: Deprecated?
                    break;
                }

                t.sleep(20);

            } while (System.nanoTime() < endTime);
        } catch (Exception e) {

        }

        return clientSocket;
    }

    @Override
    public void run() {
        if (serverSocket != null) {
            try {
                clientSocket = serverSocket.accept();
            } catch (Exception e) {

            }
        }
    }
}
