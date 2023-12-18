package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mappers.RealEstateMapper;

@Service
public class RealEstateBO {
	@Autowired
	private RealEstateMapper realEstateMapper;
	
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	public List<RealEstate> getRealEstateByrentPrice(Integer rentPrice) {
		return realEstateMapper.selectRealEstateByrentPrice(rentPrice);
	}
	public List<RealEstate> getRealEstateByareaPrice(int area, int price) {
		return realEstateMapper.selectRealEstateByareaPrice(area, price);
	}
}
