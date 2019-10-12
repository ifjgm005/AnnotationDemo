package com.demo.annotation;

import java.lang.annotation.*;












@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Message {
    String decr() default "类名";

    String author();

    int age();

}
