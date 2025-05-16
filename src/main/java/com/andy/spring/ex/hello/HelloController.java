package com.andy.spring.ex.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 요청응답을 불러주기 위한 클래스라는걸 알려줌

public class HelloController {
	@ResponseBody	//return 되는 값을 리스폰스한다
	@RequestMapping("/hello") // 하나의 클래스안에서도 특정메소드위에 매핑
	public String hello() {
		return "Hello World!";
	}
}
