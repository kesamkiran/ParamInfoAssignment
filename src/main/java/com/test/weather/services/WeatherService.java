package com.test.weather.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.weather.models.Today;
import com.test.weather.models.TodaysWeather;
import com.test.weather.models.WeatherDtls;

@Service
@CacheConfig(cacheNames = "weatherForecast")
public class WeatherService {

	private static WeatherService ourInstance = new WeatherService();

	public static WeatherService getInstance() {
		return ourInstance;
	}

	public List<WeatherDtls> getWeather(String city) {
		List<WeatherDtls> weatherList = new ArrayList<>();

		String websiteResponse = "http://api.openweathermap.org/data/2.5/weather?q=" + city
				+ "&mode=json&appid=ffa6f13ea40a22452bba3be726315d3f&units=metric";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(websiteResponse, String.class);

		String description = null;
		String WeatherCondition = null;
		double temp;
		double temp_min;
		double temp_max;
		double pressure;
		int humidity;

		JSONObject root = new JSONObject(result);

		JSONArray weatherObject = root.getJSONArray("weather");

		for (int i = 0; i < weatherObject.length(); i++) {
			JSONObject elementInArray = weatherObject.getJSONObject(i);
			description = elementInArray.getString("description");
			WeatherCondition = elementInArray.getString("main");
		}

		JSONObject main = root.getJSONObject("main");

		temp = (int) main.getFloat("temp");
		pressure = main.getInt("pressure");
		humidity = main.getInt("humidity");
		temp_min = (int) main.getFloat("temp_min");
		temp_max = (int) main.getFloat("temp_max");

		TodaysWeather tw = new TodaysWeather();
		WeatherDtls e = new WeatherDtls();
		Today t = new Today();

		t.setDescription(description);

		t.setHumidity(humidity);
		t.setMain(WeatherCondition);
		t.setPressure(pressure);

		t.setTemp(temp);
		t.setTempMax(temp_max);
		t.setTempMin(temp_min);

		tw.setToday(t);
		e.setTodaysWeather(tw);

		weatherList.add(e);

		return weatherList;
	}

	public List<WeatherDtls> getWeather(double lat, double lon) {
		List<WeatherDtls> weatherList = new ArrayList<>();

		String websiteResponse = "http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon
				+ "&mode=json&appid=ffa6f13ea40a22452bba3be726315d3f&units=metric";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(websiteResponse, String.class);

		String description = null;
		String WeatherCondition = null;
		double temp;
		double temp_min;
		double temp_max;
		double pressure;
		int humidity;

		JSONObject root = new JSONObject(result);

		JSONArray weatherObject = root.getJSONArray("weather");

		for (int i = 0; i < weatherObject.length(); i++) {
			JSONObject elementInArray = weatherObject.getJSONObject(i);
			description = elementInArray.getString("description");
			WeatherCondition = elementInArray.getString("main");
		}

		JSONObject main = root.getJSONObject("main");

		temp = (int) main.getFloat("temp");
		pressure = main.getInt("pressure");
		humidity = main.getInt("humidity");
		temp_min = (int) main.getFloat("temp_min");
		temp_max = (int) main.getFloat("temp_max");

		TodaysWeather tw = new TodaysWeather();
		WeatherDtls e = new WeatherDtls();
		Today t = new Today();

		t.setDescription(description);

		t.setHumidity(humidity);
		t.setMain(WeatherCondition);
		t.setPressure(pressure);

		t.setTemp(temp);
		t.setTempMax(temp_max);
		t.setTempMin(temp_min);

		tw.setToday(t);
		e.setTodaysWeather(tw);

		weatherList.add(e);

		return weatherList;
	}
}
