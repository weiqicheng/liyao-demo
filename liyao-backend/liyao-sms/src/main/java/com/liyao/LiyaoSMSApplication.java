package com.liyao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 消息服务
 *
 */
@EnableScheduling
@ComponentScan
//@MapperScan("com.liyao.*.mapper.*")
@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker//对hystrix熔断机制的支持，使用hystrix监控仪表盘时也需要此注解
public class LiyaoSMSApplication {


    private static Logger logger = LoggerFactory.getLogger(LiyaoSMSApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(LiyaoSMSApplication.class, args);
    }

}