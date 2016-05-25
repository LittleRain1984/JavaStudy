~/.m2/repository/com/rabbitmq/amqp-client/2.5.0

java -cp .:~/.m2/repository/com/rabbitmq/amqp-client/2.5.0/amqp-client-2.5.0.jar org.edward.javastudy.mq.workqueue.v1.Worker

java -cp .:commons-io-2.4.jar:commons-cli-1.2.jar:amqp-client-2.5.0.jar org.edward.javastudy.mq.workqueue.v1.Worker



java -cp .:commons-io-2.4.jar:commons-cli-1.2.jar:~/.m2/repository/com/rabbitmq/amqp-client/2.5.0/amqp-client-2.5.0.jar org.edward.javastudy.rabbitmq.workqueues.durability.QOSWorker

java -cp .:commons-io-2.4.jar:commons-cli-1.2.jar:amqp-client-2.5.0.jar org.edward.javastudy.rabbitmq.workqueues.durability.QOSWorker


#start server
sudo nohup rabbitmq-server start &


#RabbitMQ Notes
durable: 
boolean durable = true;//indicate whether the queue is durable at both producer and consumer side
channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);


acknowledge: 
in the consumer:
boolean autoAck = false;
channel.basicConsume(TASK_QUEUE_NAME, autoAck, consumer)//if the autoAck is set to true, the consumer would send back the ** acknowledge immediately once it received the message
channel.basicAck(envelope.getDeliveryTag(), false);//send back the acknowledge manually by code

Qos:
producer:
channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
consumer:
channel.basicQos(1);