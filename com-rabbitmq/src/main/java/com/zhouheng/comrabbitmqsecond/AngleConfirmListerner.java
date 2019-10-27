package com.zhouheng.comrabbitmqsecond;

import com.rabbitmq.client.ConfirmListener;

import java.io.IOException;

public class AngleConfirmListerner implements ConfirmListener {

    @Override
    public void handleAck(long deliveryTag, boolean multiple) throws IOException {
        System.out.println("消息deliverTag"+deliveryTag+"被正常签收");
    }

    @Override
    public void handleNack(long deliveryTag, boolean multiple) throws IOException {
        System.out.println("消息deliverTag"+deliveryTag+"没被常签收");
    }
}
