package com.greedy.hellospring;

import com.greedy.hellospring.repository.MemoryBoardRepository;
import com.greedy.hellospring.repository.MemoryMemberRepository;
import com.greedy.hellospring.service.BoardService;
import com.greedy.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository());
    }
    @Bean
    public MemoryBoardRepository boardRepository() {
        return new MemoryBoardRepository();
    }
}
