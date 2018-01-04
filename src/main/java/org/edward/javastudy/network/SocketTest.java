package org.edward.javastudy.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by edwardzhu on 6/27/17.
 */
public class SocketTest {
    public static void main(String[] args) {
        try (Socket socket = new Socket("time.nist.gov", 13)) {
            InputStream input = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);
            int c = 0;
            while (c != -1) {
                c = reader.read();
                System.out.println(c + "=" + (char) c);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
