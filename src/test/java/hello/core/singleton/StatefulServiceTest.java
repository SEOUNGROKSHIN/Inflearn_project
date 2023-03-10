package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


class StatefulServiceTest {
    
    @Test
    void stateSingletonService() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA" , 1000);
        statefulService1.order("userA" , 10000);
        //ThreadB: B사용자 20000원 주문
        int userBPrice = statefulService1.order("userB" , 20000);
        statefulService2.order("userB" , 20000);
        //ThreadC: C사용자 50000원 주문
        statefulService2.order("userC" , 0);
        //ThreadA : 사용자A 주문 금액 조회

//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);

    }

    static class TestConfig {
        @Bean
        public StatefulService stateService() {
            return new StatefulService();
        }
    }
}