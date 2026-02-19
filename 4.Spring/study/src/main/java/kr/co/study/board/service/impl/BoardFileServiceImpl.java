package kr.co.study.board.service.impl;

import java.awt.image.DirectColorModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;
import kr.co.study.board.dto.ResBoardFileDTO;
import kr.co.study.board.dto.SaveFile;
import kr.co.study.board.entity.Board;
import kr.co.study.board.entity.BoardFile;
import kr.co.study.board.repository.BoardFileRepository;
import kr.co.study.board.service.BoardFileService;
import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class BoardFileServiceImpl implements BoardFileService{
	private final BoardFileRepository boardFileRepository;
	
	// 파일 업로드 경로
	private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/uploads/board";
	private static final String FILE_PATH_PREFIX = "/uploads/board/";
	
	
	@Override
	public List<ResBoardFileDTO> getFiles(Long boardId) {
		List<BoardFile> boardFiles = boardFileRepository.findAllByBoardId(boardId);    //findBy필드명 - 1건 조회 
		
		List<ResBoardFileDTO> fileList = new ArrayList<>();
		
		for(BoardFile file : boardFiles) {
			ResBoardFileDTO response = ResBoardFileDTO.builder()
										.id(file.getId())
										.originalFileName(file.getOriginalFileName())
										.storedFileName(file.getStoredFileName())
										.filePath(file.getFilePath())
										.fileSize(file.getFileSize())
										.contentType(file.getContentType())
										.build();			
			fileList.add(response);
			
		}
		return fileList;
	}

	@Override
	@Transactional
	public void replaceFiles(Board board, List<MultipartFile> files) {
		// 1. 새로 업로드된 파일이 없으면 종료 (기존 파일 유지)
		if(!hasNewFiles(files)) return; 
		
		// 2. 기존 파일 목록 조회
		List<BoardFile> oldFiles = boardFileRepository.findAllByBoardId(board.getId());
		
		// 3. 디스크에 저장된 기존 파일 삭제
		File dir = new File(UPLOAD_DIR);
		
		for(BoardFile oldFile : oldFiles) {
			File diskFile = new File(dir, oldFile.getStoredFileName());
			
			if(diskFile.exists()) {
				diskFile.delete(); // 파일 삭제
			}
			
		}
		// 4. DB 기존 파일 정보 삭제 
		boardFileRepository.deleteAll(oldFiles);
		
		// 5. 새 파일 저장
		saveFiles(board,files);
	}
	
	
	
		
	@Override
	@Transactional
	public void saveFiles(Board board, List<MultipartFile> files) {
		// 1. 업로드한 파일이 없을경우 메서드 종료
		if(files == null || files.isEmpty()) return;
			
		
		// 2. 업로드 디렉토리(uploads)가 없을 경우 디렉토리 생성
		File dir = new File(UPLOAD_DIR); // import java.io.File
		if(!dir.exists()) dir.mkdirs();
		
		for(MultipartFile file : files) {
			if (file == null || file.isEmpty()) continue;
		
		// 3. 파일을 로컬에 저장
		SaveFile saved = saveFileToDisk(file, dir);
		
		// 4. 파일 정보를 데이터베이스에 저장 
		BoardFile boardFile = BoardFile.builder()
								.board(board)
								.originalFileName(saved.getOriginalFileName())
								.storedFileName(saved.getStoredFileName())
								.contentType(saved.getContentType())
								.fileSize(saved.getFileSize())
								.filePath(saved.getFilePath())
								.build();
		
		boardFileRepository.save(boardFile);
		
		}
	}
	
	@Override
	@Transactional
	public void deleteFiles(Long boardId) {
		
		// 1. 기존 첨부파일 목록 조회
		List<BoardFile> oldFiles = boardFileRepository.findAllByBoardId(boardId);
		
		// 2. 디스크에 저장된 기존 파일 삭제
		File dir = new File(UPLOAD_DIR);
		for(BoardFile oldFile : oldFiles) {
			File diskFile = new File(dir, oldFile.getStoredFileName());
			if(diskFile.exists()) {
				diskFile.delete();
			}
		}
		
		// 3. DB 기존 데이터 삭제
		boardFileRepository.deleteAll(oldFiles);
		
	}
	
	
	
	
	/**
	 * 업로드 파일을 FILE_PATH_PERFIX 디렉토리에 저장하고 저장 결과를 반환해주는 메서드
	 * @param file 저장할 파일 정보
	 * @param dir 저장할 디렉토리
	 * @return 저장 결과가 담긴 객체 
	 */
	private SaveFile saveFileToDisk(MultipartFile file, File dir) {
		
		//  사용자가 업로드한 파일명 가져오기
		String originalFileName = file.getOriginalFilename();
		
		// 원본 파일명이 없거나 공백이면(isBlank) 기본 파일명(unknown)으로 대체 
		if(originalFileName == null | originalFileName.isBlank()) {
			originalFileName = "unknown";
		}
		
		// 파일의 확장자를 담을 변수
		// - ex) .png, .pdf, ...
		String ext = "";
		
		// 파일명에서 마지막.의 위치(인덱스) 찾기
		// - 없을 경우 -1 반환
		int dotIndex = originalFileName.lastIndexOf('.');
		
		// 파일명에서 . 이 존재한다면
		if(dotIndex > -1) {
			// 찾은 .의 인덱스부터 문자열을잘라 확장자 가져오기
			ext = originalFileName.substring(dotIndex);
		}
		
		// 랜던(UUID) 파일명 (실제 로컬에 저장되는 파일명)
		String storedFileName = UUID.randomUUID() + ext;	
		
		// 경로 + 파일명을 합쳐 실제로 저장된 File 객체 생성
		File savedFile = new File(dir, storedFileName);
		
		
//		file.transferTo(savedFile); ( try/catch 로 묶음)
		try {
			//해당 경로(서버)에 파일 저장
			file.transferTo(savedFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SaveFile.builder()
				.originalFileName(originalFileName)
				.storedFileName(storedFileName)
				.contentType(file.getContentType())
				.fileSize(file.getSize())
				.filePath(FILE_PATH_PREFIX + storedFileName)
				.build();
		
	}
	
	// 새로운 업로드 파일이 있는지 검사하는 메서드 
	private boolean hasNewFiles(List<MultipartFile> files) {
		// 1. files 리스트가 없거나 비어있으면 false 반환
		if(files == null || files.isEmpty()) {
			return false;
		}
		
		// 2. 실제 업로드한 파일이 1개라도 존재 한다면 true 반환
		for(MultipartFile file : files) {
			if(file != null && !file.isEmpty()) {
				return true;
			}

			
		}
		return false;
	}
	
	
	
}
