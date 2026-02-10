package kr.co.studyProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.studyProject.dto.ReqsignupDTO;
import lombok.RequiredArgsConstructor;

@Controller // 컨트롤러임을 선언하는 어노테이션
	// URL 매핑(GET+POST)
@RequiredArgsConstructor  // final 키워드가 붙은 필드에 대한 생성자를 만듬 (생성자 주입 방식)
public class MController {
	private final SignupService signupService;
	
	@GetMapping("/signup")
	public String signupFrom() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(ReqsignupDTO request) {
		signupService.signup(request);
		
		return"";
		
	}
	
	
	
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	
	
	
	
	
}
