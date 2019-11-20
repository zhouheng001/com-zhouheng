package com.zhouheng.comrabbitmqsecond;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class RabbitmqConsumerDirect {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("47.94.103.156");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("zhouheng");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        String queueName ="tuling_queue_01";
        String exchangeName  = "tuling-change-01";
        String exchangeType ="direct";
        String routingKey = "tuling.directchange.key";

        String dlxExchangeName= "tuling-dlxchange-01";
        String dlxQueueName="tuling_dlxqueue_01";

        //声明一个正常队列
        channel.exchangeDeclare(exchangeName,exchangeType,true,false,null);
        Map<String ,Object> argurments = new HashMap<>();
        argurments.put("x-dead-letter-exchange",dlxExchangeName);
        channel.queueDeclare(queueName,true,false,true,argurments);
        channel.queueBind(queueName,exchangeName,routingKey);

        //声明一个死信队列
        channel.exchangeDeclare(dlxExchangeName,"topic",true,true,false,null);
        channel.queueDeclare(dlxQueueName,true,true,true,null);
        channel.queueBind(dlxQueueName,dlxExchangeName,"#");

//        channel.basicQos(0,1,false);


        channel.basicConsume(queueName,false,new AngleCustomConsumer(channel));


    }
}
