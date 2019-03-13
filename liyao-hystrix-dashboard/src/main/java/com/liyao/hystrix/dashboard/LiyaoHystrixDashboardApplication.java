package com.liyao.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class LiyaoHystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiyaoHystrixDashboardApplication.class, args);
    }
}
