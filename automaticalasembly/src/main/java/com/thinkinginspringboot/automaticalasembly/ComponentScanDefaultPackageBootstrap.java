package com.thinkinginspringboot.automaticalasembly;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.Stream;

/**
 * @author ajin
 */
@ComponentScan(basePackages = "")
public class ComponentScanDefaultPackageBootstrap {

    public static void main(String[] args) {
        // 注册当前引导类作为配置类，并且启动当前上下文
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(ComponentScanDefaultPackageBootstrap.class);
        // 输出当前Spring上下文应用中所有注册的Bean名称
        System.out.println("当前Spring上下文应用中所有注册的Bean名称 :");
        Stream.of(context.getBeanDefinitionNames())
                .map(name -> "\t" +name) // 增加格式缩进
                .forEach(System.out::println);
        // 关闭Spring上下文
        context.close();
    }
}
