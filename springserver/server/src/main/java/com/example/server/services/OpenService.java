package com.example.server.services;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @data 2019/12/16
 * @time 10:52
 */
public class OpenService {

    public Map<String, Object> index (String name, String age){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        return map;
    }
}
