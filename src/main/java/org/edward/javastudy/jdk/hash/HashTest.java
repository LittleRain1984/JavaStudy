package org.edward.javastudy.jdk.hash;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashTest {

    public static void main(String[] args) {
        Map h = new HashMap();
        Map h2 = Collections.synchronizedMap(h);


        int total = 20;
        int index =0;
        while(index <total){
            Animal a = new Animal(index);
            h.put(a,a);
            index++;
        }

        System.out.println("1===>" + (1>>>1));
        System.out.println("3===>" + (3>>>1));
        System.out.println("7===>" + (7>>>1));
        System.out.println("15===>" + (15>>>1));
    }
}


class Animal {

    int age;

    Animal(int age){
        this.age = age;
    }

    @Override
    public int hashCode() {
        return age%3;
    }

}