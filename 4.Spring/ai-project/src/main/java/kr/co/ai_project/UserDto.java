package kr.co.ai_project;

import lombok.Getter;
import lombok.Setter;

public class UserDto {
	
	// 로그인 요청 DTO
	@Getter
	@Setter
	public static class RequestLogin{
		private String userId;
		private String password;
	}
	
	// 로그인 응답 DTO
	@Getter
	@Setter
	public static class ResponseLogin{
		private String userId;
		private String userName;
	}
	 
	
}
