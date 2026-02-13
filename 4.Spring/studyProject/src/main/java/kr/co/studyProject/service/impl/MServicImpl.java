package kr.co.studyProject.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.studyProject.dto.ReqLoginDTO;
import kr.co.studyProject.dto.ReqsignupDTO;
import kr.co.studyProject.dto.ResLoginDTO;
import kr.co.studyProject.entity.Member;
import kr.co.studyProject.repository.MemberRepository;
import kr.co.studyProject.service.MServic;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class MServicImpl implements MServic{

	private final MemberRepository memberRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void singup(ReqsignupDTO request) {
		
		if (!request.getPassword().equals(request.getPasswordCheck())) {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
		if (memberRepository.existsByUserId(request.getUserId())) {
			System.out.println("이미 사용중인 아이디 입니다");
		}
		
		if (memberRepository.existsByEmail(request.getEmail())) {
			System.out.println("이미 사용중인 이메일 입니다");
		}
		
		if (memberRepository.existsByPhoneNumber(request.getPhoneNumber())) {
			System.out.println("이미 사용중인 전화번호 입니다");
		}
		
		
		String encodedPassword = passwordEncoder.encode(request.getPassword());
	
		
		Member member = new Member();
		member.setUserId(request.getUserId());
		member.setUserName(request.getUserName());
		member.setEmail(request.getEmail());
		member.setPassword(encodedPassword);
		member.setPhoneNumber(request.getPhoneNumber());
		
		memberRepository.save(member);
		
	}
	
	@Override
	public ResLoginDTO login(ReqLoginDTO request) {
		
		Member member = memberRepository.findByEmail(request.getEmail());
		
		if(member == null) {
			return null;
		}
		if(!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
			return null;
		}
		
		ResLoginDTO response = ResLoginDTO.builder()
								.email(member.getEmail())
								.id(member.getId())
								.build();
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
