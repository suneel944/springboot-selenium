package com.auto.spring.springselenium;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;

@SpringBootTest
@Getter
public class SpringSeleniumBaseTestNGTest extends AbstractTestNGSpringContextTests
{
    @LazyAutowired
    private ApplicationContext applicationContext;

    @AfterSuite
    public void teardown()
    {
        this.applicationContext.getBean(WebDriver.class).quit();
    }

}
