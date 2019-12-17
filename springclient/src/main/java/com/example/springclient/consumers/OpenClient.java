package com.example.springclient.consumers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author Administrator
 * @data 2019/12/17
 * @time 9:31
 */
@FeignClient("SERVER-01")
public interface OpenClient {

    @PostMapping("open/index")
    Map<String, Object> getIndex(@RequestParam("name") String name, @RequestParam("age") String age);

}
