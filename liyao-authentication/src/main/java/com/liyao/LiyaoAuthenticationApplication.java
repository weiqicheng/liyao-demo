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
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableScheduling
//@MapperScan("com.liyao.*.mapper.*")
@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@ComponentScan
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableFeignClients
@EnableCircuitBreaker//对hystrix熔断机制的支持，使用hystrix监控仪表盘时也需要此注解
public class LiyaoAuthenticationApplication {


    protected static Logger logger = LoggerFactory.getLogger(LiyaoAuthenticationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LiyaoAuthenticationApplication.class, args);
        chengge();
    }

    public static void chengge() {
        System.out.println("用来测试通知！");
    }
}
