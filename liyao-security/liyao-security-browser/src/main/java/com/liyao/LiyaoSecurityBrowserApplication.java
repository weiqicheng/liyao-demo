package com.liyao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableScheduling
//@MapperScan("com.liyao.*.mapper.*")
@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@ComponentScan
//启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableTransactionManagement
@EnableFeignClients
//对hystrix熔断机制的支持，使用hystrix监控仪表盘时也需要此注解
@EnableCircuitBreaker
public class LiyaoSecurityBrowserApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiyaoSecurityBrowserApplication.class, args);

    }
}
