package com.andy.spring.ex.mvc;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.andy.spring.ex.mvc.domain.User;
import com.andy.spring.ex.mvc.service.UserService;

@Controller
@RequestMapping("/mvc/user")
public class UserController {

	@Autowired
	private UserService userService;

	//1. 가장 최근 등록한 사용자 정보를 Html로 response에 담는다.
	@RequestMapping("/info")
	public String userInfo(Model model) {
		User user = userService.getLastUser();
		
		model.addAttribute("title", "가장 최근 등록 사용자");
		model.addAttribute("result",user);
		
		// 이 메서드 안에서 필요한 데이터를 얻어와야함 (가장 최근 등록한 사용자 정보)
		return "mvc/info"; // response body 없이 경로 만 사용하여
		
	}
	//2.
	@PostMapping("/create")
	public String createUser(
	        @RequestParam("name") String name,
	        @RequestParam("birthday") String birthday,
	        @RequestParam("email") String email,
	        @RequestParam(value="introduce", required=false) String introduce,
	        Model model) {
		
		User user = new User(); //받은 값들로 User 객체를 만들어 필드 세팅.
		user.setName(name);
		user.setYyyymmdd(birthday);
		user.setEmail(email);
		user.setIntroduce(introduce);
		
	    LocalDateTime now = LocalDateTime.now();
	    user.setCreatedAt(now);
	    user.setUpdatedAt(now);
	    
	    int count = userService.addUser(user);
	    
		model.addAttribute("title","가장 최근 등록 사용자");
		model.addAttribute("result",user);
		
		return "redirect:/mvc/user/info";
		// 결과로 등록된 사용자 정보를 모델에 담으려 했지만, redirect: 로 다시 다른 URL로 리다이렉트 
		// 하기 때문에 모델 속성은 실제로 넘어가지 않습니다 (리다이렉트 시 모델은 전달 안됨).
		//→ 사용자 등록 후 /mvc/user/userinfo 페이지로 리다이렉트 시킵니다.
	}
	
	//3.
	@GetMapping("/input")
	
	public String userInput(){
		
		return "mvc/userInput";
		
	}

}
