package com.auto.spring.springselenium.framework.annotations.others;

import java.lang.annotation.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.beans.factory.annotation.Autowired;

@Lazy
@Autowired
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface LazyAutowired
{
}
