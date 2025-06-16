package com.andy.spring.ex.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.spring.ex.jpa.domain.Student;
import com.andy.spring.ex.jpa.repository.StudentRepository;
import com.andy.spring.ex.jpa.service.StudentService;

@Controller
@RequestMapping("/jpa")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@ResponseBody
	@GetMapping("/lombok")
	public Student lombokTest() {
		// 1. 고전방식 객체 생성
//		Student student = new Student(3, "andy", "010-1234-2345", "123@naver.com", "프로그래머", LocalDateTime.now(),LocalDateTime.now());
//		student.setDreamJob("강사");

		// 2. builder 패턴 엔티티클래스에 @Build 어노테이션 순서도 상관없고 요즘 방식
		Student student = Student.builder()
				.name("유재석")
				.dreamJob("개그맨")
				.phoneNumber("010-1111-2222")
				.build();
//		{
//			  "id": 0,
//			  "name": "유재석",
//			  "phoneNumber": "010-1111-2222",
//			  "email": null,
//			  "dreamJob": "개그맨",
//			  "createdAt": null,
//			  "updatedAt": null
//		}

		return student; // responsebody ipa

	}

	// 1. 저장 기능
	@ResponseBody
	@GetMapping("/create")
	public Student createStudent() {

		// 김인규, 010-1234-5678, abc@naver.com. 개발자. service 의 add build 객체 생성 방식에 파라미터만 넣어

		Student student = studentService.addStudent("김인규", "010-1234-5678", "abc@naver.com", "개발자");

		return student;

	}

	// 2. 수정 기능
	@ResponseBody
	@GetMapping("/update")
	public Student updateStudent() {
		
		// id 가 3 인 학생 장래희망을 강사로 변경
		
		Student student = studentService.updateStudent(3, "강사");

		return student;
	}

	// 3. 삭제 기능
	@ResponseBody
	@GetMapping("/delete")
	public String deleteStudent() {
		
		studentService.deleteStudent(3);
		
		return "삭제 성공";
		
	}
	
	// 4. 조회기능 **원래는 컨트롤러에서 레파지토리 객체 사용 불가 !!!!!!!!!!! 예제 진행 편의를 위해서 추가하는 것
	@ResponseBody
	@GetMapping("/find")
	public List<Student> findStudent() {
		List<Student> studentList = null;
		
//		studentList = studentRepository.findAll();
//		studentList = studentRepository.findAllByOrderByIdDesc();
//		studentList = studentRepository.findTop2ByOrderByIdDesc();
		
		return studentList;
	}

}
