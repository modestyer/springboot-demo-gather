package com.liuf.springboot.controller;

import com.liuf.springboot.util.JacksonJsonUtil;
import com.liuf.springboot.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liuf
 * @create 2019-09-09 20:36
 */
@RestController
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/getRoi")
    public String getRedisRoi(){
        Map<Object, Object> index_roi_report = redisUtils.hmget("INDEX_ROI_REPORT");


        return JacksonJsonUtil.beanToJson(index_roi_report);
    }
}
