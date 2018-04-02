package org.edward.javastudy.jdk.polymorphism;


//Override的方法
//子类中符合的
class A2 {
    public String show(D2 obj) {
        return ("A and D");
    }

    public String show(C2 obj) {
        return ("A and C");
    }

    public String show(A2 obj) {
        return ("A and A");
    }

}

class B2 extends A2 {
    public String show(B2 obj) {
        return ("B and B");
    }

    public String show(A2 obj) {
        return ("B and A");
    }

}

class C2 extends B2 {

}

class D2 extends B2 {

}

public class Test2 {
    public static void main(String[] args) {
        A2 a1 = new A2();
        A2 a2 = new B2();
        B2 b = new B2();
        C2 c = new C2();
        D2 d = new D2();

        System.out.println("1--" + a1.show(b));
        System.out.println("2--" + a1.show(c));
        System.out.println("3--" + a1.show(d));
        System.out.println("4--" + a2.show(b));
        System.out.println("5--" + a2.show(c));
        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));
    }
}
