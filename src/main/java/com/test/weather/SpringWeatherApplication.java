package com.test.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWeatherApplication.class, args);
	}
}
