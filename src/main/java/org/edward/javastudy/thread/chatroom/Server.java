package org.edward.javastudy.thread.chatroom;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Server {

    public static int SERVER_PORT = 5000;
    private ServerSocket ss;
    private List<Socket> clientSocketList;

    public static void main(String[] args) {
        Server server = new Server();
        server.startService();


    }

    private void startService() {
        this.setupConnection();
    }

    private void setupConnection() {
        try {
            //new the server socket
            ss = new ServerSocket(SERVER_PORT);
            clientSocketList = new ArrayList<Socket>();

            while (true) {
                Socket socket = ss.accept();
                clientSocketList.add(socket);

                //assign a new Thread for client connecton handling
                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ClientHandler implements Runnable {
        Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                String inputString = "Welcome [" + socket.getLocalAddress() + ":" + socket.getLocalPort() + "] to join the chat room," + "" +
                        " There are [" + clientSocketList.size() + "] client in the room.";
                System.out.println(inputString);
                pushMsgToAll(inputString);

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while ((inputString = reader.readLine()) != null) {
                    System.out.println("[" + socket.getLocalAddress() + ":" + socket.getLocalPort() + "]:" + inputString);
                    pushMsgToAll(inputString);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void pushMsgToAll(String inputString) {
            if (clientSocketList.size() == 0) {
                return;
            }

            Iterator<Socket> socketsIterator = clientSocketList.iterator();
            while (socketsIterator.hasNext()) {
                Socket clientSocket = socketsIterator.next();
                if (clientSocket == this.socket) {
                    continue;
                }
                    try {
                        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                        writer.write(inputString + System.lineSeparator());
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

        }
    }

}

