package thinkinginspringboot.firstappbygui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ajin
 * @see SpringApplication#run(String...)
 */
@RestController
@SpringBootApplication
public class FirstAppByGuiApplication {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        // 当前引导类
        Class<?> bootstrapClass = FirstAppByGuiApplication.class;
        // 运行Spring Boot , 并返回Spring 应用上下文
        ConfigurableApplicationContext context = new SpringApplicationBuilder(bootstrapClass)
                .web(WebApplicationType.NONE) // 非Web应用
                .run();
        // 当前引导类bean：thinkinginspringboot.firstappbygui.FirstAppByGuiApplication$$EnhancerBySpringCGLIB$$648bb72e@44a2b17b
        System.out.println("当前引导类bean：" + context.getBean(bootstrapClass));
        // 这个结果证实了@SpringBootApplication注解 其实就是 @Component的派生注解
        // 关闭Spring应用上下文
        context.close();


        // SpringApplication.run(FirstAppByGuiApplication.class, args);
    }

    @GetMapping("/hello")
    public String get(String msg) {
        return "hello" + msg;
    }
}

