package com.andy.spring.ex.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.andy.spring.ex.database.domain.UsedGoods;


@Mapper // 데이터 베이스(query 수행) 관련 처리 @Mapper는 인터페이스에 붙인다. 
		// @Mapper로서 Repository에 있는 메소드를 xml에서 구현하게 해준다.
public interface UsedGoodsRepository {

	// #3 used_goods 모든행 조회
	public List<UsedGoods> selectUsedGoodsList();
	
}
//Mybatis Framework 설정 먼저 해야한다.MyBatis는 SQL 기반 ORM Object Relational Mapping프레임워크로,
//자바 같은 객체 지향 프로그래밍 언어와 관계형 데이터베이스(RDB: MySQL, Oracle 등)를 자동으로 연결해주는 기술

// Java 객체와 SQL 데이터베이스의 결과를 자동으로 매핑해주는 도구입니다.
// ORM은 자바의 클래스와 DB의 테이블을 자동으로 연결해줍니다!

//🧑 자바: 클래스, 객체

//public class User {
//    private String name;
//    private int age;
//}

//🏦 데이터베이스: 테이블, 컬럼

//CREATE TABLE user (
//    name VARCHAR(50),
//    age INT
//);

// 그렇다면 MyBatis를 왜 쓰나?
// SQL을 직접 제어하고 싶은 경우
// JPA보다 자유롭게 쿼리 작성하고 싶은 경우
// 기존 프로젝트에서 SQL 쿼리가 많을 때

//이렇게 interface만 정의하면, MyBatis는 자동으로 이 인터페이스에 대한 **구현 객체(클래스)**를 만들어서 Spring에 Bean으로 등록해줘요.
//즉, 여러분은 직접 implements 하는 클래스를 안 만들어도 됩니다!
//대신 UsedGoodsRepository.xml 같은 SQL 매핑 XML 파일을 통해 해당 메서드에 SQL을 연결하면 됩니다.
