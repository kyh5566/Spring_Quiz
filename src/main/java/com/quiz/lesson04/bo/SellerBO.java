package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	@Autowired
	private SellerMapper sellerMapper;
	
	//input : 3개의 파라미터(nickname, url , 온도)   output: X
	public void addSeller(String nickname, String profilImageUrl, double temperature) {
		sellerMapper.insertSeller(nickname, profilImageUrl, temperature);
	}
	
	//input : X      output : Seller(or null)
	public Seller getLatestSeller() {
		return sellerMapper.selectLatestSeller();
	}
	
	//input : id     output : Seller 
	public Seller getSellerById(int id) {
		return sellerMapper.selectSellerById(id);
	}
}
