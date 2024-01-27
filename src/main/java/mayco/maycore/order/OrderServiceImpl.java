package mayco.maycore.order;

import mayco.maycore.discount.DiscountPolicy;
import mayco.maycore.member.Member;
import mayco.maycore.member.MemberRepository;
import mayco.maycore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

    //for Test

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
