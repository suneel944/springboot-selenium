package com.auto.spring.springselenium.amazonTests;

import com.auto.spring.springselenium.SpringSeleniumBaseTestNGTest;
import com.auto.spring.springselenium.pages.amazon.AmazonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends SpringSeleniumBaseTestNGTest
{
    @Autowired
    private AmazonPage amazonPage;

    @Test
    public void amazonTest()
    {
        /*open amazon.in*/
        Assert.assertTrue(this.amazonPage.goTo(), "failed to navigate to amazon site");
        /*verify amazon page is opened*/
        Assert.assertTrue(this.amazonPage.isAt(), "failed to load amazon page");

        /*click on chain hamburger menu and their sub menus and reach tv pages*/
        Assert.assertTrue(this.amazonPage.getHeaderContent().clickOnAllNavigationHamburger(), "failed to click on hamburger menu");
        Assert.assertTrue(this.amazonPage.getHeaderContent().scrollToAllNavigationHamburgerMenuHeading(), "failed to scroll to hamburger menu heading");
        Assert.assertTrue(this.amazonPage.getHeaderContent().clickOnAllNavigationHamburgerMenuHeadingSubMenu(), "failed to click on hamburger menu heading's submenu");
        Assert.assertTrue(this.amazonPage.getHeaderContent().clickOnAllNavigationHamburgerMenuHeadingSubMenuRightExtensionSubMenu(), "failed to click on hamburger menu heading's submenu's right extension submenu");
        /*verify filter content is loaded*/
        Assert.assertTrue(this.amazonPage.getFilterContent().isAt(), "failed to load filter contents");

        /*click on the required filter category*/
        Assert.assertTrue(this.amazonPage.getFilterContent().clickOnFilterContentUnderCategory(), "failed to click on filter content category");
        /*verify product page is displayed*/
        Assert.assertTrue(this.amazonPage.getProductContent().isAt(), "failed to load product page");

        /*click on the nth highest valued product from the available list*/
        Assert.assertTrue(this.amazonPage.getProductContent().clickOnTheNthHighestPricedProduct(), "failed to click on the nth highest valued product");
    }
}
