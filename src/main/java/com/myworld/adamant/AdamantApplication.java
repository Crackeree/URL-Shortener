package com.myworld.adamant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AdamantApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdamantApplication.class, args);
	}

}
