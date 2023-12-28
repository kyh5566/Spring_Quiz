package com.quiz.weather_history;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherBO;
import com.quiz.weather_history.domain.WeatherHistory;
@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {
	@Autowired
	private WeatherBO weatherBO;
	
	// 1.
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		List<WeatherHistory> weatherList = weatherBO.getWeatherHistoryList();
		model.addAttribute("weatherList",weatherList);
		
		return "weather_history/WeatherListView";
	}
	
	// 2.
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeatherView";
	}
	
	@PostMapping("/add-weather")
	public String addWeather(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("weather") String weather,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed) {
			// HttpServletRequest request
		
			//db insert
			weatherBO.addWeatherHistory(date, weather, temperatures,precipitation,microDust,windSpeed);
			
			//결과화면 = 리다이렉트
			return "redirect:/weather-history/weather-list-view";
		
	}
	
	
}
