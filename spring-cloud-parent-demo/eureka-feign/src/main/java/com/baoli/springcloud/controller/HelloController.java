package com.baoli.springcloud.controller;

import com.baoli.springcloud.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud-demo
 * @description: hello
 * @author: li baojian
 * @create: 2020-05-14 11:05
 */
@RestController
public class HelloController {

    @Autowired
    IHelloService helloService;

    @GetMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        return helloService.hello(name);
    }
}
