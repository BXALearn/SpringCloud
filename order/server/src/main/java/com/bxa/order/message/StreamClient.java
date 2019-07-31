package com.bxa.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Create by 摆欣安
 * 2019/7/25 21:15
 */
public interface StreamClient {

    String INPUT = "myMessage";

    String OUTPUT = "bxaMessage";

//    @Input(StreamClient.INPUT)
//    SubscribableChannel input();
//
//    @Output(StreamClient.INPUT2)
//    MessageChannel output();

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

}
