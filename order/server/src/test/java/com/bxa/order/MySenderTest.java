package com.bxa.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Create by 摆欣安
 * 2019/7/25 20:28
 */
@Component
public class MySenderTest extends OrderApplicationTest{

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("myQueue", "now " + new Date());

    }

    @Test
    public void sendmyMessage() {
        amqpTemplate.convertAndSend("myMessage", "now " + new Date());

    }


    @Test
    public void sendOrder() {
        amqpTemplate.convertAndSend("myOrder", "computer", "now " + new Date());
    }

}
