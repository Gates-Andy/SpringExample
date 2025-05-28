package com.andy.spring.ex.thymleaf;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymleaf")
public class ThymleafController {
	// 1
	@GetMapping("/ex01")
	public String ex01() {

		return "thymleaf/ex01";

	}

	// 2
	@GetMapping("/ex02")
	public String ex02(Model model) {
		//1
		List<String> fruitList = new ArrayList<>();

		fruitList.add("banana");
		fruitList.add("apple");
		fruitList.add("귤");

		model.addAttribute("fruitList", fruitList);

		//2 맵을 저장하는 List 생성
		List<Map<String, Object>> userList = new ArrayList<>();

		// 이름 나이 취미 "name"=신윤식, "age":30, "hobby":기타
		Map<String, Object> userMap = new HashMap<>(); // 이 코드는 새로운 Map 객체를 힙 메모리에 생성하고,그 객체의 주소(참조)를 userMap 변수에 저장합니다.

		userMap.put("name", "신윤식");
		userMap.put("age", "30");
		userMap.put("hobby", "기타");

		userList.add(userMap); // 이건 userMap이 가리키는 객체의 주소를 리스트에 저장하는 겁니다. 중요한 건 리스트는 객체 자체를 복사하지 않고 참조만 저장한다는
								// 점입니다.

		userMap = new HashMap<>(); // 같은 걸 왜 또만들 수 있는가에대한 개념 완벽이해

		userMap.put("name", "ANDY");
		userMap.put("age", "3");
		userMap.put("hobby", "피아노");

		userList.add(userMap);

		model.addAttribute("userList", userList); // "userList"라는 **이름(키)**은 템플릿에서 데이터를 어떻게 접근할지를 정하는 기준
		return "thymleaf/ex02";
	}
	
	@GetMapping("/ex03")
	
	public String ex03(Model model) {
		
		Date date = new Date();
		LocalDate localDate = LocalDate.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		
		model.addAttribute("date",date);
		model.addAttribute("localDate",localDate);
		model.addAttribute("localDateTime",localDateTime);
		
		return "thymleaf/ex03";
		
	}
	
}
