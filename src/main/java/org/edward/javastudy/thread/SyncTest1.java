package org.edward.javastudy.thread;

public class SyncTest1 {
    public static void main(String[] args) {

        BankAccount ba = new BankAccount();
        Thread t1 = new Thread(ba);
        Thread t2 = new Thread(ba);
        Thread t3 = new Thread(ba);

        t1.start();
        t2.start();
        t3.start();

        while (true) {
            if (t1.getState() == t2.getState() && t1.getState() == t3.getState() && t1.getState() == Thread.State.TERMINATED) {
                System.out.println("Final bank account balance: " + ba.balance);
                return;
            }
        }
    }

}

class BankAccount implements Runnable {

    public volatile int balance;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            increment();
            System.out.println(Thread.currentThread().getId() + "  current balance is:" + balance);
        }
    }

    private void increment() {
        int i = balance;

        try {
            Thread.currentThread().sleep(10);
            if (Thread.currentThread().getId() % 2 == 1 && balance > 30) {
                System.out.println("current i is:" + i);
                Thread.currentThread().sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        balance = i + 1;
    }
}
