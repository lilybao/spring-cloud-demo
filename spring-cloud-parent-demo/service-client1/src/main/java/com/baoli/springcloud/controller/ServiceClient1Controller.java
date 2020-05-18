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
 * @create: 2020-05-18 10:53
 */
@RestController
public class ServiceClient1Controller {
    private static final Logger logger = LoggerFactory.getLogger(ServiceClient1Controller.class);


    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("/hello")
    public String hello() {
        logger.info("calling  trace service-client1");
        return restTemplate.getForObject("http://localhost:8181/hi", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        logger.info(" calling  trace service-client1");
        return " i am service-client1";
    }


}
