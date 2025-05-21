package com.andy.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.spring.ex.mybatis.domain.Review;
import com.andy.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;

	// id가 5인 리뷰정보 얻어오기를 없애(1단계)! 지워 잊어 매번 파라미터 id로 리뷰를 얻어와야함 이제부터
	public Review getReview(int id) { // 아래에 id랑 비교를 잘해야함

		// DB의 new_review 테이블에서 id가 5인 행 조회 매번 파라미터 이제부터 id로 리뷰를 얻어와야함
		Review review = reviewRepository.selectReview(id);

		return review;
	}
}
