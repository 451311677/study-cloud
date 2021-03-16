package com.zxg.springcloud.service.impl;

import com.zxg.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author xiaogang.zhang
 * @date 2021/3/15
 * @description  消息中间件的service
 */
@EnableBinding(Source.class)   //定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    //消息发送管道
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("******* serial: "+serial);
        return null;
    }
}
