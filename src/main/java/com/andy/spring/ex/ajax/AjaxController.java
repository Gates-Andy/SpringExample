package com.andy.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

	@GetMapping("/ex01")
	public String ex01() {

		return "ajax/ex01"; //**뷰 리졸버(ViewResolver)**가 이를 해석해서 템플릿 파일 경로를 찾습니다.

	}

	// response에 데이터가 담기는 페이지
	// API <-> View (html)
	// 이름과 생년월일을 전달 받고 이름과 나이를 응답으로 전달한다.

	@ResponseBody
	@GetMapping("/person")
	public Map<String, Object> personInfo(@RequestParam("name") String name,
			@RequestParam("birthday") String birthday) {

		int year = Integer.parseInt(birthday.substring(0, 4));

		int age = 2025 - year + 1;

		// {"name":"김인규", "age":32} json 

		Map<String, Object> personMap = new HashMap<>(); //이 Map은 @ResponseBody에 의해 JSON으로 자동 변환됩니다.
		personMap.put("name", name);
		personMap.put("age", age);

		return personMap;

	}

}
