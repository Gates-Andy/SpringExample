package com.andy.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.andy.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {

    // new_review 테이블에서 id가 5인 행 조회 이제부터 전달받은 id와 일치하는 행으로 조회
    public Review selectReview(@Param("id") int id);
}
