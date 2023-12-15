package com.greedy.hellospring.repository;

import com.greedy.hellospring.domain.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryBoardRepositoryTest {

    MemoryBoardRepository repository = new MemoryBoardRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    public void save() {
        Board board = new Board();
        board.setTitle("Sample Title");
        board.setContent("Sample Content");

        repository.save(board);

        Board result = repository.findByTitle(board.getTitle()).get();

        assertThat(result).isEqualTo(board);
    }
    @Test
    public void findByTitle() {
        Board board1 = new Board();
        board1.setTitle("Sample Title");
        repository.save(board1);

        Board board2 = new Board();
        board2.setTitle("20221212");
        repository.save(board2);

        Board result = repository.findByTitle("Sample Title").get();

        assertThat(result).isEqualTo(board1);
    }
    @Test
    public void findByContent() {
        Board board1 = new Board();
        board1.setContent("Sample Content");
        repository.save(board1);

        Board board2 = new Board();
        board2.setContent("20221212");
        repository.save(board2);

        Board result = repository.findByContent("Sample Content").get();

        assertThat(result).isEqualTo(board1);
        }
        @Test
        public void findAll() {
            Board board1 = new Board();
            board1.setTitle("Sample Title");
            repository.save(board1);

            Board board2 = new Board();
            board2.setTitle("20221212");
            repository.save(board2);

            List<Board> result = repository.findAll();

            assertThat(result.size()).isEqualTo(2);
        }
    }
