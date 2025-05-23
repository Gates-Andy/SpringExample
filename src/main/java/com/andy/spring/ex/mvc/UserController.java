package com.andy.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andy.spring.ex.mvc.domain.User;
import com.andy.spring.ex.mvc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 가장 최근 등록한 사용자 정보를 html로 response에 담는다.
	@RequestMapping("/mvc/user/info")
	public String userInfo(Model model) {
		User user = userService.getLastUser();
		
		model.addAttribute("title", "가장 최근 등록 사용자");
		model.addAttribute("result","user");
		
		// 이 메서드 안에서 필요한 데이터를 얻어와야함 (가장 최근 등록한 사용자 정보)
		return "mvc/userInfo"; // response body 없이 경로 만 사용하여
	}
}
