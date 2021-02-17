package com.ajin.thinkinginspringboot.annotationdesign.webauto.custom;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author ajin
 */
@SuppressWarnings("all")
public class SpringWebMvcServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebMvcConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }
    /**
    *  返回当前泛型的 数组
    * */
//    public static <T> T[] of(T...values){
//        return values;
//    }
}
