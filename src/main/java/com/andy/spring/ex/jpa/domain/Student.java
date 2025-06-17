package com.andy.spring.ex.jpa.domain;

import java.time.LocalDateTime; 

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// JPA / Hibernate 관련 어노테이션 Lombok 관련 어노테이션
@Builder(toBuilder=true) // Builder 패턴을 사용할 수 있게 합니다. toBuilder=true를 설정하면 기존 객체에서 새로운 객체를 수정한 버전으로 복사할 수 있습니다.실체객체를 수정하는게 아니라 새롭게 만들어 리턴 
@NoArgsConstructor // 기본 생성자 (매개변수 없는 생성자)를 자동 생성합니다.
@AllArgsConstructor // 모든 필드를 매개변수로 받는 전체 생성자를 자동 생성합니다.
@Setter // 모든 필드에 대해 Getter/Setter 메서드를 자동 생성합니다.
@Getter
@Table(name="new_student") //엔티티가 매핑될 테이블의 이름을 지정합니다. 이 경우 new_student 테이블과 매핑됩니다.
@Entity // 이 클래스가 JPA에서 관리할 엔티티 클래스임을 나타냅니다. 데이터베이스의 테이블과 매핑됩니다.
public class Student {
	@Id //이 필드가 기본 키(PK) 임을 나타냅니다.
	@GeneratedValue(strategy=GenerationType.IDENTITY) //기본 키 값 자동 생성 전략입니다. 데이터베이스에서 AUTO_INCREMENT처럼 동작합니다.
	private int id;
	
	private String name;
	private String phoneNumber;
	private String email;
	private String dreamJob;
	
	@CreationTimestamp // 엔티티가 처음 저장될 때의 시간을 자동으로 입력합니다. (createdAt)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp //	엔티티가 업데이트될 때의 시간을 자동으로 입력합니다. (updatedAt)
	private LocalDateTime updatedAt;

}
