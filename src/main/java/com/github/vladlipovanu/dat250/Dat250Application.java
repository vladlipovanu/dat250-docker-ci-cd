package com.github.vladlipovanu.dat250;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import redis.clients.jedis.UnifiedJedis;

import java.util.Map;
import java.util.Set;

@SpringBootApplication
@EnableScheduling
public class Dat250Application {
	public static void main(String[] args) {
		SpringApplication.run(Dat250Application.class, args);

	}
	@GetMapping("/")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}