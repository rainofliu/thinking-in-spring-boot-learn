package thinkinginspringboot.composedannotation;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.util.CollectionUtils;
import thinkinginspringboot.composedannotation.annotation.TransactionalService;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 主要是基于 {@link AnnotationMetadata#getAllAnnotationAttributes(String)} API实现对注解 元标注信息的读取
 *
 * @author ajin
 */
@TransactionalService
public class TransactionalServiceStandardAnnotationMetadataBootstrap {

    public static void main(String[] args) {
        // 读取@TransactionalService  AnnotationMetadata
        AnnotationMetadata annotationMetadata = new StandardAnnotationMetadata(
                TransactionalServiceStandardAnnotationMetadataBootstrap.class);
        // 获取所有的元注解类型
        Set<String> metaAnnotationTypes = annotationMetadata.getAnnotationTypes()
                .stream()
                // 读取单注解的元注解类型
                .map(annotationMetadata::getMetaAnnotationTypes)
                // 合并元注解类型
                .collect(LinkedHashSet::new, Set::addAll, Set::addAll);
        // FIXME
       /* metaAnnotationTypes.forEach(metaAnnotationType > { // 读取所有元注解类型
                // 读取元注解属性信息
                Map < String, Object > annotationAttributes = annotationMetadata.getAnnotationAttributes(metaAnnotationType);
        if (!CollectionUtils.isEmpty(annotationAttributes)) {

        }*/


//        });
    }

}
