package org.edward.javastudy.thread.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        new Client().go();
    }

    public void go() {
        try {
            Socket clientSocket = new Socket("127.0.0.1", Server.SERVER_PORT);

            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            Thread t = new Thread(new SocketClientMonitor(clientSocket));
            t.start();

            //random writer to send message to server;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputString;
            while ((inputString = reader.readLine()) != null) {
                writer.write("client id[" + System.currentTimeMillis() + "]:" + inputString + System.lineSeparator());
                writer.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class SocketClientMonitor implements Runnable {

        Socket socket;

        SocketClientMonitor(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
