package com.auto.spring.springselenium.pages.amazon;

import com.auto.spring.springselenium.framework.service.*;
import org.openqa.selenium.By;
import com.auto.spring.springselenium.pages.Base;
import com.auto.spring.springselenium.framework.annotations.PageFragment;
import com.auto.spring.springselenium.framework.annotations.LazyAutowired;

@PageFragment
public class FilterContent extends Base
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
