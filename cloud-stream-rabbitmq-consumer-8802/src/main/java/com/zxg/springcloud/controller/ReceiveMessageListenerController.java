package com.zxg.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.WriteBuffer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @author xiaogang.zhang
 * @date 2021/3/15
 * @description
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        log.info("消费者 "+serverPort+" 号，---》接收到的消息： "+message.getPayload()+"\t port: "+serverPort);
    }

}
