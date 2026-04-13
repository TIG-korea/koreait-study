package kr.co.ai_project;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	public UserDto.ResponseLogin  login(UserDto.RequestLogin req){
		
		if("test".equals(req.getUserId()) && "1234".equals(req.getPassword())) {
			UserDto.ResponseLogin response = new UserDto.ResponseLogin();
			response.setUserId("test");
			response.setUserName("홍길동");
			
			return response;
		}
		return null;
		
	}
}
