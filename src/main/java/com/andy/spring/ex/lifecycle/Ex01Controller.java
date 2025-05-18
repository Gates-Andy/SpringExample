package com.andy.spring.ex.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex01Controller {

		// 간단한 html을 response 담는  페이지
	@ResponseBody
	@RequestMapping("/lifecycle/ex01/1")
	public String htmlResponse() {
		return ""
				+ "<html>"
				+ "		<head><title>Sprint</title></head>\n"
				+ "		<body>"
				+ "			<h2>Spring html response</h2>\n" 
				+ "		</body>\n"
				+ "</html>";
	}
	
	// 맵을 response에 담는 페이지
	@ResponseBody
	@RequestMapping("/lifecycle/ex01/2")
	public Map<String,Integer> mapResponse() {
		//과일이름 : 가격
		Map<String,Integer> fruitMap = new HashMap<>();
		
		fruitMap.put("apple",1500);
		fruitMap.put("banana",56);
		fruitMap.put("peach",3250);
		
		return fruitMap;
	}
	
}
//Spring은 **HttpMessageConverter**라는 내부 기능을 통해,
//String → text/html 또는 text/plain
//Map, Object → JSON (Jackson 이용)로 자동 변환해줍니다.
