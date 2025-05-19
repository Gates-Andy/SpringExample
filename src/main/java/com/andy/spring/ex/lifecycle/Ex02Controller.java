package com.andy.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {

	@RequestMapping("/lifecycle/ex02")
	public String thymleafResponse() {
		// html 파일 경로를 리턴
		// 항상 통일된경로이기 때문에 src/main/resources/templates 는 생략되어있음
		// .html 도 생략되어 있음
		return "lifecycle/ex02";
	}
}
