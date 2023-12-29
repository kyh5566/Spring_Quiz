package com.quiz.lesson06.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface BookMarkMapper {
	public void insertbook(String title, String url);
}
