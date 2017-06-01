package com.zach.annotation.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 添加的自定义的注解
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SelfAnnotation {
    String name();
} 