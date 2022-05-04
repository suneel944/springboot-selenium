package com.auto.spring.springselenium.framework.annotations.others;

import java.lang.annotation.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Configuration;

@Lazy
@Configuration
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface LazyConfiguration
{
}
