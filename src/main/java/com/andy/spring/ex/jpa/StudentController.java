package com.andy.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.spring.ex.jpa.domain.Student;
import com.andy.spring.ex.jpa.service.StudentService;

@Controller
@RequestMapping("/jpa")
public class StudentController {
	@Autowired
	private StudentService studentService;

	// 1. 저장 기능
	@GetMapping("/student")
	public Student createStudent() {
		// 김인규, 010-1234-5678, abc@naver.com. 개발자
		Student student = studentService.addStudent("김인규", "010-1234-5678", "abc@naver.com", "개발자");
		return student;
	}
	
	// 2. 수정 시능

	@ResponseBody
	@GetMapping("/lombok")
	public Student lombokTest() {
		// 1. 고전방식
//		Student student = new Student(3, "andy", "010-1234-2345", "123@naver.com", "프로그래머", LocalDateTime.now(),LocalDateTime.now());
//		student.setDreamJob("강사");

		// 2. builder 패턴
		Student student = Student.builder().name("유재석").dreamJob("개그맨").phoneNumber("010-1111-2222").build();
//		{
//			  "id": 0,
//			  "name": "유재석",
//			  "phoneNumber": "010-1111-2222",
//			  "email": null,
//			  "dreamJob": "개그맨",
//			  "createdAt": null,
//			  "updatedAt": null
//		}

		return student;

	}

}
