package org.edward.javastudy.jdk.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MultiThreadDayTimeSocketServer {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9090);

            while (true) {
                Socket socket = ss.accept();
                new DayTimeThread(socket).start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class DayTimeThread extends Thread {

    private Socket socket;

    public DayTimeThread(Socket socket) {
        System.out.println("New Socket thread handled: " + socket.getChannel());
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            Writer out = new OutputStreamWriter(socket.getOutputStream());
            out.write(new Date().toString() + "\r\n");
            out.flush();


            out.write("2nd daytime: " + new Date().toString() + "\r\n");
            out.flush();

            Thread.sleep(100000);

            out.close();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
