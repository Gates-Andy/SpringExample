package com.andy.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {

	@RequestMapping("/lifecycle/ex02")
	public String thymleafResponse() {

		return "lifecycle/ex02"; 
		// html 파일 경로를 리턴 - 항상 통일된경로이기 때문에 src/main/resources/templates 그리고 .html는 생략되어있음
		
	}
	
}
