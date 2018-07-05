package org.edward.javastudy.serializable;

import java.io.*;

/**
 * if the object need to serial is not implement Serializable interface, throw NotSerializableException
 */
public class SerializeDemo2 {
    public static void main(String[] args) {
        SerializeDemo1 sd = new SerializeDemo1();

        Employee2 e = new Employee2();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.number = 101;
        e.gender = "Female1";

        String filePath = "src/main/java/org/edward/javastudy/serializable/employee2.ser";
        File file = new File(filePath);
        System.out.println("Try to serial the object to path:" + file.getAbsolutePath());

        sd.marshallToFile(filePath, e);

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
            Employee2 e = (Employee2) in.readObject();
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

class Employee2 {

    private final static long serialVersionUID = 1L;

    String name;
    String address;
    int number;
    String gender = "netual";

    public String toString() {
        return "name:" + name + "  address:" + address + " number:" + number + " gender: " + gender;
    }
}
