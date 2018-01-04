package org.edward.javastudy.exception;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by edwardzhu on 6/8/17.
 */
public class java7_try_catch {
    public static void main(String[] args) {
        try (OutputStream out = new FileOutputStream("/Users/edwardzhu/otmsdev/opentrans2/commit.template")) {
            System.out.println("I am file");
        } catch (IOException exp) {
            System.out.println();
        }
    }
}
