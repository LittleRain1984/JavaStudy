package org.edward.javastudy.jdk.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<People, People> map = new HashMap<>();
        People p1 = new People(1);
        People p2 = new People(2);
        People p3 = new People(3);
        People p4 = new People(11);
        map.put(p1, p1);
        map.put(p2, p2);
        map.put(p3, p3);
        map.put(p4, p4);

        System.out.println("size:" + map.size());
    }
}
