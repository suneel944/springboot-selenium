package com.auto.spring.springselenium.framework.annotations;

import org.springframework.context.annotation.Lazy;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

@Lazy
@Autowired
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface LazyAutowired
{
}
