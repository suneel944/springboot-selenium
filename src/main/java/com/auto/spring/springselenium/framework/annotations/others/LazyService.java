package com.auto.spring.springselenium.framework.annotations.others;

import java.lang.annotation.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface LazyService
{
}
