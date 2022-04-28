package com.auto.spring.springselenium.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import com.auto.spring.springselenium.annotations.LazyConfiguration;

@LazyConfiguration
public class FakerConfig
{
    @Bean
    public Faker getFaker()
    {
        return new Faker();
    }
}
