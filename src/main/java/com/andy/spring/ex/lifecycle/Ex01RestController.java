package com.andy.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("/lifecycle/ex01") //클래스 레벨
public class Ex01RestController {
	
	//1. 직접 만든 클래스의 객체를 response에 담는 페이지
	
	@RequestMapping("/3") // 메서드 레벨
	public Person personResponse() {
		
		Person me = new Person("신윤식", 32);
		
		return me;
		
		//	me는 아래 코드에서 생성된 Person 타입의 객체예요:
		
	}

	//2. status code 수정
	
	@RequestMapping("/4")
	public ResponseEntity<Person> statuseResponse() {
		
		Person me = new Person("신윤식", 32);
		
		//Spring에서 응답 전체를 직접 제어할 수 있게 해주는 ResponseEntity 클래스 객체 me 와 상태코드를 지정
		ResponseEntity<Person> entity = new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
		
	}
	
}
