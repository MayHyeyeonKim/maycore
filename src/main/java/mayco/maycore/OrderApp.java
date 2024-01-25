package mayco.maycore;

import mayco.maycore.member.Grade;
import mayco.maycore.member.Member;
import mayco.maycore.member.MemberService;
import mayco.maycore.member.MemberServiceImpl;
import mayco.maycore.order.Order;
import mayco.maycore.order.OrderService;
import mayco.maycore.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "member!", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("orderCal = " + order.calculatePrice());

    }
}
