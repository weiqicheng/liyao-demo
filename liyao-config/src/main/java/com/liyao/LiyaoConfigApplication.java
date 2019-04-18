package com.liyao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableConfigServer
public class LiyaoConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiyaoConfigApplication.class, args);
    }

}
