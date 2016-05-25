~/.m2/repository/com/rabbitmq/amqp-client/2.5.0

java -cp .:~/.m2/repository/com/rabbitmq/amqp-client/2.5.0/amqp-client-2.5.0.jar org.edward.javastudy.mq.workqueue.v1.Worker

java -cp .:commons-io-2.4.jar:commons-cli-1.2.jar:amqp-client-2.5.0.jar org.edward.javastudy.mq.workqueue.v1.Worker



java -cp .:commons-io-2.4.jar:commons-cli-1.2.jar:~/.m2/repository/com/rabbitmq/amqp-client/2.5.0/amqp-client-2.5.0.jar org.edward.javastudy.rabbitmq.workqueues.durability.QOSWorker

java -cp .:commons-io-2.4.jar:commons-cli-1.2.jar:amqp-client-2.5.0.jar org.edward.javastudy.rabbitmq.workqueues.durability.QOSWorker


#start server
sudo nohup rabbitmq-server start &