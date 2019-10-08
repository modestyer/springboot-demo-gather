package com.liuf.springboot.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author liuf
 * @create 2019-06-09 16:56
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    public void send(String msg){
        //向消息队列发送消息
        //arg1：交换器
        //arg2：路由建
        //arg3：消息
        amqpTemplate.convertAndSend(exchange,"",msg);

    }
}

