package org.edward.javastudy.jdk.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest2 {
    public static void main(String[] args) {
        People p1 = new People(1);
        People p2 = new People(2);
        People p3 = new People(3);
        ArrayList<People> list = new ArrayList<People>();

        list.remove(list.size()-1);
    }


}



