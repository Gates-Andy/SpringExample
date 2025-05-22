package com.andy.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.spring.ex.mybatis.domain.Review;
import com.andy.spring.ex.mybatis.service.ReviewService;

@Controller
@RequestMapping("/mybatis/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	// id가 5인 리뷰 정보를 response에 json으로 담는다
	@ResponseBody
	@RequestMapping("/1")
	public Review review(@RequestParam("id")int id) {
		
		// 전달 받은 id와 일치하는 리뷰정보를 얻어오려면
		Review review = reviewService.getReview(id);
		
		return review;
		
	}
	
	// 리뷰를 저장하는 기능
	@ResponseBody
	@RequestMapping("/create")
	public String createReview() {
// 		4, 치즈피자, 김인규, 4.5, 치즈피자 존맛!
//		int count = reviewService.addReview(4, "치즈피자", "김인규", 4.5, "치즈피자 존맛!");
//		return "실행 결과 : 1" + count;
		
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김인규");
		review.setPoint(4.0);
		review.setReview("네");
		
		int count = reviewService.addReviewByObject(review);
		
		return "실행 결과 :" + count;
	}
	
	
}
