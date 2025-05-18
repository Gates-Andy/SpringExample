package com.andy.spring.ex.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 요청응답을 불러주기 위한 클래스라는걸 알려줌(이 클래스가 Spring MVC 컨트롤러임을 나타냅니다.)
public class HelloController {
	// 하나의 클래스안에서도 특정메소드위에 매핑
	@ResponseBody // **@ResponseBody는 "반환된 데이터를 HTTP 응답 본문(body)에 직접 넣는다"**는 의미 (return 되는 값을 리스폰스 한다)
	@RequestMapping("/hello") // 이 메서드는 /lifecycle/ex01/1 경로로 요청이 들어오면 실행됩니다.
	public String hello() {
		return "Hello World!";
	}
}
