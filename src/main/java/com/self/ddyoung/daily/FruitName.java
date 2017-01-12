package com.self.ddyoung.daily;

import java.lang.annotation.*;

/**
 * 水果名称注解
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 16/12/22 下午6:02
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {

    String value() default "";
}
