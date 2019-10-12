package com.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by axes on 2019/10/12.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Table {
    String value();
}
