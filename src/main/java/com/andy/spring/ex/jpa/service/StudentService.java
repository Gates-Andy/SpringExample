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

	// 1. create 에서 사용할
	public Student addStudent(String name, String phoneNumber, String email, String dreamJob) {

		Student student = Student.builder().name(name).phoneNumber(phoneNumber).email(email).dreamJob(dreamJob).build();

		Student result = studentRepository.save(student);

		return result;

	}

	// 2.
	public Student updateStudent(int id, String dreamJob) {
		// 수정대상 행 조회
		// 조회 결과 객체 얻어 오기
		// 객체에 수정사항 적용
		// 수정된 객체를 저장

		// 자바 기능 Optional null일 수도 있는 객체를 감싸 놓은 래퍼 클레스 null처리에 필요한 기능을 포함
		// NullPointerException 위험을 줄이기 null일 수도 있는 객체를 return 하는 메소드에서 return type 으로 활용

		Optional<Student> optionalStudent = studentRepository.findById(id); // null을 가끔 리턴하는데 메서드 만드는쪽에서 처리과정을 감싼다
		// Optional<Student>는 "Student일 수도 있고 아닐 수도 있는" 값을 감싸는 객체입니다.
		if (optionalStudent.isPresent()) { // 그래서 보통 .get()을 쓰기 전에 반드시 isPresent()로 확인합니다.

			// null 이 아니다 

			Student student = optionalStudent.get(); //Optional의 메서드 안에 들어 있는 실제 값을 꺼냅니다.

			student = student.toBuilder()
					.dreamJob(dreamJob)
					.build();

			Student result = studentRepository.save(student); // JPA CrudRepository 메서드
			//	studentRepository는 JpaRepository<Student, Integer> 또는 CrudRepository<Student, Integer>를 상속받는 인터페이스입니다.
			return result;

		} else {
			return null; // 또는 throw new 예외
			// null 이다

		}

	}

	// 3.
	public void deleteStudent(int id) {
	    Optional<Student> optionalStudent = studentRepository.findById(id);

	    if (optionalStudent.isPresent()) {
	    	
	        Student student = optionalStudent.get();
	        
	        studentRepository.delete(student);
	        
	    } else {
	    	
	        System.out.println("삭제할 학생이 존재하지 않습니다. id=" + id);
	        
	    }
	    
	}
	
}
