package org.edward.javastudy.jdk.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class BIOSocketServer {

    public static void main(String[] args) {
        System.out.println("Started");

        try {
            ServerSocket ss = new ServerSocket(9090);
            while (true) {
                Socket socket = ss.accept();

                handle(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void handle(Socket socket) throws IOException {


        System.out.println("Start to handle socket");
        try (InputStreamReader in = new InputStreamReader(socket.getInputStream()); Writer out = new OutputStreamWriter(socket.getOutputStream())) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int c;
                while ((c = in.read()) != 35) {
                    sb.append((char) c);
                }

                System.out.println("Received: " + sb.toString());
                out.write(transform(sb.toString()));
                out.flush();
            }
        }

    }

    private static String transform(String line) {
        return line.toUpperCase();
    }
}
