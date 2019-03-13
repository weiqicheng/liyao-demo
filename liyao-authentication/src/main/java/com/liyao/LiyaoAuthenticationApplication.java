package com.liyao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
//@MapperScan("com.liyao.*.mapper.*")
@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@ComponentScan
@EnableFeignClients
public class LiyaoAuthenticationApplication {


    protected static Logger logger = LoggerFactory.getLogger(LiyaoAuthenticationApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(LiyaoAuthenticationApplication.class, args);
    }

}
