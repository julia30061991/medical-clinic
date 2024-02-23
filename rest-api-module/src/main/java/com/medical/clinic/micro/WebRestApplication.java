package com.medical.clinic.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.medical.clinic.micro.service", "com.medical.clinic.micro.controller"})
@EnableJpaRepositories({"com.medical.clinic.micro.repository"})
@EntityScan({"com.medical.clinic.micro.model", "com.medical.clinic.micro.controller"})
public class WebRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebRestApplication.class, args);
    }
}