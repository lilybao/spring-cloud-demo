package com.baoli.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: spring-cloud-demo
 * @description:
 * @author: li baojian
 * @create: 2020-05-18 11:05
 */
@RestController
public class ServiceClient2Controller {
    private static final Logger logger = LoggerFactory.getLogger(ServiceClient2Controller.class);


    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String hi() {
        logger.info("calling trace service-client2");
        return "hi  i am service-client2";
    }


    @RequestMapping("/hello")
    public String hello() {
        return restTemplate.getForObject("http://localhost:8180/info", String.class);
    }
}
