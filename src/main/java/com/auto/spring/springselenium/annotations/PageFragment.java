package com.auto.spring.springselenium.annotations;

import java.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Lazy
@Scope("prototype")
@Component
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface PageFragment
{
}
