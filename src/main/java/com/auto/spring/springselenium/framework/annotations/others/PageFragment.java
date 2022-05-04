package com.auto.spring.springselenium.framework.annotations.others;

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
@Target({ElementType.TYPE})
public @interface PageFragment
{
}
