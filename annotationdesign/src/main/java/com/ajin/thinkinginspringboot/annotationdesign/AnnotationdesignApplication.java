package com.ajin.thinkinginspringboot.annotationdesign;

import com.ajin.thinkinginspringboot.annotationdesign.enable.annotation.EnableHelloWorld;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author ajin
 */
@EnableHelloWorld
@Configuration
public class AnnotationdesignApplication {

    public static void main(String[] args) {
        // 构建 Annotation 配置驱动 Spring上下文
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        // 注册当前引导类(被@Configuration标注)到Spring上下文
        context.register(AnnotationdesignApplication.class);
        // 启动上下文
        context.refresh();
        // 获取名称为 "helloWorld " 的Bean对象
        String helloWorld = context.getBean("helloWorld",String.class);
        // 输出用户名称  "HelloWorld"
        System.out.printf("helloWorld = %s \n" ,helloWorld);
        // 关闭上下文
        context.close();
    }

}
