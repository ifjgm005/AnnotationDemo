package com.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by tuoanlan on 2019/9/27.
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface  AnnotationTest {
    String value() default "";
}
