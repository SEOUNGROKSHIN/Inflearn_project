package com.greedy.hellospring;

import com.greedy.hellospring.repository.*;
import com.greedy.hellospring.service.BoardService;
import com.greedy.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final EntityManager em;
    // 생성자 주입 방식
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//          return new MemoryMemberRepository();
//          return new JdbcMemberRepository(dataSource);
//          return new JdbcTemplateMemberRepository(dataSource);
           return new JpaMemberRepository(em);
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
