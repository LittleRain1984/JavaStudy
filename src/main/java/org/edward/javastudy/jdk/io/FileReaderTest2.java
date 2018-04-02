package org.edward.javastudy.jdk.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderTest2 {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/edwardzhu/temp/test.bat");
            FileWriter fw = new FileWriter(file, false);

            Thread.sleep(5000);
            fw.write("FileReaderTest2  1st time write " + System.lineSeparator());
            fw.flush();

//            Thread.sleep(7000);
//            fw.write("FileReaderTest2 2nd time write");


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


