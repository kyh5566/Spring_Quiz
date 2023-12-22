package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Realtor;
import com.quiz.lesson04.mapper.RealtorMapper;

@Service
public class RealtorBO {
		@Autowired
		private RealtorMapper realtorMapper;
	
		// input: x    output: realtor
		public void addRealtor() {
			realtorMapper.insertRealtor();
		}
		
		// input : id     output: realtor
		public Realtor getRealtorById(int id) {
			return realtorMapper.selectRealtorById(id);
		}
}
