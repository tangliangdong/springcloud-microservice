package com.example.server.controllers;

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

    @PostMapping("index")
    public Map<String, Object> index (String name, String age){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        return map;
    }
}
