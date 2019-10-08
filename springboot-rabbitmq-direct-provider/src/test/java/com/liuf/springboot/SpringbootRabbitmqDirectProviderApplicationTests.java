package com.liuf.springboot;

import com.liuf.springboot.provider.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqDirectProviderApplicationTests {

    @Autowired
    private Sender sender;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void contextLoads() {
    }

    /**
     * 测试消息队列
     */
    @Test
    public void test1(){
        try {
//            sender.send("{\"name\":\"zhangsan\",\"password\":\"zhangsan123\",\"email\":\"10371443@qq.com\"}");
            sender.send("hello world!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test2(){

    }

}
