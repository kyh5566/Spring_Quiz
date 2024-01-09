package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.lesson07.entity.RecruitEntity;


public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{
	//2
	public List<RecruitEntity> findByCompanyId(int companyId);
	
	//3
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	
	//4
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	//5
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	
	//6
	public List<RecruitEntity> findByRegionAndSalaryBetWeen(String resion, int n1, int n2);
	
	//7 마감일이 2026-04-10 이후이고 연봉이 8100 이상인
	@Query(value = "select * from `recuritment` where `deadline`>:deadline "
			+ "and `salary`<:salary "
			+ "and type=:type "
			+ "Order by `salary` desc"
			, nativeQuery = true)
	public List<RecruitEntity> findDeadlineSalaryType(
			@Param("deadline")String deadline,
			@Param("salary")int salary,
			@Param("type")String type);
	
}
