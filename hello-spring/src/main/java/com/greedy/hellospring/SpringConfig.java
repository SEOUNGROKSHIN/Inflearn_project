package com.greedy.hellospring;

import com.greedy.hellospring.repository.JdbcMemberRepository;
import com.greedy.hellospring.repository.MemoryBoardRepository;
import com.greedy.hellospring.service.BoardService;
import com.greedy.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Autowired
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public JdbcMemberRepository memberRepository() {
//        return new MemoryMemberRepository();
          return new JdbcMemberRepository(dataSource);
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
