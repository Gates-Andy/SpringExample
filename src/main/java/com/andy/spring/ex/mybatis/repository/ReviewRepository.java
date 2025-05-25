package com.andy.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.andy.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {

	// new_review 테이블에서 id가 5인 행 조회 이제부터 전달받은 id와 일치하는 행으로 조회
	public Review selectReview(@Param("id") int id);
	
	//	비슷 한 어노테이션 사용 위치 & 역할
	//	@Param("id")		MyBatis Mapper 인터페이스	XML SQL 쿼리의 #{id}와 연결
	//	@RequestParam("id")	Spring Controller 메서드	URL 요청 파라미터 ?id=5 추출
	
	// sellerId, menu, userName, point, review 저장 기능
	public int insertReview(
    		@Param("storeId") int storeId
    		, @Param("menu") String menu
    		, @Param("userName") String userName
    		, @Param("point") double point
    		, @Param("review") String review);

	// Review 객체를 통해 한 행 저장하는 기능
	public int insertReviewByObject(Review review);
}
