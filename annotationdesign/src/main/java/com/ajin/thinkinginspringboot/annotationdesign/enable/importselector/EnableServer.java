package com.ajin.thinkinginspringboot.annotationdesign.enable.importselector;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author ajin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(ServerImportSelector.class) // 导入 ServerImportSelector
@Import(ServerImportBeanDefinitionRegistrar.class)
public @interface EnableServer {

    /**
     * 设置服务器的类型
     * */
    Server.Type type();
}
