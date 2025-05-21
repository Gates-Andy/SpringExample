package com.andy.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.spring.ex.mybatis.domain.Review;
import com.andy.spring.ex.mybatis.service.ReviewService;

@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	// id가 5인 리뷰 정보를 response에 json으로 담는다
	@ResponseBody
	@RequestMapping("/mybatis/review")
	public Review review(@RequestParam("id")int id) {
		
		// 전달 받은 id와 일치하는 리뷰정보를 얻어오려면
		Review review = reviewService.getReview(id);
		return review;
	}
}
