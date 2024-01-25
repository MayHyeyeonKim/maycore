package mayco.maycore.discount;

import mayco.maycore.member.Grade;
import mayco.maycore.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("should be applied 10% discount if the member is a VIP")
    void vip_o(){
        //given
        Member member = new Member(1L, "MTestVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("shouldnt be applied 10% discount if the member is not VIP")
    void vip_x(){
        //given
        Member member = new Member(1L, "MTestBasic", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}