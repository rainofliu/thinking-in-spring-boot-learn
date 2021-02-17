package com.ajin.thinkinginspringboot.annotationdesign.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;

/**
 * @author ajin
 */
@Configuration
@ComponentScan(basePackageClasses = CalculatingService.class)
public class CalculatingServiceBootstrap {

    static {
        // 通过Java系统属性设置 Spring Profile
        // == ConfigurableEnvironment.setActiveProfiles("Java 8")
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME,"Java8");
        // == ConfigurableEnvironment.setDefaultProfiles("Java 7")
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME,"Java7");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(CalculatingServiceBootstrap.class);

        context.refresh();

        CalculatingService service = context.getBean(CalculatingService.class);

        service.sum(1,2,3,4,5);
        context.close();
    }
}
