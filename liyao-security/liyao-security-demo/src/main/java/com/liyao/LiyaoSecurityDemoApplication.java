package com.liyao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//@MapperScan("com.liyao.*.mapper.*")
@SpringBootApplication
@EnableEurekaClient
@ComponentScan
@EnableFeignClients
@EnableAutoConfiguration
//对hystrix熔断机制的支持，使用hystrix监控仪表盘时也需要此注解
@EnableCircuitBreaker
public class LiyaoSecurityDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiyaoSecurityDemoApplication.class, args);
    }
}
