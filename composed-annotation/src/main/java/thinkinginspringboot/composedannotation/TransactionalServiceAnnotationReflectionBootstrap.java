package thinkinginspringboot.composedannotation;

import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;
import thinkinginspringboot.composedannotation.annotation.TransactionalService;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 获取当前类上的{@link TransactionalService}注解的name属性值
 *
 * <p>代码使用Java反射API来实现，比较复杂繁琐，不建议使用</p>
 *
 * @author ajin
 */
@TransactionalService(name = "test") // name属性的值
@SuppressWarnings("all")
public class TransactionalServiceAnnotationReflectionBootstrap {

    public static void main(String[] args) throws Exception {

        //   方法1
        // Class 实现了AnnotatedElement接口
//        AnnotatedElement annotatedElement = TransactionalServiceAnnotationReflectionBootstrap.class;
//        // 从AnnotatedElement中获取 TransactionalService
//        TransactionalService transactionalService = annotatedElement.getAnnotation(TransactionalService.class);
//        // 显示调用TransactionalService的name属性
//        String nameAttributeValue = transactionalService.name();
//        // TransactionalService.name() = test
//        System.out.println("TransactionalService.name() = " + nameAttributeValue);

        //   方法2 将Java反射进行到底
        // Class 实现了AnnotatedElement接口
//        AnnotatedElement annotatedElement = TransactionalServiceAnnotationReflectionBootstrap.class;
//        TransactionalService transactionalService = annotatedElement.getAnnotation(TransactionalService.class);
//        // 完全Java反射实现(ReflectionUtils为Spring反射工具类）
//        ReflectionUtils.doWithMethods(TransactionalService.class,
//                method ->
//                        System.out.printf("@TransactionalService.%s() = %s\n",
//                                method.getName(), // 执行Method反射调用
//                                ReflectionUtils.invokeMethod(method, transactionalService)),
//                method -> method.getParameterCount() == 0   // 选择无参方法
//
//
//        );

        /**
         * 方法2 输出结果如下：
         * @TransactionalService.name() = test
         * @TransactionalService.toString() = @thinkinginspringboot.composedannotation.annotation.TransactionalService(name=test)
         * @TransactionalService.hashCode() = 431984231
         * @TransactionalService.annotationType() = interface thinkinginspringboot.composedannotation.annotation.TransactionalService
         *
         * */

        // 我们发现，其实所有的注解默认都实现了java.lang.annotation.Annotation接口 ，所以方法2暴力的打出了Annotation中所有无参方法

        // 方法3   把java.lang.annotation.Annotation接口的方法全部过滤掉
        // Class 实现了AnnotatedElement接口
//        AnnotatedElement annotatedElement = TransactionalServiceAnnotationReflectionBootstrap.class;
//        TransactionalService transactionalService = annotatedElement.getAnnotation(TransactionalService.class);
//        // 完全Java反射实现(ReflectionUtils为Spring反射工具类）
//        ReflectionUtils.doWithMethods(TransactionalService.class,
//                method ->
//                        // @TransactionalService.name() = test
//                        System.out.printf("@TransactionalService.%s() = %s\n",
//                                method.getName(), // 执行Method反射调用
//                                ReflectionUtils.invokeMethod(method, transactionalService)),
//                method -> !method.getDeclaringClass().equals(Annotation.class)  // 选择无参方法
//
//
//        );

        // 输出@TransactionalService中元标注的@Transactional注解的属性值
        AnnotatedElement annotatedElement = TransactionalServiceAnnotationReflectionBootstrap.class;
        // AnnotatedElement中获取TransactionalService
        TransactionalService transactionalService = annotatedElement.getAnnotation(TransactionalService.class);
        // 获取transactionalService中的所有元注解
        Set<Annotation> metaAnnotations = getAllMetaAnnotations(transactionalService);
        metaAnnotations.forEach(TransactionalServiceAnnotationReflectionBootstrap::printAnnotationAttribute);
        /**
         * @Service.value() =
         * @Transactional.value() =
         * @Transactional.readOnly() =false
         * @Transactional.timeout() =-1
         * @Transactional.propagation() =REQUIRED
         * @Transactional.isolation() =DEFAULT
         * @Transactional.rollbackFor() =[Ljava.lang.Class;@73c6c3b2
         * @Transactional.noRollbackFor() =[Ljava.lang.Class;@48533e64
         * @Transactional.transactionManager() =
         * @Transactional.noRollbackForClassName() =[Ljava.lang.String;@64a294a6
         * @Transactional.rollbackForClassName() =[Ljava.lang.String;@7e0b37bc
         * */

    }

    private static Set<Annotation> getAllMetaAnnotations(Annotation annotation) {
        Annotation[] metaAnnotations = annotation.annotationType().getAnnotations();

        if (ObjectUtils.isEmpty(metaAnnotations)) {
            return Collections.emptySet();
        }
        // 获取所有非Java标准源注解集合
        Set<Annotation> metaAnnotationSet = Stream.of(metaAnnotations)
                .filter(metaAnnotation ->
                        !Target.class.getPackage().equals(metaAnnotation.annotationType().getPackage())
                )
                .collect(Collectors.toSet());
        // 递归查找元注解的元注解集合
        Set<Annotation> metaMetaAnnotationsSet = metaAnnotationSet.stream()
                .map(TransactionalServiceAnnotationReflectionBootstrap::getAllMetaAnnotations)
                .collect(HashSet::new, Set::addAll, Set::addAll);

        // 添加递归结果
        return metaAnnotationSet;
    }

    private static void printAnnotationAttribute(Annotation annotation) {
        Class<?> annotationType = annotation.annotationType();
        ReflectionUtils.doWithMethods(annotationType,
                method -> System.out.printf("@%s.%s() =%s\n",
                        annotationType.getSimpleName(),
                        method.getName(), ReflectionUtils.invokeMethod(method, annotation)),
//                method -> method.getParameterCount() == 0); // 选择无参数方法
                // 选择非Annotation方法
                method -> !method.getDeclaringClass().equals(Annotation.class)
        );

    }

}
