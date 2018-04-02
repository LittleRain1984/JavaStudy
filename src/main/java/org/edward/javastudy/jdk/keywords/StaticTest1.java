package org.edward.javastudy.jdk.keywords;

/**
 * Created by edwardzhu on 4/23/17.
 */
public class StaticTest1 {
    public static void main(String[] args){
        String a = "hello";
        String b = "I am Batman.";

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

    }
}
