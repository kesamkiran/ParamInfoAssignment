package com.test.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.weather.models.WeatherDtls;
import com.test.weather.services.WeatherService;

@RestController
public class WeatherController {
	@Autowired
	private WeatherService weatherService;

	@GetMapping("/")
	public String home() {
		return "<h1>Welcome to Weather App!</h1>";
	}

	@GetMapping("/weather/{city}")
	public List<WeatherDtls> getWeather(@PathVariable String city) {
		return weatherService.getWeather(city);
	}

	@GetMapping("/weather/{lat}/{lon}")
	public List<WeatherDtls> getWeather(@PathVariable double lat, @PathVariable double lon) {
		return weatherService.getWeather(lat, lon);
	}
}
