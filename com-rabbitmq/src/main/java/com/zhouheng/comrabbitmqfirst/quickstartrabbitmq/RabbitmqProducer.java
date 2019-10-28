package com.zhouheng.comrabbitmqfirst.quickstartrabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitmqProducer {

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("192.168.174.128");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("tuling");
        connectionFactory.setUsername("zhouheng");
        connectionFactory.setPassword("123456");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        String exchangeName  = "tuling-change-01";
        String routingKey = "tuling.directchange.key";

        for (int i = 0; i < 5; i++) {
            String message="hello--"+i;
            channel.basicPublish(exchangeName,routingKey,null,message.getBytes());
        }

        channel.close();
        connection.close();

    }
}
