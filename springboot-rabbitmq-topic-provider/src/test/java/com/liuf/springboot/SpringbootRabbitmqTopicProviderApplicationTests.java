package com.liuf.springboot;

import com.liuf.springboot.provider.OrderSender;
import com.liuf.springboot.provider.ProductSender;
import com.liuf.springboot.provider.UserSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqTopicProviderApplicationTests {

    @Autowired
    private UserSender userSender;

    @Autowired
    private ProductSender productSender;

    @Autowired
    private OrderSender orderSender;

    @Test
    public void contextLoads() {
    }

    /**
     * 测试消息队列
     */
    @Test
    public void test1(){
        userSender.send("userSender......");
        productSender.send("productSender......");
        orderSender.send("orderSender......");
    }
}
