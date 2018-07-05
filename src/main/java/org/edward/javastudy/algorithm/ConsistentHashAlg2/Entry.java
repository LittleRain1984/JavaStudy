package org.edward.javastudy.algorithm.ConsistentHashAlg2;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class Entry implements Comparable {
    private String key;

    public Entry(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return this.hashCode()- o.hashCode();
    }
}