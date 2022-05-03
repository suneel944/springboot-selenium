package com.auto.spring.springselenium.framework.service;

import java.io.File;
import java.nio.file.Path;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.util.FileCopyUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import com.auto.spring.springselenium.framework.annotations.LazyService;
import com.auto.spring.springselenium.framework.annotations.LazyAutowired;

@LazyService
@Log4j2
public class Screenshots
{
    @LazyAutowired
    private ApplicationContext ctxt;

    @Lazy
    @Autowired
    private Faker faker;

    @Value("${screenshot.path}")
    private Path path;

    public boolean takeScreenshot(String testName)
    {
        try
        {
            log.info("taking screenshot");
            File sourceFile = this.ctxt.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
            FileCopyUtils.copy(sourceFile, this.path.resolve((testName+faker.date().toString()+faker.numerify("0123456789"))+ ".png").toFile());
            log.info("took screenshot");
            return true;
        } catch (Exception e)
        {
            log.error("failed to take screenshot {}", e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }

    public byte[] getScreenshot()
    {
        return this.ctxt.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }

}
