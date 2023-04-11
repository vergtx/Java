package com.ruby.java.ch06;

public class Student2 {
	private int sid;
	private String name;
	private String dept;
	public Student2() {}
	public Student2(int sid, String name, String dept) {
		this.sid = sid; this.name = name; this.dept = dept;
		
	}
	public static void main(String[] args) {
		System.out.println("6장 시작");
		int n = 10;
		Student2 s = null; 
		//s = new Student();
		s = new Student2(2023,"김광일", "컴퓨터공부중");
		System.out.println(s.sid);
		s.sid = 99;
		System.out.println(s.sid);
		System.out.println("student 객체 = " + s);
		// sudent s는 참조변수, student = 클래스, s 는 클래스의 객체
		// 5장 6장 기본 용어 개념 확인 필요함
		
		
	}
	
}
