package com.auto.spring.springselenium.framework.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;

@Configuration
public class BrowserScopeConfig
{
    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor()
    {
        return new BrowserScopePostProcessor();
    }
}
