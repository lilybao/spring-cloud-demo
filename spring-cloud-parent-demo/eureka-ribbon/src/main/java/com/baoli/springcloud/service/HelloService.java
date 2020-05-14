package com.baoli.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @program: spring-cloud-demo
 * @description: 转发服务  负载均衡
 * @author: li baojian
 * @create: 2020-05-14 09:04
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String hello(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hello?name=" + name, String.class);
    }

    public String helloError(String name) {
        return "hello " + name + "is error!";
    }
}
