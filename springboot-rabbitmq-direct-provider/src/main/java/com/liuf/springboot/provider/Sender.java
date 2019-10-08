package com.liuf.springboot.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuf
 * @create 2019-06-09 16:56
 */
@Component
public class Sender {


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    @Value("${mq.config.queue.error.routint.key}")
    private String routingkey;

//    public void send(String msg) throws Exception{
//        //向消息队列发送消息
//        //arg1：交换器
//        //arg2：路由建
//        //arg3：消息
////        MessageProperties messageProperties = new MessageProperties();
////        messageProperties.setContentType("text/plain");
////        Message message = new Message(msg.getBytes("UTF-8"),messageProperties);
////        amqpTemplate.convertAndSend(exchange,routingkey,msg);
//        MessageProperties messageProperties = new MessageProperties();
//        Message message = new Message(msg.getBytes("UTF-8"),messageProperties);
//        amqpTemplate.send(exchange,routingkey,message);
////        amqpTemplate.send();
//
//    }

    public void send(String msg) throws Exception{
        //向消息队列发送消息
        //arg1：交换器
        //arg2：路由建
        //arg3：消息
        amqpTemplate.convertAndSend(exchange,routingkey,msg);
    }
}

