package org.edward.javastudy.thread;

/**
 * Created by edwardzhu on 6/14/17.
 */
public class CallBackTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            CallBackTest callback = new CallBackTest();
            Calculator calculator = new Calculator(i, 100);
            calculator.setCallback(callback);
            Thread workT = new Thread(calculator);
            workT.start();
        }
    }

    public void showResult(int result) {
//        System.out.println("The caculated result is:" + result);
    }
}

class Calculator implements Runnable {

    private int a;
    private int b;
    private CallBackTest callback;

    Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void setCallback(CallBackTest callback) {
        this.callback = callback;
    }

    @Override public void run() {
        int result = a + b;
        System.out.println("Start to calculator:" + a + "+" + b);
        try {
            System.out.println("Sleep in thread for 3 seconds");
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finish to calculator:" + a + "+" + b);
        callback.showResult(result);
    }
}