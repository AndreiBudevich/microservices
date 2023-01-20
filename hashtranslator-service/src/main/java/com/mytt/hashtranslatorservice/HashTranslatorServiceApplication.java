package com.mytt.hashtranslatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableWebSecurity
public class HashTranslatorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HashTranslatorServiceApplication.class, args);
    }
}