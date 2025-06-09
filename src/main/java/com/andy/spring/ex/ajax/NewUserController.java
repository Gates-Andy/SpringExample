package com.andy.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.spring.ex.mvc.domain.User;
import com.andy.spring.ex.mvc.service.UserService;

@Controller
@RequestMapping("/ajax/user")
public class NewUserController {

	@Autowired // (mvc에서 이미 만들어놓음)
	private UserService userService;

	// 사용자 추가 API
	@PostMapping("/create")
	@ResponseBody
	public Map<String, String> createUser(@RequestParam("name") String name, @RequestParam("birthday") String birthday,
			@RequestParam("email") String email, @RequestParam("introduce") String introduce) {

		User user = new User();
		user.setName(name);
		user.setYyyymmdd(birthday);
		user.setEmail(email);
		user.setIntroduce(introduce);

		int count = userService.addUser(user);

		Map<String, String> resultMap = new HashMap<>();

		// key에다가 담아 value를 출력하는 Map<String, String>
		// 성공의 데이터 정보 : {"result":"success"} 실패의 데이터 정보 : {"result":"fail"}

		if (count == 1) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}

		return resultMap;

	}
	
	// 입력화면 view html form 태그쓰구
	@GetMapping("/input")
	public String inputUser() {
		
		return "/ajax/input";
		
	}
}
