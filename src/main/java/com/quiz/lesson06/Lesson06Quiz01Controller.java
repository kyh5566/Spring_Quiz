package com.quiz.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookMarkBO;
import com.quiz.lesson06.domain.BookMark;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {
	@Autowired
	private BookMarkBO bookmarkBO;
	//즐겨찾기 추가 화면
	// http://localhost/lesson06/quiz01/add-book-view
	@GetMapping("/add-book-view")
	public String addBookView() {
		return "lesson06/addBook";
	}
	
	// 즐겨찾기 insert ajax 응답값 들어오는곳
	@ResponseBody
	@PostMapping("/add-book")
	public String addBook(
			@RequestParam("title") String title,
			@RequestParam("url") String url) {
		
		//db insert
		bookmarkBO.addBook(title,url);
		
		return "성공"; // ajax에게 돌려줄 data param 의 값 "성공"
	}
	// insert 후 즐겨찾기 목록 화면
	@GetMapping("/lesson06/quiz01/after-add-book")
	public String afterAddBook(BookMark bookmark,Model model) {
		int id = bookmark.getId();
		model.addAttribute("bookmark", bookmark);
		return "lesson06/afterAddBook";
	}
	
}
