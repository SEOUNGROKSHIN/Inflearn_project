package com.greedy.hellospring.service;

import com.greedy.hellospring.domain.Member;
import com.greedy.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

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

        /* try {
        memberService.join(member1);
        fail();
        } catch (IllegalStateException e) {
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다.");
        }*/
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}