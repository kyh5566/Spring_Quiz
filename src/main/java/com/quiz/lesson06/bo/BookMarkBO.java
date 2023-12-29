package com.quiz.lesson06.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.mapper.BookMarkMapper;

@Service
public class BookMarkBO {
	@Autowired
	private BookMarkMapper bookmarkMapper;
	
	public void addBook(String title, String url) {
		bookmarkMapper.insertbook(title, url);
	}
}
