package com.andy.spring.ex.database.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.andy.spring.ex.database.domain.UsedGoods;

// 데이터 베이스 관련 처리 (query 수행)
// Mybatis Framework 설정 먼저

@Mapper // @Mapper로서 Repository에있는 메소드를 xml에서 구현하게 해준다.
public interface UsedGoodsRepository {

	// used_goods 모든행 조회
	public List<UsedGoods> selectUsedGoodsList();
}
