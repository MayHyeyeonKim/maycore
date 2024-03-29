package mayco.maycore.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingletonTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService sS1 = ac.getBean(StatefulService.class);
        StatefulService sS2 = ac.getBean(StatefulService.class);

        int sS1Price = sS1.order("userA", 10000);
        int sS2Price = sS2.order("userB", 20000);

        System.out.println("Price = " + sS1Price);


//        assertThat(sS1Price.getPrice()).isEqualTo(20000);
    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}