package com.example.server.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @data 2019/12/16
 * @time 10:23
 */
@RestController
@RequestMapping("open")
public class OpenController {

    @Value("${server.port}")
    String port;

    @PostMapping("index")
    public Map<String, Object> index (String name, String age){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        map.put("port", port);
        return map;
    }


    @PostMapping("hystrix_test")
    public Map<String, Object> hystrix_test(String name) {
        System.out.println(name);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        new Thread(()->{
//            System.out.println(1);
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        System.out.println("出来");
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("msg", "success");
        return map;
    }
}
