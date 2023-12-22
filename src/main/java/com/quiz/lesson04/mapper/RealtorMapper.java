package com.quiz.lesson04.mapper;

import org.springframework.stereotype.Repository;

import com.quiz.lesson04.domain.Realtor;

@Repository
public interface RealtorMapper {
	
		public void insertRealtor();
		
		public Realtor selectRealtorById(int id);
}
