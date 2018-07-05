package org.edward.javastudy.serializable;

import java.io.*;

/**
 * # Show how to serial/deserial the object
 * #* the object need to serial must implements Serializable interface
 */
public class SerializeDemo1 {
    public static void main(String[] args) {
        SerializeDemo1 sd = new SerializeDemo1();

        String filePath = "src/main/java/org/edward/javastudy/serializable/employee1.ser";
        File file = new File(filePath);
        System.out.println("Try to serial the object to path:" + file.getAbsolutePath());

        sd.unMarshallFromFile(filePath);
    }

    public void marshallToFile(String path, Object object) {

        try {
            FileOutputStream fileOut =
                    new FileOutputStream(path, true);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in " + path);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void unMarshallFromFile(String path) {
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Employee1 e = (Employee1) in.readObject();
            System.out.println(e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class Employee1 implements Serializable {

    private final static long serialVersionUID = 1L;

    String name;
    String address;
    int number;
    String gender = "netual";

    public String toString() {
        return "name:" + name + "  address:" + address + " number:" + number + " gender: " + gender;
    }
}
