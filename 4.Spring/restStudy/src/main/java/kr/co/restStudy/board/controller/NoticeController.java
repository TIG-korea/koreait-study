package kr.co.restStudy.board.controller;  // 게시판 공지사항 

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import kr.co.restStudy.board.dto.ReqBoardDTO;
import kr.co.restStudy.board.dto.ResBoardDTO;
import kr.co.restStudy.board.service.BoardService;
import kr.co.restStudy.member.dto.ResLoginDTO;
import lombok.RequiredArgsConstructor; 

@RestController  // (생성 안하면 빈 생성 안함)
@RequestMapping("/api/board/notice")
@RequiredArgsConstructor 

public class NoticeController {
	private final BoardService boardService;

	
	/**
	 * 공지사항 페이지로 이동하는 메서드 	
	 * @return notice.html
	 */
	@GetMapping
	public ResponseEntity<Page<ResBoardDTO>> noitceList(@RequestParam(name="page", defaultValue = "1") int page, 
							 Model model) {
		
		// 1. 공지사항 목록 조회
		Page<ResBoardDTO> list = boardService.getBoardList(page - 1);
		
		return ResponseEntity.ok(list);
	}
	
	/**
	 * 공지사항의 게시글 상세보기 페이지로 이동될 때 사용하는 메서드입니다.
	 * - 쿼리스트링으로 전달 받은 id(게시글의 PK)로 조회 합니다.
	 * - 조회된 게시글의 정보를 모델에 담아 타임리프에서 사용합니다.
	 * @param id
	 * @param model
	 * @return 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ResBoardDTO> detail(@PathVariable("id") Long id) {
		ResBoardDTO response =boardService.getBoardDetail(id);
		
		if(response == null) return ResponseEntity.notFound().build();		
		return ResponseEntity.ok(response);
	}
	
	
	

	@PostMapping
	public ResponseEntity<String> create(ReqBoardDTO request, HttpSession session,
						@RequestParam(value = "files", required = false) List<MultipartFile> files) {
		// 1. 로그인한 사용자 정보 세션에서 꺼내기
		ResLoginDTO loginUser = (ResLoginDTO) session.getAttribute("LOGIN_USER");
		
		// 2. 로그인한 사용자가 아니라면 로그인 페이지로 이동
		if (loginUser == null) {
			return ResponseEntity.notFound().build();
		}
		
		// 3. 게시글 저장    
		boardService.write(request, files, loginUser.getId());
		
		// 4. 목록으로 이동
		return ResponseEntity.ok("성공");

	}
	/**
	 * 공지사항 수정 페이지로 이동하는 메서드입니다.
	 */
	@GetMapping("/edit/form")
	public String editForm(@RequestParam (name="id") Long id , Model model) {
		ResBoardDTO response = boardService.getBoardDetailEdit(id);
		model.addAttribute("notice", response);
		
		return "pages/board/notice-edit";}
	
	
	
	
	@PostMapping("/edit")
	public String edit(ReqBoardDTO request, HttpSession session,
						@RequestParam(value = "files", required = false) List<MultipartFile> files) {
		// 1. 로그인한 사용자 조회
		ResLoginDTO loginUser = (ResLoginDTO) session.getAttribute("LOGIN_USER");
		
		// 2. 로그인하지 않은 사용자는 수정 불가
		if (loginUser == null) {
			return "redirect:/member/login/form";
		}
		
		
		// 3. 게시글 수정 진행
		boardService.edit(request, files, loginUser.getId());
		
		return "redirect:/board/notice/detail?id=" + request.getId();
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id,
						   HttpSession session) {
		// 1. 로그인 사용자 정보 조회 
		ResLoginDTO loginUser = (ResLoginDTO)session.getAttribute("LOGIN_USER");
		// 2. 비로그인 상태면 삭제 불가
		if (loginUser == null) 
			return ResponseEntity.notFound().build();   // if문 한줄이면 {} 생략가능 
		
		// 3. 삭제 실행
		boardService.delete(id, loginUser.getId());
		return ResponseEntity.ok("성공");	
	}
	
	
	
}
	
	

