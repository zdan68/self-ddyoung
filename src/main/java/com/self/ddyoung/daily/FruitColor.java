package com.self.ddyoung.daily;

import java.lang.annotation.*;

/**
 * 水果颜色注解
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 16/12/22 下午6:07
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    /**
     * 颜色枚举
     */
    enum Color{Red, Orainge, Yellow, Green, Blue, Purple}

    Color colorValue() default Color.Blue;
}
