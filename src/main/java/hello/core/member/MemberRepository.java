package hello.core.member;

public interface MemberRepository {

   void save(Member member);
   Member findById(Long memberId); // id 조회를 하기 위해 파라미터는 Long타입으로 설정
}
