package com.auto.spring.springselenium.framework.service;

import java.util.Map;
import java.util.Hashtable;
import java.util.logging.Level;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.logging.LoggingPreferences;
import com.auto.spring.springselenium.framework.readers.ConfigReader;
import com.auto.spring.springselenium.framework.annotations.others.LazyService;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;

import javax.annotation.PostConstruct;

@LazyService
@Log4j2
public class BrowserOptions
{
    @LazyAutowired
    private ConfigReader configReader;

    public FirefoxOptions getFirefoxOptions()
    {
        log.info("adding firefox options");
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("devtools.console.stdout.content", true);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        loggingPreferences.enable(LogType.DRIVER, Level.ALL);
        firefoxOptions.setProfile(firefoxProfile).setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
        log.info("added firefox options");
        return firefoxOptions;
    }
    public ChromeOptions getChromeOptions()
    {
        log.info("adding chrome options");
        ChromeOptions chromeOptions = new ChromeOptions();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
        chromeOptions.addArguments(configReader.getBrowserRunMode().toLowerCase());
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--enable-javascript");
        chromeOptions.setAcceptInsecureCerts(configReader.getAcceptInsecureCertificates().equalsIgnoreCase("true")?true:false);
        Map<String, Object> prefs = new Hashtable<String, Object>();
        prefs.put("plugins.always_open_pdf_externally", true);
        prefs.put("download.default_directory", String.format("%s\\%s", System.getProperty("user.dir"), configReader.getSeleniumDownloadDirectory()));
        prefs.put("profile.default_content_settings.cookies", 2);
        chromeOptions.setExperimentalOption("prefs", prefs);
        log.info("added chrome options");
        return chromeOptions;
    }
}