package com.auto.spring.springselenium.framework.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.auto.spring.springselenium.framework.service.Screenshots;
import com.auto.spring.springselenium.framework.annotations.TakeScreenshot;

@Aspect
@Component
@Log4j2
public class ScreenshotAspect
{
    @Autowired
    private Screenshots screenshots;

    @After("@annotation(takeScreenshot)")
    public void after(JoinPoint jointPoint, TakeScreenshot takeScreenshot)
    {
        log.info("taking screenshot");
        this.screenshots.takeScreenshot(jointPoint.getSignature().getName());
        log.info("took screenshot");
    }
}
