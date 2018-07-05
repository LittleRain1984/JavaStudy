package org.edward.javastudy.algorithm.ConsistentHashAlg;

public class Main {
    public static void main(String[] args) {
        Cluster c = new Cluster();
        c.initServers(5);

        Entry[] entries = new Entry[]{
                new Entry("Hello"),
                new Entry("World"),
                new Entry(","),
                new Entry("I"),
                new Entry("am"),
                new Entry("new"),
                new Entry("to"),
                new Entry("Java"),
        };

        for (Entry e : entries) {
            c.put(e);
        }

        c.addServer(new Server("Server - Edward"));
        c.put(new Entry("New Server Added"));

        for (Entry e : entries) {
            if (c.get(e) == null) {
                System.out.println("!!!NOT Found " + e.toString());
            } else {
                System.out.println("Found " + e.toString());
            }
        }

    }
}
