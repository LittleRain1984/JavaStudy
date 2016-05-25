package org.edward.javastudy.rabbitmq.workqueues.durability;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class NewTask {

    private static final String TASK_QUEUE_NAME = "work_queues_manageack";

    public static void main(String[] argv) throws Exception {
        String message = getMessage(argv);

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // ueue.DeclareOk queueDeclare(String queue, boolean durable, boolean
        // exclusive, boolean autoDelete,
        // Map<String, Object> arguments) throws IOException;
        boolean durable = false;
        channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);

        // Whether the message need to be saved when mq server is shutting down
        // is depends on the BasicProperties that you set on the message. if it
        // is null, do not save, otherwise save.
        channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
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