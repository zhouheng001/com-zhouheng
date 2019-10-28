package com.zhouheng.comrabbitmqsecond;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

public class AngleCustomConsumer extends DefaultConsumer {

    private Channel channel;
    /**
     * Constructs a new instance and records its association to the passed-in channel.
     *
     * @param channel the channel to which this consumer is attached
     */
    public AngleCustomConsumer(Channel channel) {
        super(channel);
        this.channel=channel;
    }

    /**
     * 处理消息
     * @param consumerTag
     * @param envelope
     * @param properties
     * @param body
     * @throws IOException
     */
    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

        System.out.println("自定义的消息消费端");
        System.out.println("consumerTag="+consumerTag);
        System.out.println("envelope="+envelope);
        System.out.println("properties="+properties);
        System.out.println("body="+new String(body));

       //channel.basicAck(envelope.getDeliveryTag(),false);

        //channel.basicReject(envelope.getDeliveryTag(),false);

        //把消息变为死信,通过nack且requeue不进行重新发送
        channel.basicNack(envelope.getDeliveryTag(),false,true);
    }
}
