package org.edward.javastudy;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        List<Animal> list = new ArrayList<Animal>();
        list.add(null);

        for (Animal animal : list) {
            System.out.println("start:" + animal);
            if (animal.age == 100) {
                System.out.println("in if");
            }

            System.out.println("End");
        }

    }

    class Animal {
        Integer age;
        String name;
    }
}
