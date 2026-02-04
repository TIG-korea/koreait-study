package kr.com.training;

public class Ex24_2_Login implements Ex24_2_LoginInterface{
	String memberId = "id";
	String memberPwd = "qwer1234";
	
	
	@Override
	public String login(String inputId, String inputPwd) {
		
		if(!this.memberId.equals(inputId)) {
			return "아이디가 틀렸습니다";
	}else if (!this.memberPwd.equals(inputPwd)){
		return "비밀번호가 틀렸습니다";
	}else {
		return "로그인 되었습니다.";
	}
	
		
	}


	
	

}
