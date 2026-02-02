package kr.com.koreait;

public class Ex21_3_Animal {
	String name;
	int age;
	
	Ex21_3_Animal(String name, int age){
		this.name = name;
		this.age = age;
	}

	public void eat() {
		System.out.printf("%s(%d) 이(가) 먹는중입니다 \n",name,age);
	}
	
	public void sleep() {
		System.out.printf("%s(%d) 이(가) 자는중입니다 \n",name,age);
	}
	
}
