package com.example.subwayschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SubwayScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubwayScheduleApplication.class, args);
    }

}
