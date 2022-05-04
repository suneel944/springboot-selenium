package com.auto.spring.springselenium.pages.amazon;

import org.openqa.selenium.By;
import com.auto.spring.springselenium.pages.BasePage;
import com.auto.spring.springselenium.framework.service.*;
import com.auto.spring.springselenium.framework.annotations.others.Page;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;
import com.auto.spring.springselenium.framework.annotations.screenshots.TakeScreenshot;
import com.auto.spring.springselenium.framework.annotations.windowswitching.IterativeForwardWindowSwitch;

@Page
public class AmazonProductPage extends BasePage
{
    @LazyAutowired
    private ElementTypeConverter elementTypeConverter;

    @LazyAutowired
    private Visibility visibility;

    @LazyAutowired
    private State state;

    @LazyAutowired
    private Scrollers scrollers;

    @LazyAutowired
    private ElementActions elementActions;

    private By txtProductFeatures = By.id("feature-bullets");

    public boolean scrollToProductTextContent()
    {
        return this.scrollers.scrollToElement(this.elementTypeConverter.returnWebElement(this.txtProductFeatures));
    }

    @TakeScreenshot
    public String getProductTextContent()
    {
        return this.elementActions.getTextFromElement(this.elementTypeConverter.returnWebElement(txtProductFeatures));
    }

    @Override
    @IterativeForwardWindowSwitch()
    public boolean isAt(String... args)
    {
        return this.wait.until((d) ->  this.state.isPageLoaded() && this.visibility.isElementDisplayed(this.elementTypeConverter.returnWebElement(txtProductFeatures)));
    }
}