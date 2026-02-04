package kr.com.training;

public class Ex23_1_Farm {
	Ex23_1_Animal animal1;
	Ex23_1_Animal animal2;
	Ex23_1_Animal animal3;
	Ex23_1_Animal animal4;
	
	public void sound() {
		animal1.cry("1");
		animal2.cry("??");
		animal3.cry("소");
		animal4.cry("돼지");
	}
	
	
	public void cry(Ex23_1_Animal animal,String cry) {
		animal.cry(cry);
	}
	// sound() 메서드를 가집니다
	// - 돼지와 소 객체를 매개변수로 받습니다.
	//		> 다형성을 활용하여 하나의 매개변수로 두 객체를 받으세요.
	// 	- 매개변수로 전달받은 객체의 cry() 메서드를 호출하세요.
	

}
