package com.example.authsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "appAuditorAware")
public class AuthSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthSampleApplication.class, args);
    }

}
