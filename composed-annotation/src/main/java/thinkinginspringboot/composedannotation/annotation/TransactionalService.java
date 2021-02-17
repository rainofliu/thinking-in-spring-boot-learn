package thinkinginspringboot.composedannotation.annotation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * 一个组合注解 {@link Transactional} AND {@link Service}
 *
 * @author ajin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Transactional
@Service
public @interface TransactionalService {
    /**
     * @return 服务Bean的名称
     * */
    String name() default "";
}
