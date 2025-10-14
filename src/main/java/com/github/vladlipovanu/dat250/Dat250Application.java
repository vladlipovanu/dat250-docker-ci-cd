package com.github.vladlipovanu.dat250;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Dat250Application {
	public static void main(String[] args) {
		SpringApplication.run(Dat250Application.class, args);

	}
}