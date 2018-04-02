package org.edward.javastudy.jvm;

public class StaticTypeAssignment {
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        StaticTypeAssignment stdt = new StaticTypeAssignment();
        stdt.sayHello(man);
        stdt.sayHello(woman);
    }


    public void sayHello(Human human) {
        System.out.println("Hello Human.");
    }

    public void sayHello(Man man) {
        System.out.println("Hello man.");
    }

    public void sayHello(Woman woman) {
        System.out.println("Hello woman.");
    }


}

class Human

{

}

class Man extends Human {
}

class Woman extends Human {
}