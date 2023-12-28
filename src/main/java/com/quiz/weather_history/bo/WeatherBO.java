package com.quiz.weather_history.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherBO {
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	//input: X      output: List<WeatherHistory>
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistoryMapper.selectweatherhistory();
	}
	
	//input: 6개 파라미터    output: x
	
	public void addWeatherHistory(Date date,String weather,double temperatures, double precipitation,
			String microDust,double windSpeed) {
		weatherHistoryMapper.insertweatherhistory(date,weather,temperatures,precipitation,microDust,windSpeed);
	}
}
