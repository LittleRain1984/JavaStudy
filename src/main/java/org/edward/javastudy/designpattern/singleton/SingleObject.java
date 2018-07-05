package org.edward.javastudy.designpattern.singleton;

public class SingleObject {

    private static final SingleObject instance = new SingleObject();

    private SingleObject() {
    }

    public static SingleObject getInstance() {
        return instance;
    }
}
