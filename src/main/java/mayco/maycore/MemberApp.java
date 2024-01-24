package mayco.maycore;

import mayco.maycore.member.Grade;
import mayco.maycore.member.Member;
import mayco.maycore.member.MemberService;
import mayco.maycore.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member: " + member.getName());
        System.out.println("find Member: " + findMember.getName());
    }
}
