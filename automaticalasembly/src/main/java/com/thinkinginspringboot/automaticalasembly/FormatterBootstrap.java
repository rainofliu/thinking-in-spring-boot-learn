package com.thinkinginspringboot.automaticalasembly;

import com.ajin.formatter.Formatter;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ajin
 */
@EnableAutoConfiguration
public class FormatterBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(FormatterBootstrap.class)
                .web(WebApplicationType.NONE) // 非Web应用
//                .properties("formatter.enabled=true")
                .run(args); // 运行
        // 待格式化对象
        Map<String, Object> data = new HashMap<>(4);
        data.put("name", "ajin");
        // 获取Formatter
       // Formatter formatter = context.getBean(Formatter.class);
       // System.out.printf("formatter.format(data):%s\n", formatter.format(data));
        Map<String,Formatter> beans=context.getBeansOfType(Formatter.class);
        if (beans.isEmpty()){
            throw new NoSuchBeanDefinitionException(Formatter.class);
        }
        beans.forEach((beanName,formatter)->{
            System.out.printf("[Bean name : %s] %s.format(data): %s\n",
                    beanName,formatter.getClass().getSimpleName(),
                    formatter.format(data));
        });
        // 关闭上下文
        context.close();
    }
}
