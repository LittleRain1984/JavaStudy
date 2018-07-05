package org.edward.javastudy.algorithm.ConsistentHashAlg2;

public class Main {
    public static void main(String[] args) {
        Cluster c = new Cluster();
        c.initServers(5);

        Entry[] entries = new Entry[]{
                new Entry("Hello "),
                new Entry("World "),
                new Entry(", "),
                new Entry("I "),
                new Entry("am "),
                new Entry("new "),
                new Entry("to "),
                new Entry("Java "),
                new Entry("Thanks "),
                new Entry("! ")
        };

        for (Entry e : entries) {
            c.put(e);
        }

        System.out.println("First Time--------------------------------------------------");
        for(Integer hash: c.serverMap.keySet()){
            Server s = c.serverMap.get(hash);
            System.out.println("server:" + s.name + "  hash:" + s.hashCode());
            for(Entry key : s.entries.keySet()){
                System.out.println("key : " + key + "   hash:" + key.hashCode());
            }
        }


        System.out.println("--------------------------------------------------");
        c.addServer(new Server("Server - Edward"));
        c.put(new Entry("New Server Added"));

        for (Entry e : entries) {
            if (c.get(e) == null) {
                System.out.println("!!!NOT Found " + e.toString());
            } else {
                System.out.println("Found " + e.toString());
            }
        }

        System.out.println(" Second Time--------------------------------------------------");
        for(Integer hash: c.serverMap.keySet()){
            Server s = c.serverMap.get(hash);
            System.out.println("server:" + s.name + "  hash:" + s.hashCode());
            for(Entry key : s.entries.keySet()){
                System.out.println("key : " + key + "   hash:" + key.hashCode());
            }
        }

    }
}
