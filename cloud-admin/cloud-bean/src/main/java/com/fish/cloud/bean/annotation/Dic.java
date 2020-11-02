package com.fish.cloud.bean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字典及待显示文字注解
 * @author quanyu
 * @date 2020/10/21
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dic {
    /**
     * 比较的字段
     * @return
     */
    String dicCode();

    /**
     * 显示的字段
     * @return
     */
    String dicText() default "";

    /**
     * 要查询的表
     * @return
     */
    String dicTable() default "";
}
