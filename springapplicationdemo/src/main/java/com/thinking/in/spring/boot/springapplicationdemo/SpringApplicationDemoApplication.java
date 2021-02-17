package com.thinking.in.spring.boot.springapplicationdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;

/**
 * @author ajin
 */
//@SpringBootApplication
@EnableAutoConfiguration
public class SpringApplicationDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringApplicationDemoApplication.class);
        AnnotationMBeanExporter beanExporter = context.getBean(AnnotationMBeanExporter.class);
        System.out.println("AnnotationMBeanExporter Bean:" + beanExporter);
        // 关闭Spring上下文
        context.close();
    }

}
