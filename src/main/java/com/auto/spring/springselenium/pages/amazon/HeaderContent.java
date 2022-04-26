package com.auto.spring.springselenium.pages.amazon;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import com.auto.spring.springselenium.pages.Base;
import com.auto.spring.springselenium.utility.State;
import com.auto.spring.springselenium.utility.ElementTypeConverter;

@Component
public class HeaderContent extends Base
{
    private final By edtSearchField = By.xpath(".//*[@id='twotabsearchtextbox']");

    private final By btnSearchSubmit = By.xpath(".//*[@id='nav-search-submit-button']");

    private final By lnkAllNavigation = By.xpath(".//*[@id='nav-hamburger-menu']");

    private By txtAllNavigationMenuHeadings(String headingName)
    {
        return By.xpath(".//*[@id='hmenu-content']//*[@class='hmenu hmenu-visible']//*[@class='hmenu-item hmenu-title '][text()='"+headingName+"']");
    }

    private By lnkAllNavigationSubMenu(String subMenuName)
    {
        return By.xpath(".//*[@id='hmenu-content']//*[@class='hmenu hmenu-visible']//*[@class='hmenu-item']//*[text()='"+subMenuName+"']");
    }

    private By lnkAllNavigationRightExtensionSubMenu(String subMenuName)
    {
        return By.xpath(".//*[@class='hmenu hmenu-visible hmenu-translateX']//*[@class='hmenu-item'][text()='"+subMenuName+"']");
    }

    @Override
    public boolean isAt()
    {
        return this.wait.until(d -> State.isElementEnabled(ElementTypeConverter.returnWebElement(driver, this.edtSearchField)));
    }
}
