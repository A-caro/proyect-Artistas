package com.dark.canciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CancionesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CancionesApplication.class, args);
    }

}
