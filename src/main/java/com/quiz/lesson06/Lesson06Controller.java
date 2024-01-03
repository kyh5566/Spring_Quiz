package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookMarkBO;
import com.quiz.lesson06.domain.BookMark;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
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
	public Map<String, String> addBook(
			@RequestParam("title") String title,
			@RequestParam("url") String url) {
		
		//db insert
		bookmarkBO.addBook(title,url);
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		
		return result;
	}
	// insert 후 즐겨찾기 목록 화면
	@GetMapping("/after-add-book")
	public String afterAddBook(Model model) {
		List<BookMark> BookmarkList = bookmarkBO.getBook();
		model.addAttribute("BookmarkList", BookmarkList);
		return "lesson06/afterAddBook";
	}
	//ajax 요청 - url 중복확인
	@ResponseBody
	@PostMapping("/is-duplication-url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url") String url) {
		
		//db select
		boolean isDuplication = bookmarkBO.isDuplicationUrl(url);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code",200);
		result.put("is_duplication",isDuplication); // true중복 or false중복아님
		return result;  // map 을 return => json
	}
	
	//즐겨찾기 삭제 - ajax 요청
	@ResponseBody
	@DeleteMapping("/delete-bookmark")
	public Map<String, Object> delectBookmark(
			@RequestParam("id") int id) {
		
		//db delete
		int rowCount = bookmarkBO.deleteBookMarkById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error-message", "삭제 실패");	
		}
		return result;
	}
		
}
