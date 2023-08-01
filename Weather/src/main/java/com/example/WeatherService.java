package com.example;

import org.springframework.stereotype.Service;

import lombok.Value;

@Service
public class WeatherService {
	@Value("${weather.api.key}")
    private String apiKey;
   

	public WeatherData getWeatherData(String location) {
		// TODO Auto-generated method stub
		String apiUrl = "https://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + location;
		RestTemplate restTemplate = new RestTemplate();
		WeatherData weatherData = restTemplate.getForObject(apiUrl, WeatherData.class);
		return weatherData;
	}

}
