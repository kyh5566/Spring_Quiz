package com.quiz.lesson03.mappers;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {
	public RealEstate selectRealEstateById(int id);
	public List<RealEstate> selectRealEstateByrentPrice(Integer rentPrice);
	public List<RealEstate> selectRealEstateByareaPrice(int area, int price);
}
