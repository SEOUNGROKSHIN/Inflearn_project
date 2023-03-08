package hello.core;

import hello.core.discount.DiscountPolicy;
<<<<<<< HEAD
=======
import hello.core.discount.FixDiscountPolicy;
>>>>>>> 473ca148b2c2aac76f758239b4b3b04f8e9fe1e4
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
<<<<<<< HEAD
        return new RateDiscountPolicy();
=======
//        return new FixDiscountPolicy();
          return new RateDiscountPolicy();
>>>>>>> 473ca148b2c2aac76f758239b4b3b04f8e9fe1e4
    }
}
