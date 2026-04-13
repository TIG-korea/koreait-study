package kr.co.ai_project;

import lombok.Getter;
import lombok.Setter;

public class AiDto {
	
	
	@Setter
	@Getter
	public static class RequestAi {
		private String prompt;
	}
}
