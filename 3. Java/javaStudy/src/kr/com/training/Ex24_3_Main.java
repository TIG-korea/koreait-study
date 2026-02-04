package kr.com.training;

import java.util.Scanner;


		//1.  24_3_Main 클래스를 생성하고, 아래와 같이 기본 틀을 만드세요.
		public class Ex24_3_Main {
		    public static void main(String[] args) {																												
		    	Ex24_3_Car car = new Ex24_3_CarImpl();
		        Scanner scanner = new Scanner(System.in);

		        while (true) {
		            System.out.println("자동차 관리 프로그램");
		            System.out.println("1. 자동차 시작");
		            System.out.println("2. 자동차 정지");
		            System.out.println("3. 자동차 가속");
		            System.out.println("4. 자동차 감속");
		            System.out.println("5. 자동차 정보 출력");
		            System.out.println("6. 종료");
		            System.out.print("메뉴를 선택하세요: ");

		            int choice = scanner.nextInt();
		            scanner.nextLine(); // Enter 키 처리

		            switch (choice) {
		                case 1:
		                    car.start();
		                    break;
		                case 2:
		                    car.stop();
		                    break;
		                case 3:
		                    System.out.print("가속할 속도를 입력하세요: ");
		                    int accelerateSpeed = scanner.nextInt();
		                    car.accelerate(accelerateSpeed);
		                    break;
		                case 4:
		                    car.brake();
		                    break;
		                case 5:
		                    System.out.println(car.getInfo());
		                    break;
		                case 6:
		                    System.out.println("프로그램을 종료합니다.");
		                    scanner.close();
		                    System.exit(0);
		                default:
		                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
		            }
		        }
		    }
		

		// 2. 24_3_Car 인터페이스를 생성 후 아래의 추상 메소드를 생성하세요
//			- start()
//			- stop()
//			- accelerate(int speed)
//			- brake()
//			- getInfo()

		// 3. 24_3_CarImpl 클래스를 구현하세요.
//			- Car 인터페이스를 상속 받습니다.
//			- boolean isRunning = false; // 운행 상태 여부
//			- int speed = 0;   // 자동차 속도

//			- start 메소드 구현
//			   - isRunning 변수가 false일 때
//			      --> isRunning 변수를 true로 변경
//			      --> "자동차가 시작되었습니다." 출력
//			   - isRunning 변수가 true일 때
//			      --> "자동차가 이미 시작되어 있습니다." 출력
			
//			- stop 메소드 구현
//			   - isRunning 변수가 true일 때
//			      --> isRunning 변수를 false로 변경
//			      --> spped 변수의 값을 0으로 변경
//			      --> "자동차가 정지되었습니다." 출력
//			   - isRunning 변수가 false일 때
//			      --> "자동차가 이미 정지되어 있습니다." 출력
			
//			- accelerate(int speed) 메소드 구현
//			   - isRunning 변수가 true일 때
//			      --> 인스턴스변수 speed의 현재값에 매개변수 speed 더함
//			      --> "자동차가 " + speed + "km/h로 가속 중입니다."  출력
//			   - isRunning 변수가 false 일 때
//			      --> "자동차가 정지 상태 입니다. 먼저 시작하세요." 출력
			
//			- brake() 메소드 구현
//			   - (if) isRunning 변수가 true, 그리고 spped가 0보다 클 때
//			       --> 인스턴스 변수 spped의 현재값에 10을 줄임
//			       --> "자동차가 감속 중입니다." 출력
//			   - (else if) speed가 0보다 작거나 같을 때
//			       --> "자동차가 이미 정지상태 입니다." 출력
//			   - (else)
//			       --> "자동차가 정지 상태입니다. 먼저 시작하세요." 출력

//			- getInfo() 메소드 구현
//			   - String status 변수 선언
//			   - isRunning 변수가 true일 때
//			      --> status 변수의 값을 "운행 중" 으로 변경
//			   - isRunning 변수가 false일 때
//			      --> status 변수의 값을 "정지" 으로 변경
//			   - "상태: " + status + ", 현재 속도: " + speed + "km/h" 문자열 반환











		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


