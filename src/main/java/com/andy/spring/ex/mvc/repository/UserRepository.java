package com.andy.spring.ex.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.andy.spring.ex.mvc.domain.User;

@Mapper
public interface UserRepository {
	//1.
	public User selectLastUser();
	
	//2.
	public int insertUser(User user); 
}
