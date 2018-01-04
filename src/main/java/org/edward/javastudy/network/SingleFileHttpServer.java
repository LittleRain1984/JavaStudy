package org.edward.javastudy.network;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.FileChannel;

/**
 * Created by edwardzhu on 6/28/17.
 */
public class SingleFileHttpServer {

    private static int DEFAULT_HTTP_PORT = 2000;

    public static void main(String[] args) {
        int port;
        try {
            port = Integer.valueOf(args[0]);
            if (port < 1 || port > 65535) {
                port = DEFAULT_HTTP_PORT;
            }
        } catch (RuntimeException re) {
            port = DEFAULT_HTTP_PORT;
        }

        //        SingleFileHttpServer sfhs = new SingleFileHttpServer();
        //        sfhs.start();
        try {
            ServerSocket socket = new ServerSocket(port);
            Socket connection = socket.accept();
            System.out.println("Connection get...");
            OutputStream out = new BufferedOutputStream(connection.getOutputStream());
            String ironmanStr = "IRONMAN...";
            byte[] welcomeWord = ironmanStr.getBytes();
            out.write(welcomeWord);
            System.out.println("start to write welcome word..." + welcomeWord);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }

    public void start() {
    }

}
