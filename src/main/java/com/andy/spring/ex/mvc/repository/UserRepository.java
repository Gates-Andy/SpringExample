package com.andy.spring.ex.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.andy.spring.ex.mvc.domain.User;

@Mapper
public interface UserRepository {
	// 1.
	public User selectLastUser();

	// 2.
	public int insertUser(User user);

	// 3. Ajax 전달 받은 email이 포함된 행의 개수 조회
	public int selectCountByEmail(@Param("email") String email);
}
