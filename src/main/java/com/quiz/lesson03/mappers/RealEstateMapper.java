package com.quiz.lesson03.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {
	public RealEstate selectRealEstateById(int id);
	
	public List<RealEstate> selectRealEstateByrentPrice(Integer rentPrice);
	
	public List<RealEstate> selectRealEstateByareaPrice(
			// myBatis 문법상 파라미터는 단 한개만 xml 파일로 보낼수있다.
			// 여러개일시엔 하나의 맵으로 묶어서 보낸다.
			// @Param
			@Param("area") int area,
			@Param("price") int price);
	
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateASField(
			@Param("realtorId") int realtorId,
			@Param("address") String address, 
			@Param("area") int area, 
			@Param("type") String type,
			@Param("price") int price, 
			@Param("rentPrice") int rentPrice);
	
	public int updateRealEstateById(
			@Param("id") int id,
			@Param("type") String type,
			@Param("price") int price); 
	
	public int deleteRealEstateById(int id);
}
