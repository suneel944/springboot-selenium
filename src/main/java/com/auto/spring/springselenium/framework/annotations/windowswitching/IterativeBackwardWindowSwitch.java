package com.auto.spring.springselenium.framework.annotations.windowswitching;

import java.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;


@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface IterativeBackwardWindowSwitch
{
    int value() default 1;
}
