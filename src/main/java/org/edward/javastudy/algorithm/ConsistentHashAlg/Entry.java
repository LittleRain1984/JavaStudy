package org.edward.javastudy.algorithm.ConsistentHashAlg;

public class Entry {
    private String key;

    public Entry(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }

}