package com.andy.spring.ex.lifecycle;

public class Person {
	// 이름, 나이
	private String name;
	private int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {	//json lib 에서 get으로 당연히 해야하는데 없으니까 메서드 만들어줘야함
		return name;
	}
	
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "나이 : " + age;
	}
}
