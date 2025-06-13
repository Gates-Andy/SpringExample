package com.andy.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.spring.ex.jpa.domain.Student;
import com.andy.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(String name,String phoneNumber,String email,String dreamJob) {
		
		Student student = Student.builder()
		.name(name)
		.phoneNumber(phoneNumber)
		.email(email)
		.dreamJob(dreamJob)
		.build();
		
		Student result = studentRepository.save(student);
		
		return result;
		
	}
	
	public <Student> updateStudent(int id, String dreamJob) {
		// 수정대상 행 조회
		// 조회 결과 객체 얻어 오기
		// 객체에 수정사항 적용
		// 수정된 객체를 저장
		
		// 자바 기능 optional null일 수도 있는 객체를 감싸 놓은 클레스 null처리에 필요한 기능을 포함
		// NullPointerException 위험을 줄이기 null일 수도 있는 객체를 return 하는 메소드에서 return type 으로 활용
		// 
		
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		
		if(optionalStudent.isPresent()) {
			// null 이 아니다
			Student student = optionalStudent.get();
			
		} else {
			// null 이다
		}
		
		return optionalStudent;
	}
	
}
