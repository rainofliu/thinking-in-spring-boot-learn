package com.ajin.thinkinginspringboot.annotationdesign.enable.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ajin
 */
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String helloWorld(){ // 创建名为"helloWorld" String 类型的Bean
        return "Hello,World";
    }
}
