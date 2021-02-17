package com.ajin.thinkinginspringboot.annotationdesign.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ajin
 */

public class ConditionalOnSystemPropertyBootstrap {

    public static void main(String[] args) {
        // 设置 System Property
        System.setProperty("language","Chinese");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConditinalMessageConfiguration.class);
        context.refresh();
        String message = context.getBean("message",String.class);
        // 输出message
        System.out.println(message);
    }
}
