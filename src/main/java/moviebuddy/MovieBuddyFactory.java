package moviebuddy;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"moviebuddy"})
@Import({MovieBuddyFactory.DomainModuleConfig.class, MovieBuddyFactory.DataSourceModuleConfig.class})
//@ImportResource("xml file location") xml로 작성한 경우
public class MovieBuddyFactory {

    @Configuration
    static class DomainModuleConfig {

    }

    @Configuration
    static class DataSourceModuleConfig {

    }

}
