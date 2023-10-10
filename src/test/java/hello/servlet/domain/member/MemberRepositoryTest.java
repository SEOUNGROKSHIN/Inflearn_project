/*
package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // GIVEN
        Member member = new Member("hello", 20);

        // WHEN
        Member savedMember = memberRepository.save(member);

        // THEN
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        // GIVEN
        Member memberA = new Member("member1", 20);
        Member memberB = new Member("member2", 20);

        memberRepository.save(memberA);
        memberRepository.save(memberB);
        // WHEN
        List<Member> result = memberRepository.findAll();

        // THEN
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(memberA , memberB);
    }
}*/
