package org.edward.javastudy.jdk.polymorphism;

import java.util.Comparator;

public class Wine {

    public void getName() {
        System.out.println("Wine name is: Wine");
        getAge();
    }

    public void getAge() {
        System.out.println("Wine age is: Average");
    }

    public void getBrand() {
        System.out.println("Wine branch is: Wine");
    }


    public static void main(String[] args) {
        Wine w1 = new JNC();
        w1.getName();
    }
}


class JNC extends Wine {

    @Override
    public void getName() {
        System.out.println("Wine name is : JNC");
        getAge();
    }

    @Override
    public void getAge() {
        System.out.println("JNC age is: 100");
    }

    public  void getBranch(String brand) {
        System.out.println("Wine branch is: " + brand);
    }
}

class WLY extends Wine {
    public void getName() {
        System.out.println("Wine name is: WLY");
    }

    public void getAge() {
        System.out.println("WLY age is: 200");
    }
}

interface IMultiExtend extends Cloneable, Comparator {

}
