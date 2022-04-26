package com.auto.spring.springselenium.pages.amazon;

import org.openqa.selenium.By;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.auto.spring.springselenium.pages.Base;
import com.auto.spring.springselenium.utility.Scrollers;
import com.auto.spring.springselenium.utility.Visibility;
import org.springframework.beans.factory.annotation.Value;
import com.auto.spring.springselenium.utility.ElementActions;
import org.springframework.beans.factory.annotation.Autowired;
import com.auto.spring.springselenium.utility.ElementTypeConverter;

@Component
public class FilterContent extends Base
{
    @Value("${filters.categoryHeading}")
    private String filterCategoryHeading;

    @Value("${filters.categoryContentName}")
    private String filterCategoryContentName;

    @Lazy
    @Autowired
    private Scrollers scrollers;

    @Lazy
    @Autowired
    private ElementTypeConverter elementTypeConverter;

    @Lazy
    @Autowired
    private Visibility visibility;

    @Lazy
    @Autowired
    private ElementActions elementActions;

    private By txtFilterContent()
    {
        return By.xpath(".//*[@id='s-refinements']//*[text()='" + this.filterCategoryHeading + "']");
    }

    private By chkBoxFilterContentUnderCategory()
    {
        return By.xpath(".//*[@id='s-refinements']//*[text()='"+this.filterCategoryHeading+"']/..//following-sibling::ul//*[text()='"+this.filterCategoryContentName+"']");
    }

    public boolean clickOnFilterContentUnderCategory()
    {
        boolean flag = false;
        try
        {
            this.scrollers.scrollToElement(this.elementTypeConverter.returnWebElement(this.txtFilterContent()));
            if (this.visibility.isElementDisplayed(this.elementTypeConverter.returnWebElement(this.txtFilterContent())))
                if(this.elementActions.clickOnElement(this.elementTypeConverter.returnWebElement(this.chkBoxFilterContentUnderCategory())))
                    flag = true;
            return flag;
        } catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean isAt()
    {
        return this.wait.until((d -> this.visibility.isElementDisplayed(this.elementTypeConverter.returnWebElement(this.txtFilterContent()))));
    }
}
