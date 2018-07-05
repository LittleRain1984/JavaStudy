package org.edward.javastudy.jvm;

import java.util.Stack;

public class GCTest1 {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.add(new GCObject1("ob1"));
        s.add(new GCObject1("ob2"));

        s.pop();
        s.pop();
    }

}

class GCObject1 {
    private String name;
    GCObject1(String name){
        this.name = name;
    }
}
