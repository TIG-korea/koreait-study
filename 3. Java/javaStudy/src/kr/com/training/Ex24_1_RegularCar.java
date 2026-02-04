package kr.com.training;

public class Ex24_1_RegularCar implements Ex24_1_Car {
	
	@Override
	public void start() {
		System.out.println("일반 자동차를 시동합니다.");
	}
	@Override
	public void accelerate() {
		System.out.println("일반 자동차를  가속합니다.");
	}
	@Override
	public void brake() {
		System.out.println("일반 자동차를 제동합니다.");
	}
	
	
	

}
