package org.edward.javastudy.rabbitmq.helloworld;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Recv {
    private final static String QUEUE_NAME = "helloworld";

    public static void main(String[] argv) throws IOException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // Declare the same queue like the Send.java
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        // void handleDelivery(String consumerTag, Envelope envelope,
        // AMQP.BasicProperties properties, byte[] body)throws IOException;
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                    byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };

        // String basicConsume(String queue, boolean autoAck, Consumer callback)
        // throws IOException;
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}