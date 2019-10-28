package com.zhouheng.comrabbitmqsecond;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.impl.AMQBasicProperties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class RabbitmqProducerDirect {

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
        //开启confirm确认机制
        channel.confirmSelect();
        //设置confirm监听器
       channel.addConfirmListener(new AngleConfirmListerner());
        //设置return listernr
        channel.addReturnListener(new AngleReturnListener());


//        for (int i = 0; i < 5; i++) {
//            Map<String ,Object> header = new HashMap<>();
//            header.put("num",i+1);
//            //设置消息属性
//            AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder()
//                    .contentEncoding("utf-8")
//                    .contentType("application/json")
//                    .deliveryMode(2).headers(header)
//                    .build();
//            String message="hello--"+i;
//            channel.basicPublish(exchangeName,routingKey,true,basicProperties,message.getBytes());
//        }

        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder().expiration("5").build();

        channel.basicPublish(exchangeName,routingKey,true,basicProperties,"测试消息转为死信队列".getBytes());
    }
}
