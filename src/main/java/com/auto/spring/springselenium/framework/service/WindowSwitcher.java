package com.auto.spring.springselenium.framework.service;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import com.auto.spring.springselenium.framework.annotations.others.LazyService;

import java.util.ArrayList;

@LazyService
@Log4j2
public class WindowSwitcher
{
    @Autowired
    private WebDriver driver;

    public boolean switchToPrecedingWindow(Integer iterations)
    {

        try
        {
            String handlePointer = "";
            for (int i=iterations; i<0; i--)
            {
                log.info("switching to preceding window");
                ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
                String handle = driver.getWindowHandle();
                int windowHandlesSize = windowHandles.size();
                for (int k = 0; k < windowHandlesSize; k++)
                {
                    handlePointer = windowHandles.get(k);
                    if (handlePointer.equals(handle))
                    {
                        //If the first window is selected and to loop around the window, below condition suffice
                        if (k == 0)
                        {
                            handlePointer = windowHandles.get(windowHandlesSize - 1);
                            break;
                        }
                        //Decrement handler pointer index and grab that handler data from array list
                        handlePointer = windowHandles.get(k - 1);
                        break;
                    }
                }
                /*Switch to previous (or preceding) tab*/
                driver.switchTo().window(handlePointer);
                log.info("switched to preceding window");
            }
            return true;
        } catch (Exception e)
        {
            log.error("failed to switch to preceding window {}", e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }

    public boolean switchToSucceedingWindow(Integer iterations)
    {
        try
        {
            for (int i=0; i<iterations; i++)
            {
                String handlePointer = "";
                log.info("switching to succeeding window");
                ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
                String handle = driver.getWindowHandle();
                int windowHandlesSize = windowHandles.size();
                for (int k = 0; k < windowHandlesSize; k++)
                {
                    handlePointer = windowHandles.get(k);
                    if (handlePointer.equals(handle))
                    {
                        //If the last window is selected and to loop around the window, below condition suffice
                        if (k == (windowHandlesSize - 1))
                        {
                            handlePointer = windowHandles.get(0);
                            break;
                        }
                        //Increment handler pointer index and grab that handler data from array list
                        handlePointer = windowHandles.get(k + 1);
                        break;
                    }
                }
                //Switch to previous (or preceding) tab
                driver.switchTo().window(handlePointer);
                log.info("switched to succeeding window");
            }
            return true;
        }
        catch (Exception e)
        {
            log.error("failed to switch to succeeding window {}", e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }

    public boolean switchWindowByTitle(final String title)
    {
        try
        {
            if (!driver.getTitle().equals(title))
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
