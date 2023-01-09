package com.greedy.hellospring.service;

import com.greedy.hellospring.domain.Member;
import com.greedy.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

// 서비스는 비즈니스 롤에 맞도록 기능을 구현 + 네이밍 설정
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입*/
    public Long join(Member member) {

        validateDuplicateMember(member);    // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
        throw new IllegalStateException("이미 존재하는 회원 입니다.");
        });
    }

    /**
     * 전체 회원 조회*/
    public List<Member> findMembers() {
       return memberRepository.findAll();

    }

    /**
     * 단일 회원 조회 */
    public Optional<Member> findOne(Long memberId) {

        return memberRepository.findById(memberId);
    }
}
