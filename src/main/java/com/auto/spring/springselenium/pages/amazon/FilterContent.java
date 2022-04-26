package com.auto.spring.springselenium.pages.amazon;

import org.openqa.selenium.By;
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
    @Autowired
    private Scrollers scrollers;

    @Autowired
    private ElementTypeConverter elementTypeConverter;

    @Autowired
    private Visibility visibility;

    @Autowired
    private ElementActions elementActions;

    @Value("${filters.categoryHeading}")
    private String filterCategoryHeading;

    @Value("${filters.categoryContentName}")
    private String filterCategoryContentName;

    private final By txtFilterContent = By.xpath(".//*[@id='s-refinements']//*[text()='"+filterCategoryHeading+"']");
    private final By chkBoxFilterContentUnderCategory = By.xpath(".//*[@id='s-refinements']//*[text()='"+filterCategoryHeading+"']/..//following-sibling::ul//*[text()='"+filterCategoryContentName+"']");

    public boolean clickOnFilterContentUnderCategory()
    {
        boolean flag = false;
        try
        {
            this.scrollers.scrollToElement(this.elementTypeConverter.returnWebElement(txtFilterContent));
            if (this.visibility.isElementDisplayed(this.elementTypeConverter.returnWebElement(txtFilterContent)))
                if(this.elementActions.clickOnElement(this.elementTypeConverter.returnWebElement(chkBoxFilterContentUnderCategory)))
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
        return this.wait.until((d -> this.visibility.isElementDisplayed(this.elementTypeConverter.returnWebElement(this.txtFilterContent))));
    }
}
