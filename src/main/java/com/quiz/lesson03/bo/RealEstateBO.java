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
	
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	//"썅떼빌리버 오피스텔 814호",45, "월세", 100000, 120
	public int addRealEstateASField(int realtorId,String address, int area, 
			String type, int price, int rentPrice) {
		return realEstateMapper.insertRealEstateASField(realtorId, address, area, type, price, rentPrice);
	}
	
	public int updateRealEstateById(int id, String type, int price) {
		return realEstateMapper.updateRealEstateById(id, type, price);
	}
	
	public int deleteRealEstateById(int id) {
		return realEstateMapper.deleteRealEstateById(id);
	}
}
