package com.thinking.in.spring.boot.springapplicationdemo.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * {@link ApplicationListener} 监听Spring内建事件
 *
 * @author ajin
 */

public class ApplicationListenerOnSpringEventsBootstrap {

    public static void main(String[] args) {
        // 创建ConfigurableApplicationContext上下文
        ConfigurableApplicationContext context = new GenericApplicationContext();
        System.out.println("创建Spring应用上下文：" + context.getDisplayName());

        // 添加ApplicationListener 非泛型实现
        context.addApplicationListener(event ->
                System.out.println("触发事件:" + event.getClass().getSimpleName())
        );
        // refresh 初始化Spring应用上下文
        System.out.println("应用上下文初始化");
        context.refresh();
        System.out.println("应用上下文已初始化");

        // stop 停止应用上下文
        System.out.println("应用上下文停止启动");
        context.stop();
        System.out.println("应用上下文已停止启动");


        // start 启动应用上下文
        System.out.println("应用上下文准备启动");
        context.start();
        System.out.println("应用上下文已启动");

        // close 关闭应用上下文
        System.out.println("应用上下文准备关闭");
        context.close();
        System.out.println("应用上下文已关闭");


    }
}
