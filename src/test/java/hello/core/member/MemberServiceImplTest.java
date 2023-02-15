package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {

    MemberService memberService = new MemberServiceImpl();
    @Test
    void join() {
        // Given
        Member member = new Member(1L , "MemberA" , Grade.BASIC);
        // When
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        // Then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findById() {


    }
}