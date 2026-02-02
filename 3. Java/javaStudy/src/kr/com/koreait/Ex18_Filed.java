package kr.com.koreait;

public class Ex18_Filed {
	// 필드
	int num = 10; // 인스턴스 변수

	public static void main(String[] args) {
		// 필드(=멤버 변수)
		// - 클래스 레벨의 변수를 의미
		int num2 = 20;

		Ex18_1_Car car = new Ex18_1_Car();
		car.wheel = 5;

		System.out.println(car.speed);
		System.out.println(car.wheel);

		Ex18_1_Car sonata = new Ex18_1_Car();
		sonata.wheel = 7;
		sonata.speed = 140;

		System.out.println(sonata.speed);
		System.out.println(sonata.wheel);

		Ex18_2_Person jjanggu = new Ex18_2_Person("짱구", 5, "인천", "010-1234-5678");

//		jjanggu.name = "짱구";
//		jjanggu.age = 5;
//		jjanggu.addr = "인천";
//		jjanggu.phone = "010-1234-5678";
		jjanggu.introduce(); // 호출
//		
		Ex18_2_Person minsu = new Ex18_2_Person("민수",24);
//		minsu.name = "민수";
//		minsu.age = 24;
//		minsu.addr = "서울";
//		minsu.phone = "010-7777-5678";
		minsu.introduce();

		Ex18_2_Person hong = new Ex18_2_Person("홍길동");
		hong.introduce();
//		System.out.println(Ex18_2_Person.HOBBY);

	}

}
