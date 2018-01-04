package org.edward.javastudy.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by edwardzhu on 6/15/17.
 */
public class InetAddressTest {
    public static void main(String[] args) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName("www.baidu.com");
            System.out.println(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
