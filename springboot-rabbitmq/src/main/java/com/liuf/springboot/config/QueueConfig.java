package com.liuf.springboot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuf
 * @create 2019-06-09 15:33
 */
@Configuration
public class QueueConfig {

    @Bean
    public Queue createQueue(){
        return new Queue("hello-queue");
    }
}
