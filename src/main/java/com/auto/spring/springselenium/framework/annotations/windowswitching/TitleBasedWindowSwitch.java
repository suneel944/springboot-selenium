package com.auto.spring.springselenium.framework.annotations.windowswitching;

import java.lang.annotation.*;
import com.auto.spring.springselenium.framework.annotations.others.Page;

@Page
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface TitleBasedWindowSwitch
{
    String value() default "sprint-selenium-random-text";
}
