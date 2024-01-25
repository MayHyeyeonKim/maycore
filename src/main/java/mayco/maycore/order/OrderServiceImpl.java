package mayco.maycore.order;

import mayco.maycore.discount.DiscountPolicy;
//import mayco.maycore.discount.FixDiscountPolicy;
//import mayco.maycore.discount.RateDiscountPolicy;
import mayco.maycore.member.Member;
import mayco.maycore.member.MemberRepository;
import mayco.maycore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
