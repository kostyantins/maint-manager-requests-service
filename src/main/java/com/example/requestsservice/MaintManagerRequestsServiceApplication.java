package com.example.requestsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MaintManagerRequestsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaintManagerRequestsServiceApplication.class, args);
    }

}
