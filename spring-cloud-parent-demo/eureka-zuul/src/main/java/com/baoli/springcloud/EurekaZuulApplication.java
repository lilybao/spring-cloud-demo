package com.baoli.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: spring-cloud-demo
 * @description: zuul启动类
 * @author: li baojian
 * @create: 2020-05-14 14:22
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class EurekaZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaZuulApplication.class, args);
    }
}
