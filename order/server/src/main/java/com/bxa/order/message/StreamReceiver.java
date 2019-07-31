package com.bxa.order.message;

import com.bxa.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Create by 摆欣安
 * 2019/7/25 21:17
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

//    @StreamListener(StreamClient.OUTPUT)
//    public void process(Object message){
//        log.info("message：{}",message);
//    }

    /**
     * 接收orderDTO对象 消息
     * @param message
     */
    @StreamListener(value = StreamClient.OUTPUT)
    @SendTo(StreamClient.INPUT)
    public String process(OrderDTO message) {
        log.info("StreamReceiver: {}", message);
        return "received.";
    }

    @StreamListener(value = StreamClient.INPUT)
    public void process2(String message) {
        log.info("StreamReceiver2: {}", message);
    }
}
