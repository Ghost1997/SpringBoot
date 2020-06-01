package com.sujit.bfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class BfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BfoApplication.class, args);
	}

}
