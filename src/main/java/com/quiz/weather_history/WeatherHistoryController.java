package com.quiz.weather_history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather_history.bo.WeatherBO;
import com.quiz.weather_history.domain.WeatherHistory;
@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {
	@Autowired
	private WeatherBO weatherBO;
	
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		List<WeatherHistory> weather = new ArrayList<>();
		weather.add(weatherBO.getWeatherHistory());
		model.addAttribute(weather);
		return "weather_history/WeatherListView";
	}
	
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeatherView";
	}
	
}
