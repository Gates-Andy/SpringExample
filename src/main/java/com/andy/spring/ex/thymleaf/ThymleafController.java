package com.andy.spring.ex.thymleaf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymleaf")
public class ThymleafController {

	@GetMapping("/ex01")
	public String ex01() {
		return "thymleaf/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		List<String> fruitList = new ArrayList<>();
		
		fruitList.add("banana");
		fruitList.add("apple");
		fruitList.add("귤");
		
		model.addAttribute("fruitList", fruitList);
		
		return "thymleaf/ex02";
	}
	
}
