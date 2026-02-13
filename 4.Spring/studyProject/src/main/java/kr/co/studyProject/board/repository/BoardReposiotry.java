package kr.co.studyProject.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.studyProject.board.entity.Board;

public interface BoardReposiotry extends JpaRepository <Board, Long> {
	Page<Board> findByBoardTypeOrderByIdDesc(String boardType, Pageable pageable);

}
