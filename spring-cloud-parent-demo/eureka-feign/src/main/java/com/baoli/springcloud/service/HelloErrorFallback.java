package com.baoli.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @program: spring-cloud-demo
 * @description: erroe
 * @author: li baojian
 * @create: 2020-05-14 11:34
 */
@Component
public class HelloErrorFallback implements IHelloService {

    @Override
    public String hello(String name) {
        return "sorry "+name+" is error!";
    }
}
