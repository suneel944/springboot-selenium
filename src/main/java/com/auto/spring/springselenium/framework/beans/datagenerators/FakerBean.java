package com.auto.spring.springselenium.framework.beans.datagenerators;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import com.auto.spring.springselenium.framework.annotations.others.LazyConfiguration;

@LazyConfiguration
public class FakerBean
{
    @Bean
    public Faker getFaker()
    {
        return new Faker();
    }
}
