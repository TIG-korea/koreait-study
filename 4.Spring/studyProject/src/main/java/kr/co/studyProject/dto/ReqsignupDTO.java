package kr.co.studyProject.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ReqsignupDTO {
	
	

	@Id  // PK(Primary Key) 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 자동 증가 (auto_increment)
	private Long id;
	
	private String userName;
	private String email;
	private String userId;
	private String password;
	
	private String phoneNumber;
	

}
