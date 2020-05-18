package com.baoli.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: spring-cloud-demo
 * @description: service Hystrix 快速启动类
 * @author: li baojian
 * @create: 2020-05-18 15:33
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ServiceHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHystrixApplication.class);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    public RestTemplate restTemplate;


    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(@RequestParam(value = "name", defaultValue = "hystrix") String name) {
        return "hi " + name + ",i am from port：" + port;
    }

    @RequestMapping("/hello1")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hello1(@RequestParam(value = "name", defaultValue = "hystrix") String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hello?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
