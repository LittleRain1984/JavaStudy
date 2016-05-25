package org.edward.javastudy.rabbitmq.workqueues.rrdispatch;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * Created by edward on 16-5-23.
 */
public class NewTask {

    private final static String QUEUE_NAME = "work_queues_ex1";

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
        String message = getMessage(argv);

        // void basicPublish(String exchange, String routingKey, BasicProperties
        // props, byte[] body) throws IOException;
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();

    }

    private static String getMessage(String[] strings) {
        if (strings.length < 1)
            return "Hello World!";
        return joinStrings(strings, " ");
    }

    private static String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0)
            return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }

}
