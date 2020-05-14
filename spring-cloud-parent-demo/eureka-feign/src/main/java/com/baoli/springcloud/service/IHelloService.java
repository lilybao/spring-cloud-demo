package com.baoli.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",fallback = HelloErrorFallback.class)
public interface IHelloService {
    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);
}
