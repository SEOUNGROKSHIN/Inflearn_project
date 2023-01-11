package com.greedy.hellospring.service;

import com.greedy.hellospring.domain.Member;
import com.greedy.hellospring.repository.MemberRepository;
import com.greedy.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행한다.
@Transactional // 테스트 케이스에 @Transactional이 있으면 테스트 시작전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백한다.

class MemberServiceIntegrationTest {

   @Autowired MemberService memberService;
   @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        // Given
        Member member = new Member();
        member.setName("신승록");
        // When
        Long saveId = memberService.join(member);
        //Then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    void 중복_회원_예외() {
        // Given
        Member member = new Member();
        member.setName("신승록");
        Member member1 = new Member();
        member1.setName("신승록");

        // When
        memberService.join(member);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));
        // 메세지 검증
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다.");

    }
}