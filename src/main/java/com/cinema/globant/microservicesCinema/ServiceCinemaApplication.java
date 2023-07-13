package com.cinema.globant.microservicesCinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
// especificar paquete base de lo que se inyecta como dependencia
@ComponentScan(basePackages = {"com.cinema.globant.microservicesCinema"})
// Especificar paquete base de repositorios
@EnableJpaRepositories(basePackages = {"com.cinema.globant.microservicesCinema"})
public class ServiceCinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCinemaApplication.class, args);
	}
}
