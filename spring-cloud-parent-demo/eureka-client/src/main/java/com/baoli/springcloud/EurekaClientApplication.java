package com.baoli.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @program: spring-cloud-parent-demo
 * @description: EurekaClinet需要注册的客户端
 * @author: li baojian
 * @create: 2020-05-13 22:14
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "client") String name) {
        return "hello" + name + " my port is " + port;
    }

    @RequestMapping("/hello1")
    public String hello1(@RequestParam(value = "name", defaultValue = "client") String name, HttpServletRequest request) {
        String s1 = request.toString();
        String s = request.getHeaderNames().toString();
        Enumeration<String> headerNames = request.getHeaderNames();
        StringBuffer stringBuffer = new StringBuffer();
        while (headerNames.hasMoreElements()) {
            String s2 = headerNames.nextElement();
            stringBuffer.append(s2+" : "+request.getHeader(s2)+"\n");
        }
        return stringBuffer.toString();
    }
}
