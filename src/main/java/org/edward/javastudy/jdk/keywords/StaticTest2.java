package org.edward.javastudy.jdk.keywords;

public class StaticTest2 {
    private static VariableA va1 = new VariableA("va1");

    static {
        System.out.println("static block I");
    }

    private static VariableA va2 = new VariableA("va2");

    static {
        System.out.println("static block II");
    }

    public static void main(String[] args) {

    }

    static class VariableA {
        VariableA(String a) {
            System.out.println("Constructor VariableA: " + a);
        }
    }
}
