package com.ajin.thinkinginspringboot.annotationdesign.enable.importselector;

import org.springframework.stereotype.Component;

/**
 * @author ajin
 */
@Component // 根据ImportSelector的契约，确保实现为Spring Bean
public class HttpServer implements Server {


    @Override
    public void start() {
        System.out.println("HTTP服务器启动中。。。");
    }

    @Override
    public void stop() {
        System.out.println("HTTP服务器关闭中。。。");
    }
}
