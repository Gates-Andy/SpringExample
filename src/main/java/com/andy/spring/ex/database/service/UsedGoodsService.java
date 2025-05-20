package com.andy.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.spring.ex.database.domain.UsedGoods;
import com.andy.spring.ex.database.repository.UsedGoodsRepository;

@Service // 로직(busisness) 담당 (데이터 가공 햄버거 조립) 그 외 복잡한 기능 수행 코드가 제일 더러움
public class UsedGoodsService {
	
	// 의존성 주입 - DI 객체 생성을 Spring Framework 에서 직접 관리
	@Autowired
	private UsedGoodsRepository usedGoodsRepository;
	
	// 중고 게시글 정보 모두 얻어오는 메소드 리스트에서 얻어온 정보를 리턴해주면 될 뿐
	public List<UsedGoods> getUsedGoodsList(){
		
		// DB에 쿼리를 통하여 used_goods 테이블 모든 행 조회
		List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();
		
		return usedGoodsList;
		
	}
}
