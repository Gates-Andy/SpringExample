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
		ResponseEntity<Person> entity //Spring에서 응답 전체를 직접 제어할 수 있게 해주는 클래스
		= new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
	
}
//📦 ResponseEntity란?
//ResponseEntity는 응답(Response) 전체를 조절할 수 있게 해주는 클래스입니다.
//
//보통 컨트롤러에서 리턴할 때는 데이터만 리턴하지만,
//
//ResponseEntity를 사용하면 아래 3가지를 함께 조절할 수 있어요:
//
//구성 요소	설명
//body (본문)	보내고 싶은 객체 (Person 등)
//status (상태코드)	200 OK, 404 Not Found, 500 Internal Server Error 등
//headers (헤더)	선택적으로 HTTP 헤더 추가 가능
//
//🧠 왜 이걸 써야 할까?
//보통은 Person만 리턴하면 응답 상태는 기본적으로 200 OK입니다.
//하지만 경우에 따라:
//
//오류가 났을 때 500 Internal Server Error
//
//데이터가 없을 때 404 Not Found
//
//클라이언트가 잘못 요청했을 때 400 Bad Request
//
//처럼 상태 코드를 명확히 지정하고 싶을 때, ResponseEntity를 사용합니다.