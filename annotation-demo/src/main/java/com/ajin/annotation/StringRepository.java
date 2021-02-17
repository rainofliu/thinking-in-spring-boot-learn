package com.ajin.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 自定义{@link Component}的派生注解
 *
 * @author ajin
 */
@Target({ElementType.TYPE}) // 用于类，接口，枚举和注解上
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface StringRepository {

    /**
     * 属性方法名称必须与{@link Component#value()}保持一致
     * */
    String value() default "";
}
