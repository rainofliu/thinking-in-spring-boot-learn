package thinkinginspringboot.firstappbygui.annotation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * 一个组合注解 {@link Transactional} AND {@link Service}
 * @author ajin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Transactional  // Spring的功能性注解
@Service // Spring的模式注解
public @interface TransactionalService {

}
