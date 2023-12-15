package com.greedy.hellospring.service;

import com.greedy.hellospring.domain.Board;
import com.greedy.hellospring.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BoardService {


    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /**
     * 게시글 등록
     *
     * @return
     */
    public Long regist(Board board) {

        validateRegist(board); // 중복검증
        boardRepository.save(board);
        return board.getTno();
    }

    public void validateRegist(Board board) {
        boardRepository.findByTitle(board.getTitle())
                .ifPresent(b -> {
                    throw new IllegalStateException("이미 존재하는 게시글 입니다.");
                });
    }

    /**
     * 전체 게시글 조회 */
    public List<Board> selectAll() {
        return boardRepository.findAll();
    }

    /**
     * 단일 게시글 조회 */
    public Optional<Board> selectOne(Long tno) {
        return boardRepository.findByTno(tno);
    }

}
