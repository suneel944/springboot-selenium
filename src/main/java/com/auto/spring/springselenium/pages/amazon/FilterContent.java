package com.auto.spring.springselenium.pages.amazon;

import org.openqa.selenium.By;
import com.auto.spring.springselenium.pages.BasePage;
import com.auto.spring.springselenium.framework.service.*;
import com.auto.spring.springselenium.framework.annotations.others.PageFragment;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;

@PageFragment
public class FilterContent extends BasePage
{
    @LazyAutowired
    private Scrollers scrollers;

    @LazyAutowired
    private ElementTypeConverter elementTypeConverter;

    @LazyAutowired
    private Visibility visibility;

    @LazyAutowired
    private State state;

    @LazyAutowired
    private ElementActions elementActions;

    private By txtFilterContent(String filterCategoryHeading)
    {
        return By.xpath(".//*[@id='s-refinements']//*[text()='" + filterCategoryHeading + "']");
    }

    private By chkBoxFilterContentUnderCategory(String filterCategoryHeading, String filterCategoryContentName)
    {
        return By.xpath(".//*[@id='s-refinements']//*[text()='"+ filterCategoryHeading+"']/..//following-sibling::ul//*[text()='"+filterCategoryContentName+"']");
    }

    public boolean clickOnFilterContentUnderCategory(String filterCategoryHeading, String filterCategoryContentName)
    {
        boolean flag = false;
        try
        {
            this.scrollers.scrollToElement(this.elementTypeConverter.returnWebElement(this.txtFilterContent(filterCategoryHeading)));
            if (this.visibility.isElementDisplayed(this.elementTypeConverter.returnWebElement(this.txtFilterContent(filterCategoryHeading))))
                if(this.elementActions.clickOnElement(this.elementTypeConverter.returnWebElement(this.chkBoxFilterContentUnderCategory(filterCategoryHeading, filterCategoryContentName))))
                    flag = true;
            return flag;
        } catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean isAt(String... args)
    {
        return this.wait.until(d -> this.state.isPageLoaded());
    }
}
