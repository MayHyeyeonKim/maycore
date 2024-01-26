package mayco.maycore.beanfind;

import mayco.maycore.AppConfig;
import mayco.maycore.member.Member;
import mayco.maycore.member.MemberService;
import mayco.maycore.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Retrieve by Bean Name")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService.getClass() = " + memberService.getClass());

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("Retrieve by Type without Specifying the Name")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

//    @Test
//    @DisplayName("Retrieve by Concrete Type")
//    void findBeanByConcreteType(){
//        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
//        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//    }

    @Test
    @DisplayName("Retrieve by Bean Name X")
    void findBeanByNameX(){
//        ac.getBean("xxxx", MemberService.class);
//        MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
    }

}
