package kr.co.studyProject.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kr.co.studyProject.board.dto.ReqBoardDTO;
import kr.co.studyProject.board.service.BoardService;
import kr.co.studyProject.dto.ResLoginDTO;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class NoticeController {
	private final BoardService boardService;

	
	
	@GetMapping("/board")
	public String noticeList() {
		
		return "board";
	}
	
	@GetMapping("/board-write")
	public String createform() {
		return "board-write";
	}
	 
	@PostMapping("/board-write") 
		public String create(ReqBoardDTO request, HttpSession session) {
		ResLoginDTO loginUser = (ResLoginDTO) session.getAttribute("LOGIN_USER");

		if (loginUser == null) {
			return "redirect:/login";
		}
		
//		loginUser.setId(request.getId());
		boardService.write(request, loginUser.getId());
		return"board";
	}
	
	

}
