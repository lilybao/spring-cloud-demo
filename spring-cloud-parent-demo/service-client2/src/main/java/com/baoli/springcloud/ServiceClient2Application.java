package com.baoli.springcloud;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @program: spring-cloud-demo
 * @description: service client2 快速启动类
 * @author: li baojian
 * @create: 2020-05-18 11:04
 */
@SpringBootApplication
public class ServiceClient2Application {
    public static void main(String[] args) {
        SpringApplication.run(ServiceClient2Application.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
