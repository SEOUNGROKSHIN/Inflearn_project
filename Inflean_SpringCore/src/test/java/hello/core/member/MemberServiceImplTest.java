package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceImplTest {

    MemberService memberService;

    @BeforeEach
    public void beforEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join() {
        // Given
        Member member = new Member(1L , "MemberA" , Grade.BASIC);
        // When
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        // Then
        assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findById() {
        // Given
        Member member = new Member(1L , "MemberA" , Grade.BASIC);
        // When
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        // Then
        assertThat(member).isEqualTo(findMember);
    }
}