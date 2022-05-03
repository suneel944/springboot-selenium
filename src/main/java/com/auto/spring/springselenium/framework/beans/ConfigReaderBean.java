package com.auto.spring.springselenium.framework.beans;

import com.auto.spring.springselenium.framework.Readers.ConfigReader;
import com.auto.spring.springselenium.framework.annotations.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class ConfigReaderBean
{
    @Bean
    public ConfigReader getConfigReader()
    {
        return new ConfigReader();
    }
}
