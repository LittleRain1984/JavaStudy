package org.edward.javastudy.rabbitmq.pubsub;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLog {

    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // declare the exchangea and specify the echange name and type
        // Exchange.DeclareOk exchangeDeclare(String exchange, String type)
        // throws IOException;
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        String message = getMessage(args);
        // void basicPublish(String exchange, String routingKey, BasicProperties
        // props, byte[] body) throws IOException;
        // specify the exchange name
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();

    }

    private static String getMessage(String[] strings) {
        if (strings.length < 1)
            return "Hello World!....";
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
