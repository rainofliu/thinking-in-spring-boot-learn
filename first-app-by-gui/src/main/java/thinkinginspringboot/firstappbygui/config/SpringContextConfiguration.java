package thinkinginspringboot.firstappbygui.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Indexed;
import thinkinginspringboot.firstappbygui.entity.User;

/**
 * Spring 3.x 的注解驱动编程探讨
 *
 * @author ajin
 */
@Indexed
// @ImportResource("classpath")
@Configuration("springContextConfiguration")
public class SpringContextConfiguration {

    @Lazy
    @Primary
    @DependsOn("springContextConfiguration")  // 依赖springContextConfiguration Bean
    @Role(BeanDefinition.ROLE_APPLICATION)
    @Bean(name = "user")  // bean的名称
    public User user() {
        User user = new User();
        user.setName("mercybliz");
        return user;
    }

}
