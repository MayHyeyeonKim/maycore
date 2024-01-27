package mayco.maycore;

import mayco.maycore.discount.DiscountPolicy;
import mayco.maycore.discount.FixDiscountPolicy;
import mayco.maycore.discount.RateDiscountPolicy;
import mayco.maycore.member.MemberService;
import mayco.maycore.member.MemberServiceImpl;
import mayco.maycore.member.MemoryMemberRepository;
import mayco.maycore.order.OrderService;
import mayco.maycore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }
}


