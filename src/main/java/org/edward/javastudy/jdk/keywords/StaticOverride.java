package org.edward.javastudy.jdk.keywords;

public class StaticOverride {
    public static void main(String[] args) {
        A a = new B();
        a.method1();
    }
}


class A {
    public static void method1() {
        System.out.println("in class A");
    }
}

class B extends A {

    public static void method1() {
        System.out.println("in class B");
    }
}