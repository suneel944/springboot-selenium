package com.auto.spring.springselenium.framework.service;

import com.github.javafaker.Faker;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import com.auto.spring.springselenium.framework.annotations.LazyAutowired;

import java.io.File;
import java.nio.file.Path;

@Service
public class Screenshots
{
    @LazyAutowired
    private ApplicationContext ctxt;

    @Lazy
    @Autowired
    private Faker faker;

    @Value("${screenshot.path}")
    private Path path;

    public boolean takeScreenShot()
    {
        try
        {
            File sourceFile = this.ctxt.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
            FileCopyUtils.copy(sourceFile, this.path.resolve(faker.date().toString()+faker.numerify("0123456789")).toFile());
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

}
