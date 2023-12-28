package com.quiz.weather_history.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.weather_history.domain.WeatherHistory;

@Repository
public interface WeatherHistoryMapper {
	public List<WeatherHistory> selectweatherhistory();
	
	public void insertweatherhistory();
}
