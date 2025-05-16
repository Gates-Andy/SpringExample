package com.andy.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("/lifecycle/ex01")
public class Ex01RestController {
	// 직접 만든 클래스의 객체를 response에 담는 페이지
	@RequestMapping("/3")
	public Person personResponse() {
		Person me = new Person("신윤식", 32);

		return me;
	}

	// status code 수정
	@RequestMapping("/4")
	public ResponseEntity<Person> statuseResponse() {

		Person me = new Person("신윤식", 32);

		ResponseEntity<Person> entity = new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR);

		return entity;
	}
}
