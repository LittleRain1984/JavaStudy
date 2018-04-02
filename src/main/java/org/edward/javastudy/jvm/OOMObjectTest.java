package org.edward.javastudy.jvm;

import java.util.ArrayList;
import java.util.List;

public class OOMObjectTest {
    public static void main(String[] args) {
        List<OOMObjectTest> list =  new ArrayList<OOMObjectTest>();
        while(true){
            list.add(new OOMObjectTest());
        }
    }
}
