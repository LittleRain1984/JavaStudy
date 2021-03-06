package org.edward.javastudy.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by edward on 16-5-23.
 */
public class Send {

    private final static String QUEUE_NAME = "helloworld";

    public static void main(String[] argv) throws java.io.IOException {

        // Create a connection to the server
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // Declare the queue Queue.DeclareOk queueDeclare(String queue, boolean
        // durable, boolean exclusive, boolean autoDelete,
        // Map<String, Object> arguments) throws IOException;
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";

        // void basicPublish(String exchange, String routingKey, BasicProperties
        // props, byte[] body) throws IOException;
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();

    }
}
