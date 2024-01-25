package mayco.maycore;

import mayco.maycore.discount.DiscountPolicy;
import mayco.maycore.discount.FixDiscountPolicy;
import mayco.maycore.discount.RateDiscountPolicy;
import mayco.maycore.member.MemberService;
import mayco.maycore.member.MemberServiceImpl;
import mayco.maycore.member.MemoryMemberRepository;
import mayco.maycore.order.OrderService;
import mayco.maycore.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }
}


