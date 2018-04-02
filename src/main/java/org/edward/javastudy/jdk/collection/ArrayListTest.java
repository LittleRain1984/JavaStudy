package org.edward.javastudy.jdk.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");

        String[] srcArray = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] dstArray = new String[]{"y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y"};

        System.arraycopy(srcArray, 3, dstArray, 5, 2);

        for(String s: dstArray) {
            System.out.print(s);
        }
    }
}
