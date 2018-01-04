package org.edward.javastudy.thread;

public class TicketSellingTest {
    public static void main(String[] args) {
        Runnable task = new TicketSellingThread();
        Thread t = new Thread(task);
        Thread t2 = new Thread(task);
        t.start();
        t2.start();
    }
}


class TicketSellingThread implements Runnable {
    private int iTotalTickets = 100;

    @Override
    public void run() {
        for (int i = 0; i < 150; i++) {
            synchronized (this) {
                if (iTotalTickets > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + " thread getting one ticket, remaing tickets: " + --iTotalTickets);
                } else {
                    System.out.println("There is no more tickets.");
                }
            }
        }
    }
}
