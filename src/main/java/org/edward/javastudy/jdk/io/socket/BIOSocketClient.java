package org.edward.javastudy.jdk.io.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class BIOSocketClient {
    public static void main(String[] args) {
        String[] inputArray = args;

        try (Socket socketClient = new Socket("localhost", 9090)) {


            OutputStream out = socketClient.getOutputStream();
            InputStream in = socketClient.getInputStream();

            for (String inputString : inputArray) {

                //client send message to Server
                System.out.println("Sending msg: " + inputString);
                out.write(inputString.getBytes());
                out.flush();


                //client read the response message from Server
                int inChar;
                StringBuffer inSB = new StringBuffer();
                while ((inChar = in.read()) != 35) {
                    inSB.append(inChar);
                }
                System.out.println("The response is:" + inSB.toString());

            }

            out.close();
            in.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
