package com.liuf.springboot.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuf
 * @create 2019-06-09 15:35
 * 消息发送者
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitAmqbTemplate;

    /**
     * 发送消息的方法
     * @param msg
     */
    public void send(String msg){
        //向消息队列发送消息
        //arg1:队列的名称
        //arg2:消息
        rabbitAmqbTemplate.convertAndSend("hello-queue",msg);
    }
}
