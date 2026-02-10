package kr.co.study.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kr.co.study.member.dto.ReqLoginDTO;
import kr.co.study.member.dto.ReqRegisterDTO;
import kr.co.study.member.dto.ResLoginDTO;
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

	 */
	
	
	
	// localhost:8080/member/register/form (GET)
	@GetMapping("/register/form")
	public String registerFrom() {
		return "pages/member/register";
	}
	
	
	/**
	 * 회원가입 요청을 처리할 때 사용되는 메서드입니다.
	 * localhost:8080/member/register로 POST 요청이 오면 처리합니다.
	 * 
	 * @param 요청 데이터의 이름(userName, userId, ...)과 ReqResiterDTO의 변수명이 일치해야 합니다.
	 * @return /src/resoureces/templates/pages/member/login.html
	 */

	@PostMapping("/register")
	public String register(ReqRegisterDTO request) {
		memberService.register(request);
		
		// redirect를 앞에 붙이면 해당 경로를 Spring에게 다시 요청
		// - 쉽게는 컨트롤러가 컨트롤러를 다시 호출할 때 주로 사용 
		return "redirect:/member/login/form";            
	}
	
	@GetMapping("/login/form")
	public String loginForm() {
		return "pages/member/login";
	}
	
	/**
	 * 로그인 요청을 처리하는 메서드 입니다.
	 * 
	 * @param request 사용자가 입력한 로그인 정보 
	 * @return 
	 */
	@PostMapping("/login")
	public String post(ReqLoginDTO request,
					   HttpSession session) {
		ResLoginDTO response = memberService.login(request);
		
		if(response == null) {
			return "redirect:/member/register/form";
		}
		
		// 로그인이 성공할 경우
		session.setAttribute("LOGIN_USER", response);
		return "redirect:/"; // 메인 페이지로 이동 
	}
	/**
	 * 로그아웃을 처리하는 메서드입니다.
	 * 세션을 무효화한 후 메인 페이지로 이동
	 * 
	 * @parm session 현재 사용자의 세션
	 * @return /로 리다이렉트 (메인 페이지)
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate(); // 세션 무효화 
		return "redirect:/";
	}

}


