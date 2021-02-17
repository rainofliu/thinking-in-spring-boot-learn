package com.ajin.thinkinginspringboot.annotationdesign.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 指定系统属性名称与系统值匹配条件注解
 * @author ajin
 */
@Target({ElementType.METHOD}) // 只能标注在方法上面
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {

    /**
     * @return 系统属性名称
     * */
    String name();
    /**
     * @return 系统属性值
     * */
    String value();
}
