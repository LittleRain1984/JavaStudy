package org.edward.javastudy.jvm;

import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicInteger;

/*

-XX:+UnlockDiagnosticVMOptions  -XX:+PrintAssembly
to decompile the source code
 */
public class VolatileTest2 {

    private static AtomicInteger counter = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (counter) {
                        for (int i = 0; i < 1000; i++) {
                            counter.getAndIncrement();
                        }
                    }
                }
            });
            t.start();
        }

        while (counter.get() < 20000) {
            System.out.println(GregorianCalendar.getInstance().getTime() + "==>Current Counter is:" + counter);
            Thread.sleep(1000);
        }

        System.out.println("Count: " + counter);
    }
}
