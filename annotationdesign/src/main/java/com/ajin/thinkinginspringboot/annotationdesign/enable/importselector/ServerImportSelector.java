package com.ajin.thinkinginspringboot.annotationdesign.enable.importselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author ajin
 * @see EnableServer
 */
public class ServerImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 读取EnableServer中的所有属性方法，本实例中只有type()属性方法
        // key : 属性方法的名称 value : 属性方法的返回对象
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableServer.class.getName());
        // 获取名为type 的属性方法 ，并且强制转化为 Server.Type类型
        Server.Type type = (Server.Type) annotationAttributes.get("type");
        // 导入的类名称数组
        String[] importClassNames = new String[0];
        switch (type) {
            case FTP:
                importClassNames = new String[]{FtpServer.class.getName()};
                break;
            case HTTP:
                importClassNames = new String[]{HttpServer.class.getName()};
                break;
        }
        return importClassNames;
    }
}
