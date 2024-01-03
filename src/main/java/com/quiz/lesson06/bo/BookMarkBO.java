package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.BookMark;
import com.quiz.lesson06.mapper.BookMarkMapper;

@Service
public class BookMarkBO {
	@Autowired
	private BookMarkMapper bookmarkMapper;
	
	public void addBook(String title, String url) {
		bookmarkMapper.insertbook(title, url);
	}
	public List<BookMark> getBook() {
		return bookmarkMapper.selectBookMark();
	}
	
	//input: url      output: boolean
	public boolean isDuplicationUrl(String url) {
		// 중복없음 : [], 중복있음 : 리스트 내용물 채워짐
		List<BookMark> bookmarkList = bookmarkMapper.selectBookMarkList(url);
		return bookmarkList.isEmpty() ? false : true;
		//return !bookmarkList.isEmpty();
	}
	// input: id    output: int (rowCount)
	public int deleteBookMarkById(int id) {
		return bookmarkMapper.deleteBookMarkById(id);
	}
}
