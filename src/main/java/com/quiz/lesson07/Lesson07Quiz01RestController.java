package com.quiz.lesson07;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson07")
@RestController
public class Lesson07Quiz01RestController {

	@GetMapping("/quiz01/1")
	public CompanyEntity create() {
		String name = "넥손";
		String business = "컨텐츠 게임";
		String scale = "대기업";
		String headcount = "3585명";
	}
}
