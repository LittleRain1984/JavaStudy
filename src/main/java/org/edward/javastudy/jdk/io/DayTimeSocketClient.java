package org.edward.javastudy.jdk.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class DayTimeSocketClient {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            try {
                Socket socket = new Socket("localhost", 9090);
                if (socket.isConnected()) {
                    System.out.println(i + "==>" + socket + "  is connected.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
