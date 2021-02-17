package com.ajin.thinkinginspringboot.annotationdesign.enable.importselector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author ajin
 */
@Configuration
@EnableServer(type = Server.Type.HTTP) // 设置Http服务器
public class EnableServerBootstrap {

    public static void main(String[] args) {
        // 构建Annotation 配置驱动的Spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册当前引导类
        context.register(EnableServerBootstrap.class);
        // 启动上下文
        context.refresh();

        // 获取Server Bean 对象 ，此处应为HttpServer
        Server server= context.getBean(Server.class);
        // 启动服务器
        server.start();
        // 停止服务器
        server.stop();

        context.close();
    }
}
