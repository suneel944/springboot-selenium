package com.auto.spring.springselenium.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.FileCopyUtils;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.nio.file.Path;

@Component
public class Screenshots
{
    @Lazy
    @Autowired
    private TakesScreenshot driver;

    @Value("${screenshot.path}")
    private Path path;

    public boolean takeScreenShot(final String imageName)
    {
        try
        {
            File sourceFile = this.driver.getScreenshotAs(OutputType.FILE);
            FileCopyUtils.copy(sourceFile, this.path.resolve(imageName).toFile());
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

}
