package com.auto.spring.springselenium.pages.amazon;

import org.openqa.selenium.By;
import com.auto.spring.springselenium.pages.Base;
import org.springframework.context.annotation.Lazy;
import com.auto.spring.springselenium.framework.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.auto.spring.springselenium.framework.annotations.PageFragment;

@PageFragment
public class HeaderContent extends Base
{
    @Lazy
    @Autowired
    private Visibility visibility;

    @Lazy
    @Autowired
    private ElementActions elementActions;

    @Lazy
    @Autowired
    private Scrollers scrollers;

    @Lazy
    @Autowired
    private ElementTypeConverter elementTypeConverter;

    private By edtSearchField = By.xpath(".//*[@id='twotabsearchtextbox']");

    private By btnSearchSubmit = By.xpath(".//*[@id='nav-search-submit-button']");

    private By lnkAllNavigation = By.xpath(".//*[@id='nav-hamburger-menu']");

    private By txtAllNavigationMenuHeadings(String headingName)
    {
        return By.xpath(".//*[@id='hmenu-content']//*[@class='hmenu hmenu-visible']//*[@class='hmenu-item hmenu-title '][text()='"+headingName+"']");
    };

    private By lnkAllNavigationMenuHeadingSubMenu(String subMenuName)
    {
        return By.xpath(".//*[@id='hmenu-content']//*[@class='hmenu hmenu-visible']//*[@class='hmenu-item']//*[text()='"+subMenuName+"']");
    }

    private By lnkAllNavigationMenuHeadingSubMenuRightExtensionSubMenu(String rightExtensionSubMenuName)
    {
        return By.xpath(".//*[@class='hmenu hmenu-visible hmenu-translateX']//*[@class='hmenu-item'][text()='"+rightExtensionSubMenuName+"']");
    }

    public boolean clickOnAllNavigationHamburger()
    {
        this.wait.until(d-> State.isElementEnabled(this.elementTypeConverter.returnWebElement(this.lnkAllNavigation)));
        return this.elementActions.clickOnElement(this.elementTypeConverter.returnWebElement(this.lnkAllNavigation));
    }

    public boolean scrollToAllNavigationHamburgerMenuHeading(String headingName)
    {
        try
        {
            this.scrollers.scrollToElement(this.elementTypeConverter.returnWebElement(this.txtAllNavigationMenuHeadings(headingName)));
            this.wait.until(d -> this.visibility.isElementDisplayed(this.elementTypeConverter.returnWebElement(this.txtAllNavigationMenuHeadings(headingName))));
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean clickOnAllNavigationHamburgerMenuHeadingSubMenu(String subMenuName)
    {
        try
        {
            this.wait.until(d -> State.isElementEnabled(this.elementTypeConverter.returnWebElement(this.lnkAllNavigationMenuHeadingSubMenu(subMenuName))));
            return this.elementActions.clickOnElement(this.elementTypeConverter.returnWebElement(this.lnkAllNavigationMenuHeadingSubMenu(subMenuName)));
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean clickOnAllNavigationHamburgerMenuHeadingSubMenuRightExtensionSubMenu(String rightExtensionSubMenuName)
    {
        try
        {
            this.wait.until(d -> State.isElementEnabled(this.elementTypeConverter.returnWebElement(this.lnkAllNavigationMenuHeadingSubMenuRightExtensionSubMenu(rightExtensionSubMenuName))));
            return this.elementActions.clickOnElement(this.elementTypeConverter.returnWebElement(this.lnkAllNavigationMenuHeadingSubMenuRightExtensionSubMenu(rightExtensionSubMenuName)));
        } catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean isAt(String... args)
    {
        return this.wait.until(d -> State.isElementEnabled(this.elementTypeConverter.returnWebElement(this.edtSearchField)));
    }
}
