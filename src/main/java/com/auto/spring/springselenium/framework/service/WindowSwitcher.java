package com.auto.spring.springselenium.framework.service;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import com.auto.spring.springselenium.framework.annotations.LazyService;

@LazyService
@Log4j2
public class WindowSwitcher
{
    @Autowired
    private WebDriver driver;

    public boolean switchWindowByTitle(final String title)
    {
        try
        {
            log.info("switching window by {} title", title);
            driver.getWindowHandles().stream()
                    .map(handle -> driver.switchTo().window(handle)
                            .getTitle()).filter(t -> t.startsWith(title))
                    .findFirst().orElseThrow(() -> {throw new RuntimeException("no such window");});
            log.info("switched to window having {} title", title);
            return true;
        } catch (Exception e)
        {
            log.error("failed to switch window by {} title : {}", title, e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }

    public boolean switchWindowByIndex(final Integer index)
    {
        try
        {
            log.info("switching window by {} index", index);
            String [] handles = driver.getWindowHandles().toArray(new String[0]);
            driver.switchTo().window(handles[index]);
            log.info("switched to window with index {}", index);
            return true;
        } catch (Exception e)
        {
            log.error("failed to switch window by {} index : {}",index, e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }
}
