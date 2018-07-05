package org.edward.javastudy.algorithm.ConsistentHashAlg;

import java.util.HashMap;
import java.util.Map;

public class Server {

    public Map<Entry, Entry> entries = new HashMap<Entry, Entry>();
    private String name;

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
