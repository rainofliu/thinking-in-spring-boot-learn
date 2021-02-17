package com.ajin.thinkinginspringboot.annotationdesign.enable.importselector;

import org.springframework.stereotype.Component;

/**
 * @author ajin
 */
@Component
public class FtpServer implements Server {

    @Override
    public void start() {
        System.out.println("FTP服务器启动中。。。");
    }

    @Override
    public void stop() {
        System.out.println("FTP服务器关闭中。。。");
    }
}
