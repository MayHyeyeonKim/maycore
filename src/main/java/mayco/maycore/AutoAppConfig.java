package mayco.maycore;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "mayco.maycore.member";
//        basePackageClasses = AutoAppConfig.class,
//        관례! base를 지정하지 않으면 AutoAppConfig가 있는 이 패키지 mayco.maycore안을 뒤진다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
