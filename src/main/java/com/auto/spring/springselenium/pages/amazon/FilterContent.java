package com.auto.spring.springselenium.pages.amazon;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import com.auto.spring.springselenium.pages.Base;
import com.auto.spring.springselenium.utility.Scrollers;
import com.auto.spring.springselenium.utility.Visibility;
import org.springframework.beans.factory.annotation.Value;
import com.auto.spring.springselenium.utility.ElementActions;
import com.auto.spring.springselenium.utility.ElementTypeConverter;

@Component
public class FilterContent extends Base
{
    @Value("${filterCategoryHeading}")
    private String filterCategoryHeading;

    @Value("${filterCategoryContentName}")
    private String filterCategoryContentName;

    private final By txtFilterContent = By.xpath(".//*[@id='s-refinements']//*[text()='"+filterCategoryHeading+"']");
    private final By chkBoxFilterContentUnderCategory = By.xpath(".//*[@id='s-refinements']//*[text()='"+filterCategoryHeading+"']/..//following-sibling::ul//*[text()='"+filterCategoryContentName+"']");

    public boolean clickOnFilterContentUnderCategory()
    {
        boolean flag = false;
        try
        {
            Scrollers.scrollToElement(driver, ElementTypeConverter.returnWebElement(driver, txtFilterContent));
            if (Visibility.isElementDisplayed(ElementTypeConverter.returnWebElement(driver, txtFilterContent)))
                if(ElementActions.clickOnElement(ElementTypeConverter.returnWebElement(driver, chkBoxFilterContentUnderCategory)))
                    flag = true;
            return flag;
        } catch (Exception e)
        {
            return flag;
        }
    }

    @Override
    public boolean isAt()
    {
        return this.wait.until((d -> Visibility.isElementDisplayed(ElementTypeConverter.returnWebElement(driver, this.txtFilterContent))));
    }
}
