package com.andy.spring.ex.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andy.spring.ex.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
	// 모든행을 id 기반으로 내림차순 조회
	// order by `id` desc;
	public List<Student> findAllByOrderByIdDesc();
	
	// id 기반으로 내림차순 2개만 조회
	// ORDER BY `id` DESC LIMIT @
	public List<Student> findTop2ByOrderByIdDesc();

}
