package com.baoli.springcloud.controller;

import com.baoli.springcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud-demo
 * @description: hello  类
 * @author: li baojian
 * @create: 2020-05-14 09:12
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        return helloService.hello(name);
    }
}
