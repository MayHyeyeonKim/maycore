package mayco.maycore.singleton;

import mayco.maycore.AppConfig;
import mayco.maycore.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    @DisplayName("DI container without Spring")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberServiceImpl memberService1 = appConfig.memberService();
        MemberServiceImpl memberService2 = appConfig.memberService();

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

    @Test
    @DisplayName("SpringContainer&Singleton")
    void springContatiner(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService1 = ac.getBean("memberService", MemberServiceImpl.class);
        MemberServiceImpl memberService2 = ac.getBean("memberService", MemberServiceImpl.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);

    }
}
