package org.edward.javastudy.jdk.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapThreadUnSafePutTest {
    public static void main(String[] args) {
        Map map = new HashMap(100000);
        for (int i = 0; i < 100; i++) {
            Thread r = new Thread(new PutThread(i, map));
            r.start();
        }

        System.out.println("expected size :" + 1000 * 100 + ",  actual size:" + map.size());
        Set<Integer> s = map.keySet();
        for(Integer i : s) {
            System.out.println(i);
        }
    }
}

class PutThread implements Runnable {

    Map map;
    int group;

    PutThread(int group, Map map) {
        this.group = group;
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 1000 * (group - 1); i < 1000 * group; i++) {
            map.put(i, i);
        }
    }
}
