package org.edward.javastudy.designpattern.singleton;

public class BillPughThreadSafeSingletonObject {

    private BillPughThreadSafeSingletonObject() {
    }

    public static BillPughThreadSafeSingletonObject getInstance() {
        return SingletonHelper.INSTANCE;
    }


    private static class SingletonHelper {
        private static final BillPughThreadSafeSingletonObject INSTANCE = new BillPughThreadSafeSingletonObject();
    }
}

