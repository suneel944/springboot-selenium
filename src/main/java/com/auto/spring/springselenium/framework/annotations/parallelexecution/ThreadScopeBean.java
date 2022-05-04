package com.auto.spring.springselenium.framework.annotations.parallelexecution;

import java.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Bean
@Scope("browserscope")
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ThreadScopeBean
{
}
