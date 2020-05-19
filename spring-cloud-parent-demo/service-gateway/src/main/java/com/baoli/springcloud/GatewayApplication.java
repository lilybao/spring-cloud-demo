package com.baoli.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @program: spring-cloud-demo
 * @description: gateway网关快速启动类
 * @author: li baojian
 * @create: 2020-05-19 11:06
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String uri = "http://localhost:8082";
        return builder.routes()
                .route(p -> p
                        .path("/hello1")
                        .filters(f -> f.addRequestHeader("Type", "GateWay"))
                        .uri(uri))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(uri))
                .build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback(){
        System.out.println("fallback");
        return Mono.just("fallback");
    }
}
