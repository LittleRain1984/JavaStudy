package org.edward.javastudy.algorithm.ConsistentHashAlg2;

import java.util.*;

public class Cluster {
    private static int MAX_SERVER_SIZE = 1024;

    public SortedMap<Integer, Server> serverMap = new TreeMap<Integer, Server>();

    private int size = 0;

    public void initServers(int number) {
        for (int index = 0; index < number; index++) {
            addServer(new Server("Server-" + index));
        }
    }

    public void addServer(Server s) {
        System.out.println("Adding Server:" + s.name + " hash:" + s.hashCode());
        serverMap.put(s.hashCode(), s);
    }

    public void put(Entry e) {
        routeServer(e).put(e);
    }

    public Entry get(Entry e) {
        return routeServer(e).get(e);
    }

    public Server routeServer(Entry e) {

        int hashCode = e.hashCode();
        System.out.println("Routing server for entry:" + hashCode);

        if (serverMap.containsKey(hashCode)) {
            return serverMap.get(hashCode);
        }

        SortedMap<Integer, Server> tailMap = serverMap.tailMap(hashCode);
        hashCode = tailMap.isEmpty() ? serverMap.firstKey() : tailMap.firstKey();

        Server s =  serverMap.get(hashCode);

        System.out.println("Routing to server:" + s.name + "  server hash:" + s.hashCode());
        return s;
    }
}