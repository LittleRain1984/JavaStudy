package org.edward.javastudy.designpattern.singleton;

public class DoubleLockThreadSafeSingletonObject {

    private static DoubleLockThreadSafeSingletonObject instance = null;

    private DoubleLockThreadSafeSingletonObject() {
    }

    public static DoubleLockThreadSafeSingletonObject getInstance() {
        if (instance == null) {
            synchronized (DoubleLockThreadSafeSingletonObject.class) {
                if (instance == null) {
                    instance = new DoubleLockThreadSafeSingletonObject();
                }
            }
        }

        return instance;

    }
}
