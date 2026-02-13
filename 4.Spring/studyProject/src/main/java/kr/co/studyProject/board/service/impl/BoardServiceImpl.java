package kr.co.studyProject.board.service.impl;

import org.springframework.stereotype.Service;

import kr.co.studyProject.board.dto.ReqBoardDTO;
import kr.co.studyProject.board.entity.Board;
import kr.co.studyProject.board.repository.BoardReposiotry;
import kr.co.studyProject.board.service.BoardService;
import kr.co.studyProject.entity.Member;
import kr.co.studyProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final MemberRepository memberRepository;
	private final BoardReposiotry boardRepository;

	
	@Override
	public void write(ReqBoardDTO request, Long writerId) {
		Member writer = memberRepository.findById(writerId).orElse(null);
		
		if (writer == null) {
			System.out.println("유효하지 않은 사용자입니다.");
		}
		
		Board board = new Board();
		board.setBoardType("NOTICE");
		board.setCategory(request.getCategory());
		board.setTitle(request.getTitle());
		board.setContent(request.getContent());
		board.setWriter(writer);
		board.setViewCount(0);
		

		boardRepository.save(board);

		
		
		
		
	}
	

}
