package org.edward.javastudy.algorithm.ConsistentHashAlg2;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Server {

    public SortedMap<Entry, Entry> entries = new TreeMap<Entry, Entry>();
    public String name;

    public Server(String name) {
        this.name = name;
    }


    public void put(Entry e) {
        entries.put(e, e);
    }

    public Entry get(Entry e) {
        return entries.get(e);
    }

}
