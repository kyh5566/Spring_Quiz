package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.BookMark;

@Mapper
public interface BookMarkMapper {
	public void insertbook(
			@Param("title")String title, 
			@Param("url") String url);
	
	public List<BookMark> selectBookMark();
	
	//input: url    output: List<BookMark>
	public List<BookMark> selectBookMarkList(String url);
	
	public int deleteBookMarkById(int id);
}
