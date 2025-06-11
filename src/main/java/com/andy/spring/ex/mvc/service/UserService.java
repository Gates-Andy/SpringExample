package com.andy.spring.ex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.spring.ex.mvc.domain.User;
import com.andy.spring.ex.mvc.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	// 1. 가장 최근에 등록한 사용자 정보 얻어오기 repository로 request
	public User getLastUser() {

		User user = userRepository.selectLastUser();

		return user;
	}

	// 2.
	public int addUser(User user) {

		int count = userRepository.insertUser(user);

		return count;

	}

	// AJAX 전달받은 email이 중복된 것인지 판별
	public boolean isDuplicateEmail(String email) {

		int count = userRepository.selectCountByEmail(email); // 리포지터리에서 그 이메일이 검색이되면 1이 뜰거고 0이면 없다는 뜻일것

		if (count == 0) { // 0이라는 count는 이메일이 사용가능하다는 뜻

			return false; // true가 중복 있다는 뜻이고, false가 중복 없다는 뜻

		} else {

			return true;

		}
// 이메일이 중복되었으면 true 반환, 중복 안되었으면 false 반환
//		public boolean isDuplicateEmail(String email) {
//		    int count = userRepository.selectCountByEmail(email);
//		    return count > 0;
//		}
	}

}
