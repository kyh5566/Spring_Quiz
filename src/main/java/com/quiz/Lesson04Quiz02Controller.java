package com.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@Controller
@RequestMapping("lesson04/quiz02")
public class Lesson04Quiz02Controller {
		@Autowired
		private RealtorBO realtorBO;
	
		// 추가 화면
		//http://localhost/lesson04/quiz02/add-realtor-view
		@GetMapping("/add-realtor-view")
		public String addRealtorView() {
			return "lesson04/addRealtor";
		}
	
		@PostMapping("/add-realtor")
		public String addRealtor(
				@ModelAttribute Realtor realtor
				,Model model) {
			
			// insert + pk값 받아오기
			realtorBO.addRealtor();
			
			int id = realtor.getId();
			
			// pk값을 이용하여 select
			Realtor latestRealtor = realtorBO.getRealtorById(id);
			
			// select 된 realtor 를 model 에 담는다
			model.addAttribute("realtor", latestRealtor);
			
			//view , table 형식
			return "lesson04/afterAddRealtor";
		}
}
