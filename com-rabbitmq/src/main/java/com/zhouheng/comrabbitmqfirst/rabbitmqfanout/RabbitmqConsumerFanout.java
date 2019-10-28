package com.zhouheng.comrabbitmqfirst.rabbitmqfanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitmqConsumerFanout {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("192.168.174.128");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("tuling");
        connectionFactory.setUsername("zhouheng");
        connectionFactory.setPassword("123456");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        String queueName ="tuling_queue_01";
        String exchangeName  = "tuling-changefanout-01";
        String exchangeType ="fanout";
        String routingKey = "tuling.directchange.key564654";

        channel.exchangeDeclare(exchangeName,exchangeType,true,false,null);

        channel.queueDeclare(queueName,true,false,true,null);

        channel.queueBind(queueName,exchangeName,routingKey);

        channel.basicQos(0,1,false);

        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        channel.basicConsume(queueName,true,queueingConsumer);

        while (true){
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String s = new String(delivery.getBody());
            System.out.println("消费消息:"+s);
        }

    }
}
