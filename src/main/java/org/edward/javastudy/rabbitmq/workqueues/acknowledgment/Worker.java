package org.edward.javastudy.rabbitmq.workqueues.acknowledgment;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Worker {

    private static final String TASK_QUEUE_NAME = "work_queues_acknowledgment";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, false, false, false, null);
        System.out.println(
                " [*] Waiting for messages. To exit press CTRL+C" + "    " + Worker.class.getPackage().getName());

        channel.basicQos(1);

        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                    byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println(" [x] Received '" + message + "'");
                try {
                    doWork(message);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    System.out.println(" [x] Done");
                    //channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        // It is very important to set the autoAck to false to make the
        // acknowledge must be returned the explicit code
        // String basicConsume(String queue, boolean autoAck, Consumer callback)
        // throws IOException;
        boolean autoAck = true;
        System.out.println(channel.basicConsume(TASK_QUEUE_NAME, autoAck, consumer));

    }

    private static void doWork(String task) throws InterruptedException {
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                System.out.println("Sleeping......");
                Thread.sleep(1000);
            }

        }
    }
}
