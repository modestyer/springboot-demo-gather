package com.liuf.springboot.springbootrabbitmq;

import com.liuf.springboot.SpringbootRabbitmqApplication;
import com.liuf.springboot.provider.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRabbitmqApplication.class)
public class SpringbootRabbitmqApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void contextLoads() {
    }

    /**
     * 测试消息队列
     */
    @Test
    public void test1(){
        sender.send("hello rabbitmq");
    }
}
