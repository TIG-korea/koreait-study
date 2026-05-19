package kr.co.ai_project2;

import lombok.Getter;
import lombok.Setter;

public class AiDto {
	
	@Getter
	@Setter
	public static class RequestAi{
		private String description;
		private String genre;
		private String level;
		private String purpose;
	}

}
