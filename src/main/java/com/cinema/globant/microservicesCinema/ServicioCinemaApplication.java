package com.cinema.globant.microservicesCinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class ServicioCinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioCinemaApplication.class, args);
	}

}
