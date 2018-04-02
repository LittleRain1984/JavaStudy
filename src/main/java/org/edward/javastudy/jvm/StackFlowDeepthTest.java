package org.edward.javastudy.jvm;

public class StackFlowDeepthTest{

    private int count = 0;
    private String a;

    public void testAdd(StackFlowDeepthTest t){
        count ++;
        testAdd(t);
    }
    public void test(){
        try{
            testAdd(new StackFlowDeepthTest());
        }catch(Throwable e){
            System.out.println(e);
            System.out.println("栈深度:"+count);
        }
    }
    public static void main(String [] args){
        new StackFlowDeepthTest().test();
    }
}

