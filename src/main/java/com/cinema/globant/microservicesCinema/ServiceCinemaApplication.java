package com.cinema.globant.microservicesCinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class ServiceCinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCinemaApplication.class, args);
	}

}
