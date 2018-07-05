package org.edward.javastudy.serializable;

import java.io.*;

/**
 * # If the object serialVersionUID is different between the marshall/unmarshall, exception
 * java.io.InvalidClassException: org.edward.javastudy.serializable.Employee3;
 * local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2
 * #* write with serialVersionUID 1L
 * #* read with serialVersionUID 2L
 * #*
 */
public class SerializeDemo3 {
    public static void main(String[] args) {
        SerializeDemo1 sd = new SerializeDemo1();

        Employee3 e = new Employee3();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.number = 101;
        e.gender = "Female1";

        String filePath = "src/main/java/org/edward/javastudy/serializable/employee2.ser";
        File file = new File(filePath);
        System.out.println("Try to serial the object to path:" + file.getAbsolutePath());

        //1st write
        // sd.marshallToFile(filePath, e);


        //2st write
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
            Employee3 e = (Employee3) in.readObject();
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

class Employee3 implements Serializable {

    //1st write
//     private final static long serialVersionUID = 1L;

    //2nd read
    private final static long serialVersionUID = 2L;
    String name;
    String address;
    int number;
    String gender = "netual";

    public String toString() {
        return "name:" + name + "  address:" + address + " number:" + number + " gender: " + gender;
    }
}

