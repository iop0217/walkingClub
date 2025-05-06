package com.example.walkingclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WalkingClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalkingClubApplication.class, args);
	}

}
