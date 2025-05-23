package com.andy.spring.ex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.spring.ex.mvc.domain.User;
import com.andy.spring.ex.mvc.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	// 가장 최근에 등록한 사용자 정보 얻어오기 repository로 request
	public User getLastUser(){
		
		User user = userRepository.selectLastUser();
		
		return user;
	}
}
