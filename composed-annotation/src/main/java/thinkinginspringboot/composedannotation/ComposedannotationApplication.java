package thinkinginspringboot.composedannotation;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import thinkinginspringboot.composedannotation.annotation.TransactionalService;

import java.util.Set;

/**
 * 引导类 ，主要用来探索Spring Boot 注解原理
 * @author ajin
 */
@TransactionalService(name = "test") // name属性的值
//@EnableTransactionManagement
//@SpringBootApplication
@SuppressWarnings("all")
public class ComposedannotationApplication {

    public static void main(String[] args) throws Exception {
        String className = ComposedannotationApplication.class.getName();
        // 构建MetadataReaderFactory 实例
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
        // 读取@TransactionalService MetadataReader 信息
        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(className);
        // 读取@TransactionalService  AnnotationMetadata 信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        annotationMetadata.getAnnotationTypes().forEach(annotationType -> { // 遍历当前类所有的注解的全类名 thinkinginspringboot.composedannotation.annotation.TransactionalService
            Set<String> metaAnnotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationType); // 获取某一个注解的元注解列表
            metaAnnotationTypes.forEach(metaAnnotationType -> { // 遍历当前注解的元注解列表（全类名）
                System.out.printf("注解 @ %s 元标注 @%s \n", annotationType, metaAnnotationType);
            });
            /*
             * 注解 @ thinkinginspringboot.composedannotation.annotation.TransactionalService 元标注 @org.springframework.transaction.annotation.Transactional
             * 注解 @ thinkinginspringboot.composedannotation.annotation.TransactionalService 元标注 @org.springframework.stereotype.Service
             * 注解 @ thinkinginspringboot.composedannotation.annotation.TransactionalService 元标注 @org.springframework.stereotype.Component
             * 注解 @ thinkinginspringboot.composedannotation.annotation.TransactionalService 元标注 @org.springframework.stereotype.Indexed
             * */

        });

    }

}
