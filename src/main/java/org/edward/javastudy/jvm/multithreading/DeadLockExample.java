package org.edward.javastudy.jvm.multithreading;

public class DeadLockExample {
    public static void main(String[] args) {
        DeadLockObject deadLockObject = new DeadLockObject();

        WorkTheaderA wta = new WorkTheaderA(deadLockObject);
        WorkTheaderB wtb = new WorkTheaderB(deadLockObject);

        Thread ta = new Thread(wta);
        Thread tb = new Thread(wtb);

        ta.start();
        tb.start();
    }

}

class WorkTheaderA implements Runnable {
    DeadLockObject deadlock;

    public WorkTheaderA(DeadLockObject deadLockObject) {
        this.deadlock = deadLockObject;
    }

    @Override
    public void run() {
        deadlock.leftRight();
    }
}

class WorkTheaderB implements Runnable {
    DeadLockObject deadlock;

    public WorkTheaderB(DeadLockObject deadLockObject) {
        this.deadlock = deadLockObject;
    }

    @Override
    public void run() {
        deadlock.rightLeft();
    }
}

class DeadLockObject {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            try {
                Thread.sleep(200);

                synchronized (right) {
                    Thread.sleep(200);
                    System.out.println("method leftRight done.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            try {
                Thread.sleep(200);

                synchronized (left) {
                    Thread.sleep(200);
                    System.out.println("method rightLeft done.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
