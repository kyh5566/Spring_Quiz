package com.quiz.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.domain.Store;

@Repository
public interface StoreMapper {
	// DB 에서 어떤 데이터들을 가져올지 정하는
	// .xml 파일에서 쿼리문 작성
	public List<Store> selectStoreList();
}
