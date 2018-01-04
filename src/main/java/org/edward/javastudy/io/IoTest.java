package org.edward.javastudy.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by edwardzhu on 6/13/17.
 */
public class IoTest {
    public static void main(String[] args) {
        List<String> array  = new ArrayList<String>();
        array.add("a");
        array.add("b");
        array.add("c");
        array.add("d");
        array.add("e");
        Iterator<String> it = array.iterator();
        while(it.hasNext()){
            String a = it.next();
            if(a.equals("c")){
                it.remove();
            }
        }

        for(String a: array) {
            System.out.println(a);
        }

    }
}
