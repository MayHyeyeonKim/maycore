package mayco.maycore.singleton;

import mayco.maycore.AppConfig;
import mayco.maycore.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    @DisplayName("DI container without Spring")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }
    @Test
    @DisplayName("Using an object with the Singleton pattern")

    void singletonServiceTest(){
//        new SingletonService(); //java: SingletonService() has private access in mayco.maycore.singleton.SingletonService
        SingletonService singleton1 = SingletonService.getInstance();
        SingletonService singleton2 = SingletonService.getInstance();
        System.out.println("singleton1 = " + singleton1);
        System.out.println("singleton2 = " + singleton2);

        assertThat(singleton1).isSameAs(singleton2);

        //same == same or different objects in memory
        //equal content-based equality
    }
}
