package org.edward.javastudy.jvm;

public class StackFrameSlotVariableMemoryGC {
    public static void main(String[] args) {
        {
            byte[] placeHolder = new byte[128 * 1024 * 1024];
        }

        int a = 0;
        //placeHolder = null;
        System.out.println(a);
        System.gc();

        {
            byte[] placeHolder = new byte[128 * 1024 * 1024];
        }
        int b = 0;
        System.gc();
    }
}

