package com.greedy.hellospring.repository;

import com.greedy.hellospring.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    Board save(Board board);
    Optional<Board> findByTno(Long tno);
    Optional<Board> findByTitle(String title);
    Optional<Board> findByContent(String content);
    List<Board> findAll();
}
