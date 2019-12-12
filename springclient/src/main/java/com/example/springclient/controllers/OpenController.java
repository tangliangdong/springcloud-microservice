package com.example.springclient.controllers;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
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
//
//    @Autowired
//    private OpenController(RestTemplate restTemplate){
//        this.restTemplate = restTemplate;
//    }

    @PostMapping("test")
    public String test(){
        Map<String, Object> map = new HashMap<>();
//        String response = restTemplate.postForObject("/open/index", map, String.class);

//        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://SERVER-01:8002/open/index", String.class);

        System.out.println(response);
        return response;
    }
}
