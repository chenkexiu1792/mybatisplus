package com.itheima.common.process.exception;

import java.lang.annotation.*;

/**
 * @Author Administrator
 * @Version 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})  //可以在字段、方法
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseNotIntercept {
    String value() default "";
}