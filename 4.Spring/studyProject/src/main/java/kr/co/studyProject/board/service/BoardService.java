package kr.co.studyProject.board.service;





import kr.co.studyProject.board.dto.ReqBoardDTO;


public interface BoardService {
	
	void write(ReqBoardDTO request, Long writerId);

}
