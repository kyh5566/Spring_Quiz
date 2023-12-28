package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Review;
import com.quiz.lesson02.domain.Store;


@Controller
public class StoreController {
	
	@Autowired
	private StoreBO storeBO;
	
	@GetMapping("/store/store-list")
	public String StoreList(Model model) {
		List<Store> store = storeBO.getStoreList();
		List<Review> review = storeBO.getStoreReview();
		model.addAttribute("store",store);
		model.addAttribute("review", review);
		return "store/StoreListView";
	}
}
