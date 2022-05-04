package com.auto.spring.springselenium.framework.annotations.screenshots;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TakeScreenshot
{
}
