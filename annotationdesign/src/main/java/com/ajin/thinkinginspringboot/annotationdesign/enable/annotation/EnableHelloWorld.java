package com.ajin.thinkinginspringboot.annotationdesign.enable.annotation;

import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.lang.annotation.*;

/**
 * 模仿{@link EnableWebMvc} 编程模式 所写的Enable***注解
 * @author ajin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorld {

}
