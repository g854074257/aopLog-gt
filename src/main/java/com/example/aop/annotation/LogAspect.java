package com.example.aop.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAspect {
    /**
     * 方法描述
     */
    String description() default "";
    
    /**
     * 键值
     */
    String key() default "";
    
    /**
     * 名称
     */
    String name() default "";
} 