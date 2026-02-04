package kr.com.training;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Ex23_main {

	public static void main(String[] args) {

		// 1. Farm 객체 생성
		Ex23_1_Farm f = new Ex23_1_Farm();
		f.animal1 = new Ex23_1_Pig();
		f.animal2 = new Ex23_1_Pig();
		f.animal3 = new Ex23_1_Pig();
		f.animal4 = new Ex23_1_Cow();
		f.sound();

		// 2. Pig 객체 생성
		Ex23_1_Pig p = new Ex23_1_Pig();
		
		// 3. Cow 객체 생성
		Ex23_1_Cow c = new Ex23_1_Cow();
		
	
		
		
		// 4. Farm의 sound() 메서드를 호출하세요.
		// - 2번 호출하며 각각 Pig와 Cow 객체를 인자로 넘겨주세요.
		f.cry(p,"꿀꿀");
		f.cry(c,"음메");
		
		// ------------------------------------------------	
		// Q. 부부가 식사중에 여자가 말했다.
		// " 여보 마트가서 우유사고 만약에 아보카도 있으면 6개 사와"
		// 개발자 남자는 마트를 다녀온 뒤 우유 6개를 건내며 말했다.  "아보카도 있었어"
		// 조건에 맞춰 기능을 구현하세요. 
		
		// Ex23_2_AvocadoCondition 클래스를 생성하세요.
		// - hasAvocado 메서드를 작성하세요.
		//		> 해당 메서드는 false를 반환합니다 . 
		
		// Ex23_2_HasAvocado 클래스를 생성하세요.
		// - Ex23_2_AvocadoCondition 클래스를 상속 받습니다.
		// - hasAvocado 메서드를 오버라이딩 하세요.
		// 		> 해당 메서드는 true를 반환합니다
		
		// Ex23_2_NoAvocado 클래스를 생성하세요
		// - Ex23_2_AvocadoCondition 클래스를 상속 받습니다.
		// - 부모의 기본 동작을 그대로 사용하기 때문에 오버라이딩을 하지 않습니다.
		
		// Ex23_2_SuperMarket 클래스를 생성하세요.
		// - 정수형 milkCount 필드를 가집니다.
		//		> 접근 제어자 : private
		// - goSuperMarket 메서드를 가집니다.
		//		> 해당 메서드는 Ex23_2_HasAvocado, Ex23_2_NoAvocado 두 객체를 
		//			매개변수로 받습니다.( 다형성을 활용하여 1개의 매개변수로 받으세요)
		//				> 호출 결과가 true라면 milkCount를 6으로 할당
		//				> 호출 결과가 false라면 milkCount를 1으로 할당
		// - milkCount 필드에 대한 getter를 작성하세요.
		
		System.out.println("=========================");
		
		
		Ex23_2_SuperMarket market = new Ex23_2_SuperMarket();
		
		// 아보카도가 있는 경우
		Ex23_2_HasAvocado c1 = new Ex23_2_HasAvocado();
		market.goSuperMarket(c1);
		System.out.println("구입한 우유 개수 : " + market.getMilkCount());
		
		// 구현 다 하고 아보카도 없는 경우(NoAvocado 객체)도 작성
		
		Ex23_2_NoAvocado c2 = new Ex23_2_NoAvocado();
		market.goSuperMarket(c2);
		System.out.println("구입한 우유 개수 : " + market.getMilkCount());
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
