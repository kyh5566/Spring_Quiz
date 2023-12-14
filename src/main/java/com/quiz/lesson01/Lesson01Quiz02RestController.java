package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Lesson01Quiz02RestController {
	@RequestMapping("/1")
	public List<Map<String,Object>> quiz02_1() {
		Map<String,Object> movie = new HashMap<>();
		Map<String,Object> movie2 = new HashMap<>();
		Map<String,Object> movie3 = new HashMap<>();
		Map<String,Object> movie4 = new HashMap<>();
		Map<String,Object> movie5 = new HashMap<>();
		List<Map<String,Object>> list = new ArrayList<>();
		
		movie.put("rate",15 );
		movie.put("director", "봉준호");
		movie.put("time", 131);
		movie.put("title", "기생충");
		list.add(movie);
		
		movie2.put("rate",0 );
		movie2.put("director", "로베르토 베니니");
		movie2.put("time", 116);
		movie2.put("title", "인생은 아름다워");
		list.add(movie2);
		
		movie3.put("rate",12 );
		movie3.put("director", "크리스토퍼 놀란");
		movie3.put("time", 147);
		movie3.put("title", "인셉션");
		list.add(movie3);
		
		movie4.put("rate",19 );
		movie4.put("director", "윤종빈");
		movie4.put("time", 133);
		movie4.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		list.add(movie4);
		
		movie5.put("rate", 15);
		movie5.put("director", "프란시스 로렌스");
		movie5.put("time", 137);
		movie5.put("title", "헝거게임");
		list.add(movie5);
		
		return list;
	}
	
	@RequestMapping("/2")
	public List<Board> quiz02_2() {
		// @ResponseBody + return String => HttpMessageConverter => String => html로 변환
		// @ResponseBody + return 객체(map,list,class) 등.. => HttpMessageconverter    jackson 라이브러리 => json
		List<Board> list2 = new ArrayList<>();
		Board board = new Board();	
		
		board.setTitle("안녕하세요 가입인사 드립니다.");
		board.setUser("marobiana");
		board.setContent("안녕하세요. 가입했어요.");
		list2.add(board);
		
		board = new Board();
		board.setTitle("헐 대박");
		board.setUser("bada");
		board.setContent("오늘 목요일...");
		list2.add(board);
		
		board = new Board();
		board.setTitle("오늘 데이트 한 이야기..");
		board.setUser("dulumary");
		board.setContent("...");
		list2.add(board);
		
		return list2;
	}
	
		@RequestMapping("/3")
		public ResponseEntity<Board> quiz02_3() {
			Board board = new Board();			
			board.setTitle("안녕하세요 가입인사 드립니다.");
			board.setUser("marobiana");
			board.setContent("안녕하세요. 가입했어요.");
			
			return new ResponseEntity(board, HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
