package com.auto.spring.springselenium.framework.aop;

import com.auto.spring.springselenium.framework.annotations.TakeScreenshot;
import com.auto.spring.springselenium.framework.service.Screenshots;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ScreenshotAspect
{
    @Autowired
    private Screenshots screenshots;

    @After("@target(takeScreenshot) && within(com.auto.spring.springselenium..*)")
    public void after(TakeScreenshot takeScreenshot)
    {
        this.screenshots.takeScreenshot();
    }
}
