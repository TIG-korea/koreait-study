package kr.com.training;

public class Ex24_1_Main {

	public static void main(String[] args) {
//		- main 메서드에서 SportsCar와 RegularCar의 객체를 생성하고 메서드를 모두 실행하세요.
		Ex24_1_Car sc = new Ex24_1_SportsCar();
		sc.start();
		sc.accelerate();
		sc.brake();
		
		Ex24_1_Car rc = new Ex24_1_RegularCar();
		rc.start();
		rc.accelerate();
		rc.brake();

	}
}


//	- 자동차 인터페이스(Ex24_1_Car)를 생성하세요. 
//	   -> 자동차 인터페이스는 start(), accelerate(), brake() 추상 메서드를 갖습니다.

//- Ex24_1_SportsCar 클래스를 생성하고 인터페이스를 물려받아 구현하세요.
//-> 물려받은 추상 메서드를 모두 구현하세요.
//-> start() : "스포츠카를 시동합니다." 출력
//-> accelerate() : "스포츠카를 가속합니다." 출력
//-> brake() : "스포츠카를 제동합니다." 출력

//- Ex24_1_RegularCar 클래스를 생성하고 인터페이스를 물려받아 구현하세요.
//-> 물려받은 추상 메서드를 모두 구현하세요.
//-> start() : "일반 자동차를 시동합니다." 출력
//-> accelerate() : "일반 자동차를 가속합니다." 출력
//-> brake() : "일반 자동차를 제동합니다." 출력


		
		
		
		
		
		
		
		
		
		
		
		
		


