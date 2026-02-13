package kr.co.studyProject.board.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import kr.co.studyProject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter                    // 5개 entity 필수 
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	private String boardType;
	
	private String category;
	
	private Integer viewCount;
	
	private String title;
	
	@Lob 
	private String content;
	
	@ManyToOne   // (Board 엔티티) N : 1 (Member 엔티티)    DB에 BIGINT로 저장된 FK를 자바 객체에서 해당 타입의 인스턴스로 바로 사용할 수 있게 해줌
	@JoinColumn(name="writer_id")
	private Member writer;
	

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	

		@PrePersist
		public void prePersist() {
			this.createdAt = LocalDateTime.now();
			this.updatedAt = LocalDateTime.now();
		}
		
	
		@PreUpdate
		public void preUpdate() {
			this.updatedAt = LocalDateTime.now();
		}
	
	
	
	
	
	
	
	
	
}
