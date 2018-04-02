package org.edward.javastudy.jvm;

import java.util.GregorianCalendar;

/*

-XX:+UnlockDiagnosticVMOptions  -XX:+PrintAssembly
to decompile the source code
 */
public class VolatileTest1 {

    private static Integer counter = 0;

    private static Long locker = 0L;

    private static Object obj = new Object();


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (obj) {

                        for (int i = 0; i < 1000; i++) {
                            Integer temp = counter;
                            counter = counter + 1;
                            locker = locker + 1;
                            if (temp != (counter - 1)) {
                                System.out.println("Current Modify temp: " + temp + "   counter:" + counter);
                            }
                        }


                    }
                }
            });
            t.start();
        }

        while (counter < 20000) {
            System.out.println(GregorianCalendar.getInstance().getTime() + "==>Current Counter is:" + counter);
            Thread.sleep(1000);
        }

        System.out.println("Count: " + counter);
    }
}
