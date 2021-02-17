package com.ajin.thinkinginspringboot.annotationdesign.enable.importselector;

/**
 * 服务器接口
 * @author ajin
 */
public interface Server {
    /**
     * 启动服务器
     * */
    void start();
    /**
     * 关闭服务器
     * */
    void stop();

    /**
     * 服务器类型
     * */
    enum  Type{
        HTTP, // HTTP服务器
        FTP  // FTP 服务器
    }
}
