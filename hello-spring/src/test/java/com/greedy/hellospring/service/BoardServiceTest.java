package com.greedy.hellospring.service;

import com.greedy.hellospring.domain.Board;
import com.greedy.hellospring.repository.BoardRepository;
import com.greedy.hellospring.repository.MemoryBoardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BoardServiceTest {

    BoardService boardService;
    BoardRepository boardRepository;

    // 데이터가 의존성을 가지기에 초기화가 필요함.
    @BeforeEach
    public void beforEach() {
        boardRepository = new MemoryBoardRepository();
        boardService = new BoardService(boardRepository);
    }

    @Test
    void regist() {
        // Given
        Board board = new Board();
        board.setTitle("Sample Title");
        // When
       Long saveTno = boardService.regist(board);
        //Then
       Board findTitle = boardService.selectOne(saveTno).get();
        assertThat(board.getTitle()).isEqualTo(findTitle.getTitle());
    }

    @Test
    void validateRegist() {
        // Given
        Board board = new Board();
        board.setTitle("Sample Title");

        Board board1 = new Board();
        board.setTitle("Sample Title");

        // When
        boardService.regist(board);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> boardService.regist(board));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 게시글 입니다.");
    }

    @Test
    void selectAll() {

        // Given
        Board board = new Board();
        board.setTitle("Sample Title");
        boardRepository.save(board);

        Board board1 = new Board();
        board.setTitle("Sample TTitle");
        boardRepository.save(board1);

        Board board2 = new Board();
        board.setTitle("Sample TTitle");
        boardRepository.save(board2);
        // When
        List<Board> result =boardService.selectAll();
        assertThat(result.size()).isEqualTo(3);

        // Then

    }

    @Test
    void selectOne() {
    }
}