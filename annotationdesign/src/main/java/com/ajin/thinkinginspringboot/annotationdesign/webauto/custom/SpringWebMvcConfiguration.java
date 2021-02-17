package com.ajin.thinkinginspringboot.annotationdesign.webauto.custom;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author ajin
 */
@Configuration // 1. 确保当前类可以被ComponentScan扫描注册成为Bean  2. 开启Enable模块装配
@EnableWebMvc
@ComponentScan(basePackageClasses = SpringWebMvcConfiguration.class) // 确保SpringWebMvcConfiguration作为@Component被注册到Spring上下文中
public class SpringWebMvcConfiguration {
}
