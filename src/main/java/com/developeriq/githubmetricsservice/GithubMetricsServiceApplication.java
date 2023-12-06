package com.developeriq.githubmetricsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GithubMetricsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GithubMetricsServiceApplication.class, args);
    }

}
