package com.auto.spring.springselenium.framework.aop.screenshots;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.auto.spring.springselenium.framework.service.Screenshots;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;
import com.auto.spring.springselenium.framework.annotations.screenshots.TakeScreenshot;

@Aspect
@Component
public class ScreenshotAspect
{
    @LazyAutowired
    private Screenshots screenshots;

    @After("@annotation(takeScreenshot)")
    public void after(JoinPoint jointPoint, TakeScreenshot takeScreenshot)
    {
        this.screenshots.takeScreenshot(jointPoint.getSignature().getName());
    }
}
