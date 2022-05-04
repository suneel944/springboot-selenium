package com.auto.spring.springselenium.framework.aop.windowswitching;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import com.auto.spring.springselenium.framework.service.WindowSwitcher;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;
import com.auto.spring.springselenium.framework.annotations.windowswitching.IterativeBackwardWindowSwitch;

@Aspect
@Component
@Log4j2
public class BackwardWindowSwitchAspect
{
    @LazyAutowired
    private WindowSwitcher windowSwitcher;

    @Before("@annotation(iterativeBackwardWindowSwitch)")
    public void before(IterativeBackwardWindowSwitch iterativeBackwardWindowSwitch)
    {
        log.info("before : triggering backward window switch aop");
        this.windowSwitcher.switchToPrecedingWindow(iterativeBackwardWindowSwitch.value());
        log.info("before : triggered backward window switch aop");
    }
}
