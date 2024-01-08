package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.CompanyEntity;
//@Transactional
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{
//	@PersistenceContext
//	private EntityManager em;
//	
//	public CompanyEntity save(CompanyEntity companyEntity) {
//		 Optional<엔티티> findById().orElse();
//	}
}
