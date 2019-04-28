package com.liyao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class LiyaoConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiyaoConfigApplication.class, args);
    }

}
