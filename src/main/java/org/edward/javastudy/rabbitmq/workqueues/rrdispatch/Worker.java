package org.edward.javastudy.rabbitmq.workqueues.rrdispatch;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Worker {
    private final static String QUEUE_NAME = "work_queues_ex1";

    public static void main(String[] argv) throws IOException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // Declare the same queue like the NewTask.java
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        // void handleDelivery(String consumerTag, Envelope envelope,
        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                    byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println(" [x] Received '" + message + "'");
                try {
                    doWork(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(" [x] Done");
                }
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }

    private static void doWork(String task) throws InterruptedException {
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                System.out.println("Sleeping...");
                Thread.sleep(1000);
            }
        }
    }
}