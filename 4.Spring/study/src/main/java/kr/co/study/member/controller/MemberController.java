package kr.co.study.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.study.member.dto.ReqRegisterDTO;
import kr.co.study.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller // 컨트롤러임을 선언하는 어노테이션
@RequestMapping("/member") 	// URL 매핑(GET+POST)
@RequiredArgsConstructor  // final 키워드가 붙은 필드에 대한 생성자를 만듬 (생성자 주입 방식)
public class MemberController{
	
	
	// 필드 주입 방식 (권장 X)
	// @Autowired 
	// private MemberService memberService;
	
	
	private final MemberService memberService;
	
	
	
	/**
	 * 회원기입 페이지로 이동할 때 사용되는 메서드 입니다.
	 * localhost:8080/member/register/form (GET) 요청이 오면 실행 됩니다
	 * @return register
	 */
	
	
	
	// localhost:8080/member/register/form (GET)
	@GetMapping("/register/form")
	public String registerFrom() {
		return "pages/member/register";
	}
	
	
	@PostMapping("/register")
	public String register(ReqRegisterDTO request) {
		memberService.register(request);
		return "pages/member/login";
	}
	
	
}


