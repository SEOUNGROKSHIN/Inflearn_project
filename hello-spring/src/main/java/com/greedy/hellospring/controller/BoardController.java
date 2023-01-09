package com.greedy.hellospring.controller;

import com.greedy.hellospring.domain.Board;
import com.greedy.hellospring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired //생성자를 이용한 의존성 주입
    public BoardController(BoardService boardService) {
        this.boardService = boardService;

    }

    @GetMapping("/board/regist")
    public String createForm() {
        return "/board/regist";
    }

    @PostMapping("/board/regist")
    public String regist(BoardForm boardForm) {

        Board board = new Board();
        board.setTitle(boardForm.getTitle());
        board.setContent(boardForm.getContent());

        //  비즈니스 로직을 수행할 서비스 객체 연결
        boardService.regist(board);

        return "redirect:/";
    }

    @GetMapping("/board/list")
    public String list(Model model) {

        List<Board> boards = boardService.selectAll();

        model.addAttribute("boards" , boards);
        return "/board/boardList";
    }
}
