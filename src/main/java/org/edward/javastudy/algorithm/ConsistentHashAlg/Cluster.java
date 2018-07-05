package org.edward.javastudy.algorithm.ConsistentHashAlg;

public class Cluster {
    private static int MAX_SERVER_SIZE = 1024;

    public Server[] servers = new Server[MAX_SERVER_SIZE];

    private int size = 0;

    public void initServers(int number) {
        for (int index = 0; index < number; index++) {
            addServer(new Server("Server-" + index));
        }
    }

    public void addServer(Server s) {
        servers[size++] = s;
    }

    public void put(Entry e) {
        int serverIndex = e.hashCode() % size;
        servers[serverIndex].put(e);
    }

    public Entry get(Entry e) {
        int serverIndex = e.hashCode() % size;
        return servers[serverIndex].get(e);
    }
}
