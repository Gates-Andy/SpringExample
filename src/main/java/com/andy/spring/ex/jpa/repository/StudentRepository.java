package com.andy.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andy.spring.ex.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
