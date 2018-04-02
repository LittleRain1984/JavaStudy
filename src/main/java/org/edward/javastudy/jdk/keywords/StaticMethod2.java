package org.edward.javastudy.jdk.keywords;

public class StaticMethod2 {
    public static void method1() {
        System.out.println("invoking static void method()1");
    }

    public static void main(String[] args) {
//        StaticClass c1 = new StaticClass();
//        StaticClass c2 = new StaticClass();
//
//        c1.sayHello("c1");
//        c2.sayHello("c2");

        StaticClass.sayHello("test");

    }
}

class StaticClass {


    static {
        System.out.println("Initialzing:StaticClass");
    }

    public static void sayHello(String name) {
        System.out.println("Say Hello:" + name);
    }

    static StaticClass2 c3 = new StaticClass2();

    static {
        System.out.println("Shutting down...");
    }


}


class StaticClass2 {
    static {
        System.out.println("Initializing: StaticClass2");
    }

    public void sayHello2() {
        System.out.println("Say Hello2222");
    }

}

