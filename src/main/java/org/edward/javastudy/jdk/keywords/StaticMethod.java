package org.edward.javastudy.jdk.keywords;

public class StaticMethod {
    public static void method1() {
        System.out.println("invoking static void method()1");
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 100; i++) {
                StaticMethod.method1();
                Thread.sleep(100000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

