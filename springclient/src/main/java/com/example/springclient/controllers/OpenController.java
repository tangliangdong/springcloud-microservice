package com.example.springclient.controllers;

import com.example.springclient.consumers.OpenClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @data 2019/12/12
 * @time 15:45
 */
@RestController
@RequestMapping("open")
public class OpenController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OpenClient openClient;

    @PostMapping("index")
    public Map<String, Object> getIndex(String name, String age){
        return openClient.getIndex(name, age);
    }

    @PostMapping("test")
    public String test(String name, String age){
        MultiValueMap<String, Object> map = new LinkedMultiValueMap();
        map.add("name", name);
        map.add("age", age);
        String response = restTemplate.postForObject("http://SERVER-01/open/index", map, String.class);

        System.out.println(response);
        return response;
    }

    @PostMapping("hystrix_test")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Map<String, Object> hystrix_test(String name){
        Map<String, Object> map = openClient.hystrix_test(name);
        System.out.println("成功接收到消息");
        return map;
    }

    public Map<String, Object> processHystrix_Get(String name){
        Map<String, Object> map = new HashMap<>();

        map.put("name", name);
        map.put("msg", "服务熔断");
        return map;
    }

}
