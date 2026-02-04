package kr.com.training;

import java.util.Scanner;

public class Ex24_2_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result;
		
		System.out.println("아이디를 입력 받습니다.");
		String inputId = sc.nextLine();
		
		System.out.println("비밀번호를 입력 받습니다.");	
		String inputPwd = sc.nextLine();
		
		Ex24_2_Login log = new Ex24_2_Login();
	
		 result = log.login(inputId, inputPwd);
	
	System.out.println(result);
		
		
		

//		24_2_Main 클래스를 생성하세요. (메일 메서드 포함)
//			사용자로부터 아이디와 비밀번호를 입력받으세요.
			
//			아래 클래스들을 모두 구현 후 login 메서드를 호출하세요.
//		    	  > 사용자가 입력한 아이디와 비밀번호를 인자값으로 전달해주어야 합니다.
//		    	  > 반환받은 값을 result 변수에 저장 후 출력합니다.


	//2.4_2_LoginInterface 인터페이스를 생성하세요.   
//	    - 반환 타입 : String,  메서드명 : login

	//3. 24_2_Login 클래스를 생성하세요.
	//  - 멤버변수 memberId = "id" , memberPwd = "qwer1234" 를 갖습니다.

	//3. 추상 메서드를 구현하세요.
	//  - 사용자가 입력한 아이디와 비밀번호를 매개변수로 받습니다.
	//  - 아이디와 비밀번호가 일치한다면 "로그인 되었습니다." 문자열을 반환합니다.
	//  - 아이디가 틀렸다면 "아이디가 틀렸습니다." 를 반환합니다.
	//  - 비밀번호가 틀렸다면 "비밀번호가 틀렸습니다."를 반환합니다.






		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
