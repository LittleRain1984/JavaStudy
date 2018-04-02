package org.edward.javastudy.jdk.io;

import sun.jvm.hotspot.runtime.Threads;

import java.io.*;

public class FileReaderTest {

    public static void main(String[] args) {
        try {
            File file = new File("/Users/edwardzhu/temp/test.bat");
            FileWriter fw = new FileWriter(file, true);
            fw.write("FileReaderTest1 1st time write" + System.lineSeparator());
            fw.flush();
            fw.close();
            Thread.sleep(10000);


            File file2 = new File("/Users/edwardzhu/temp/test.bat");
            FileWriter fw2 = new FileWriter(file2, true);

            fw2.write("FileReaderTest1 2nd time write" + System.lineSeparator());
            fw2.flush();
            fw2.close();

//            for (int i = 0; i < 100; i++) {
//                fw.append((char) i);
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }
}


class FileWriteThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " started;");
            File file = new File("/Users/edwardzhu/temp/test.bat");
            FileWriter fw = new FileWriter(file, true);
            if (Thread.currentThread().getName().equals("Thread-0")) {
                System.out.println("Thread-0 detected.");
                Thread.sleep(3000);
            } else {
                System.out.println("Thread-1 detected.");
                Thread.sleep(60000);
            }

            fw.write(Thread.currentThread().getName());


//            for (int i = 0; i < 100; i++) {
//                fw.append((char) i);
//            }

            fw.flush();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
