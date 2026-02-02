package kr.com.koreait;

public class Ex20_getterSetter {

	public static void main(String[] args) {
		
		Ex20_1_Person kim = new Ex20_1_Person();
		
		kim.setAge(10);
		System.out.println(kim.getAge());
		
		kim.setName("홍길동");
		System.out.println(kim.getName());
		
		kim.setAddr("인천");
		System.out.println(kim.getAddr());

	}

}
