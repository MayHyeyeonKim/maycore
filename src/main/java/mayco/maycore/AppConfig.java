package mayco.maycore;

import mayco.maycore.discount.FixDiscountPolicy;
import mayco.maycore.member.MemberService;
import mayco.maycore.member.MemberServiceImpl;
import mayco.maycore.member.MemoryMemberRepository;
import mayco.maycore.order.OrderService;
import mayco.maycore.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository()); //Constructor injection
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }
}


