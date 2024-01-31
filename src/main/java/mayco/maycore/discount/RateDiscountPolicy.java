package mayco.maycore.discount;

import mayco.maycore.member.Grade;
import mayco.maycore.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
