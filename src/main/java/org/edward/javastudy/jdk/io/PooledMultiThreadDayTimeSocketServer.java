package org.edward.javastudy.jdk.io;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PooledMultiThreadDayTimeSocketServer {


    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(1);

        try {
            ServerSocket ss = new ServerSocket(9090);

            while (true) {
                Socket socket = ss.accept();
                DayTimeTask task = new DayTimeTask(socket);

                pool.submit(task);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class DayTimeTask implements Callable<Void> {

    private Socket socket;

    DayTimeTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public Void call() throws Exception {
        try {

            Writer out = new OutputStreamWriter(socket.getOutputStream());
            out.write(new Date().toString() + "\r\n");
            out.flush();


            out.write("2nd daytime: " + new Date().toString() + "\r\n");
            out.flush();

            Thread.sleep(5000);

            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }
}
