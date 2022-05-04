package com.auto.spring.springselenium.framework.beans.propertiesreader;

import org.springframework.context.annotation.Bean;
import com.auto.spring.springselenium.framework.readers.ConfigReader;
import com.auto.spring.springselenium.framework.annotations.others.LazyConfiguration;

@LazyConfiguration
public class ConfigReaderBean
{
    @Bean
    public ConfigReader getConfigReader()
    {
        return new ConfigReader();
    }
}
