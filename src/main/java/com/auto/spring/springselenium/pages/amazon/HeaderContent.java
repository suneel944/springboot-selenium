package com.auto.spring.springselenium.pages.amazon;

import org.openqa.selenium.By;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.auto.spring.springselenium.pages.Base;
import com.auto.spring.springselenium.utility.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class HeaderContent extends Base
{
    @Value("${navigationFromAll.heading.subMenu.rightExtension.subMenu}")
    private String rightExtensionSubMenuName;

    @Value("${navigationFromAll.heading.subMenu}")
    private String subMenuName;

    @Value("${navigationFromAll.heading}")
    private String headingName;

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

    private By txtAllNavigationMenuHeadings()
    {
        return By.xpath(".//*[@id='hmenu-content']//*[@class='hmenu hmenu-visible']//*[@class='hmenu-item hmenu-title '][text()='"+this.headingName+"']");
    };

    private By lnkAllNavigationMenuHeadingSubMenu()
    {
        return By.xpath(".//*[@id='hmenu-content']//*[@class='hmenu hmenu-visible']//*[@class='hmenu-item']//*[text()='"+this.subMenuName+"']");
    }

    private By lnkAllNavigationMenuHeadingSubMenuRightExtensionSubMenu()
    {
        return By.xpath(".//*[@class='hmenu hmenu-visible hmenu-translateX']//*[@class='hmenu-item'][text()='"+this.rightExtensionSubMenuName+"']");
    }

    public boolean clickOnAllNavigationHamburger()
    {
        this.wait.until(d->State.isElementEnabled(this.elementTypeConverter.returnWebElement(this.lnkAllNavigation)));
        return this.elementActions.clickOnElement(this.elementTypeConverter.returnWebElement(this.lnkAllNavigation));
    }

    public boolean scrollToAllNavigationHamburgerMenuHeading()
    {
        try
        {
            this.scrollers.scrollToElement(this.elementTypeConverter.returnWebElement(this.txtAllNavigationMenuHeadings()));
            this.wait.until(d -> this.visibility.isElementDisplayed(this.elementTypeConverter.returnWebElement(this.txtAllNavigationMenuHeadings())));
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean clickOnAllNavigationHamburgerMenuHeadingSubMenu()
    {
        try
        {
            this.wait.until(d -> State.isElementEnabled(this.elementTypeConverter.returnWebElement(this.lnkAllNavigationMenuHeadingSubMenu())));
            return this.elementActions.clickOnElement(this.elementTypeConverter.returnWebElement(this.lnkAllNavigationMenuHeadingSubMenu()));
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean clickOnAllNavigationHamburgerMenuHeadingSubMenuRightExtensionSubMenu()
    {
        try
        {
            this.wait.until(d -> State.isElementEnabled(this.elementTypeConverter.returnWebElement(this.lnkAllNavigationMenuHeadingSubMenuRightExtensionSubMenu())));
            return this.elementActions.clickOnElement(this.elementTypeConverter.returnWebElement(this.lnkAllNavigationMenuHeadingSubMenuRightExtensionSubMenu()));
        } catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean isAt()
    {
        return this.wait.until(d -> State.isElementEnabled(this.elementTypeConverter.returnWebElement(this.edtSearchField)));
    }
}
