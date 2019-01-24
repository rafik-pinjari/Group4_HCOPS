package com.capco.HROPS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CapcoHropsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapcoHropsApplication.class, args);
	}
}
