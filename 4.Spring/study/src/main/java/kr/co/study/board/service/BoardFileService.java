package kr.co.study.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.co.study.board.dto.ResBoardFileDTO;
import kr.co.study.board.entity.Board;



/**
 * 게시판 첨부파일을 저장/조회/삭제 담당하는 서비스
 * 게시판 도메인(Board)에서만 사용하는 전용 파일 서비스
 */
public interface BoardFileService {
	/**
	 * 게시글 첨부 파일 저장
	 * - files가 비어있으면 종료 (사용자가 파일을 업로드 하지 않앗다면)
	 * - 파일명(UUID) 생성 후 로컬에 저장
	 * 		> /src/reousrces/static/uploads/board
	 * - board_file 테이블에 저장
	 * 
	 * @param board 게시글 엔티티
	 * @param files 업로드 파일 목록
	 */
	void saveFiles(Board board, List<MultipartFile> files);
	
	/**
	 * 게시글 파일 수정 (교체)
	 * -새로 업로드된 파일이 없으면 종료 (기존 파일 유지)
	 * - 기존 파일 목록 조회
	 * - 서버(uploads/board)에 저장된 기존 파일 삭제
	 * - 새 파일을 서버에 저장 및 board_file 테이블에 파일 정보 저장
	 */
	void replaceFiles(Board board, List<MultipartFile> files);
	
	
	/**
	 * 파일 정보 조회
	 * - board_id 기준으로 파일 조회 
	 */
	List<ResBoardFileDTO> getFiles(Long boardId);

	
	/**
	 * 게시글 삭제 시 파일 (로컬 + DB) 삭제
	 * - board_id 기준으로 파일 조회
	 * - 로컬에 저장된 파일 삭제
	 * - board_file 테이블에 있는 데이터 삭제
	 * 
	 */
	void deleteFiles(Long boardId);
	
}
