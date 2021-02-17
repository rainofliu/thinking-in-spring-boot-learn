package thinkinginspringboot.composedannotation;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thinkinginspringboot.composedannotation.annotation.TransactionalService;

import java.lang.reflect.AnnotatedElement;

/**
 * 理解Spring注解属性抽象{@link AnnotationAttributes}
 * 注： {@link TransactionalService}  ==  {@link Service}+{@link Transactional}
 * @author ajin
 */
@TransactionalService
public class AnnotationAttributesBootstrap {

    public static void main(String[] args) {
        AnnotatedElement annotatedElement  = TransactionalService.class;

        // 获取Service注解属性独享
        AnnotationAttributes serviceAttributes = AnnotatedElementUtils.getMergedAnnotationAttributes(
                annotatedElement,Service.class);

        // 获取Transactional 注解属性独享
        AnnotationAttributes transactionalAttributes = AnnotatedElementUtils.getMergedAnnotationAttributes(
                annotatedElement,Transactional.class);

        // 输出
        print(serviceAttributes);
        print(transactionalAttributes);
        /**
         * 注解 @org.springframework.stereotype.Service 属性集合 :
         * 	 属性 value :
         * 注解 @org.springframework.transaction.annotation.Transactional 属性集合 :
         * 	 属性 value :
         * 	 属性 readOnly : false
         * 	 属性 timeout : -1
         * 	 属性 transactionManager :
         * 	 属性 rollbackForClassName : [Ljava.lang.String;@2b05039f
         * 	 属性 rollbackFor : [Ljava.lang.Class;@61e717c2
         * 	 属性 noRollbackFor : [Ljava.lang.Class;@66cd51c3
         * 	 属性 propagation : REQUIRED
         * 	 属性 isolation : DEFAULT
         * 	 属性 noRollbackForClassName : [Ljava.lang.String;@4dcbadb4
         *
         * */
    }

    public static void print(AnnotationAttributes annotationAttributes){
        System.out.printf("注解 @%s 属性集合 : \n",annotationAttributes.annotationType().getName());
        annotationAttributes.forEach((name,value)->{
            System.out.printf("\t 属性 %s : %s \n",name,value);
        });
    }
}
