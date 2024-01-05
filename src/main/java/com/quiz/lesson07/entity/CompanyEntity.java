package com.quiz.lesson07.entity;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "company")
@Entity
public class CompanyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String business;
	private String scale;
	private String headcount;
	
	@UpdateTimestamp
	@Column(name = "createdAt")
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
}
