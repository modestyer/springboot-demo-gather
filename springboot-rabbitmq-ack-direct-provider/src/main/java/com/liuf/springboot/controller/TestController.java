package com.liuf.springboot.controller;

import com.liuf.springboot.util.JacksonJsonUtil;
import com.liuf.springboot.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuf
 * @create 2019-09-08 17:59
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public ResultMsg test() throws Exception{
        //header参数
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //放入body中的json参数
        Map<String, Object> map = new HashMap<>();
        map.put("taskId", "1");
        map.put("deviceNum","10215");
        map.put("deviceId","10");
        map.put("imgName","test");
        map.put("imgTime","2019-09-08 17:17:52");
        FileInputStream fin1 = new FileInputStream("D:/20190810112144.jpg");
        int length = 1024;
        try (FileInputStream fin = new FileInputStream("D:/20190810112144.jpg");
             FileOutputStream fon = new FileOutputStream("D:/20190810112144dsdsd.jpg");){


            byte[] bytes = new byte[length];

            int len = 0;
            while ((len = fin.read(bytes))!=-1){
                length +=len;
                fon.write(bytes,0,len);
            }
        }
        System.out.println(length-1024);
        byte[] bytes = new byte[length-1024];
        System.out.println(bytes.length);
        fin1.read(bytes);
        map.put("imgData", bytes);
        FileOutputStream fon = new FileOutputStream("D:/sdsds12.jpg");
        fon.write(bytes,0,length-1024);
        fon.close();
        String json = JacksonJsonUtil.beanToJson(map);
        //组装
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        return restTemplate.postForObject("http://127.0.0.1:8091/lenovo-iir/handle-device/task/image/upload", request, ResultMsg.class);
//        return ResultMsg.getResultMsg(false,"sds",200);
    }


    /*public String setIpAndPort(){
        restTemplate.getForObject("http://10.0.4.72:8088/cfg_set?ipaddr=192.168.9.130&port=8080&keepalive=5&prefix=",)
    }*/

    @GetMapping("/heart_beat")
    public String getHeartBeat(String deviceIp){
        System.out.println(deviceIp);
        return deviceIp;
    }
}

