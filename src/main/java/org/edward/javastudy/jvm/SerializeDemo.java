package org.edward.javastudy.jvm;

import java.io.*;

public class SerializeDemo {
    public static void main(String[] args) {
        SerializeDemo sd = new SerializeDemo();

        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;
        e.gender = "Female";

        String filePath = "/Users/edwardzhu/temp/employee.ser";
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
            Employee e = (Employee) in.readObject();
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

class Employee implements Serializable {

    private final static long serialVersionUID = 123456789L;

    String name;
    String address;
    int SSN;
    int number;
    String comment = "no comment.";
    String gender = "netual";

    public String toString() {
        return "name:" + name + "  address:" + address + " SSN:" + SSN + " number:" + number + " comment:" + comment + " gender: " + gender;
    }
}
