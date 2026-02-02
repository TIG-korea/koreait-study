package kr.com.training;

public class Ex20_3_Member {
	
	public void itroduce(Ex20_3_MemberInfo memberInfo) {
		String strStudent;
		
		if(memberInfo.getIsStudent()) { // 가져온 isStudent가 true면
			strStudent = "학생";
		} else { // 가져온 isStudent가 flase면
			strStudent = "학생 아님";
		}
		
		System.out.println("이름 : " + memberInfo.getName());
		System.out.println("나이 : " + memberInfo.getAge());
		System.out.println("사느곳 : " + memberInfo.getAddr());
		System.out.println("학생여부 : " + strStudent);
		
	}

	
	public void run(Ex20_3_MemberInfo memberInfo) {
		System.out.println(memberInfo.getAddr() + "에 사는 " + memberInfo.getName() +"가 달리고 있습니다." );
	}
	
	
}
