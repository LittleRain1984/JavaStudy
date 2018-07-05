package org.edward.javastudy.jvm;

public class CloneableTest {
    public static void main(String[] args) {
        People p1 = new People();
        p1.name = "Edward";
        p1.age = 35;
        Finger f1 = new Finger();
        f1.name = "Middle Finger";
        f1.length = 10;

        p1.finger = f1;

        People p2 = p1.clone();
        p2.name = "Shirely";
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.finger);
        System.out.println(p2.finger);

    }
}

class People implements Cloneable {
    String name;
    int age;
    Finger finger;

    @Override
    public People clone() {
        People people = null;
        try {
            people = (People) super.clone();
            people.finger = this.finger.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        return people;
    }

//    @Override
//    public String toString() {
//        return "name:" + name + " age:" + age;
//    }

}

class Finger implements Cloneable {
    String name;
    int length;

    @Override
    public Finger clone() {
        Finger f1 = null;
        try {
            f1 = (Finger) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return f1;
    }

//    @Override
//    public String toString() {
//        return "name:" + name + " length:" + length;
//    }
}