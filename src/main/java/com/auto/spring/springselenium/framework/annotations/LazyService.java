package com.auto.spring.springselenium.framework.annotations;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Lazy
@Service
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface LazyService
{
}
