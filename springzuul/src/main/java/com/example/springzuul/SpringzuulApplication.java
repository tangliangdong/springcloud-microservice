package com.example.springzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SpringzuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringzuulApplication.class, args);
    }

}
