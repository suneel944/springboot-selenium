package com.auto.spring.springselenium.framework.service;

import java.util.logging.Level;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LoggingPreferences;
import com.auto.spring.springselenium.framework.annotations.LazyService;

@LazyService
public class BrowserOptions
{
    public FirefoxOptions getFirefoxOptions()
    {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("devtools.console.stdout.content", true);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        loggingPreferences.enable(LogType.DRIVER, Level.ALL);
        firefoxOptions.setProfile(firefoxProfile).setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
        return firefoxOptions;
    }
    public ChromeOptions getChromeOptions()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
        return chromeOptions;
    }
}