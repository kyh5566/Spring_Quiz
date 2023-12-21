package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	@Autowired
	private SellerBO sellerBO;
	
	// 판매자 추가 화면
	//http://localhost/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// 추가 버튼 눌렀을때 insert 후 입력성공! 화면
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profilImageUrl", required = false) String profilImageUrl,
			@RequestParam("temperature") double temperature) {
		
		// DB insert (SellerBO)
		sellerBO.addSeller(nickname, profilImageUrl, temperature);
		
		return "lesson04/afterAddSeller2";
	}
	
	// 최근 가입자 화면
	// http://localhost/lesson04/quiz01/seller-info-view
	@GetMapping("/seller-info-view")
	public String sellerInfoView(Model model, 
			@RequestParam(value = "id", required = false) Integer id) {
		// db select
		Seller seller = null;
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
		seller = sellerBO.getSellerById(id);
		}
		// model 에 담는다.
		model.addAttribute("seller",seller);
		model.addAttribute("title", "판매자 정보");
		// return
		return "lesson04/sellerInfo";
	}
}
