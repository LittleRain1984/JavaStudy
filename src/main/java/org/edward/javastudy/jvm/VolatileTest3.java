package org.edward.javastudy.jvm;

import java.util.GregorianCalendar;

/*

-XX:+UnlockDiagnosticVMOptions  -XX:+PrintAssembly
to decompile the source code
 */
public class VolatileTest3 {

    private volatile Integer counter = 0;

    private Object obj = new Object();


    public void work() {
        for (int i = 0; i < 200; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getId() + "   thread is starting run() method.");
                        for (int i = 0; i < 100; i++) {
                            counter++;
                        }

                        System.out.println(Thread.currentThread().getId() + "   thread is leaving run() method.");
                    }
                }
            });
            t.start();
        }
    }

    public synchronized Integer increase(Integer i) {
        return i = i + 1;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest3 instance = new VolatileTest3();
        instance.work();


        while (instance.counter < 20000) {
            System.out.println(GregorianCalendar.getInstance().getTime() + "==>Current Counter is:" + instance.counter);
            Thread.sleep(1000);
        }

        System.out.println("Count: " + instance.counter);
    }
}
