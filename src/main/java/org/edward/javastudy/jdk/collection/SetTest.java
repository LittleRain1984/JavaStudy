package org.edward.javastudy.jdk.collection;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        Animal a1 = new Animal(3);
        Animal a2 = new Animal(6);

        System.out.println("a1 hashcode:" + a1.hashCode());
        System.out.println("a2 hashcode:" + a2.hashCode());

        Set<Animal> set = new HashSet<Animal>();

        set.add(a1);
        set.add(a2);

        System.out.println("size:" + set.size());
        System.out.println(set.iterator().next().getAge());
    }
}

class Animal {

    public Animal(int age) {
        this.age = age;
    }

    private int age;

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return age % 3;
    }
}
