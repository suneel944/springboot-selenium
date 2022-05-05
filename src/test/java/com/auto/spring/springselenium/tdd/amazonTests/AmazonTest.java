package com.auto.spring.springselenium.tdd.amazonTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.auto.spring.springselenium.pages.amazon.AmazonPage;
import com.auto.spring.springselenium.SpringSeleniumBaseTestNGTest;
import com.auto.spring.springselenium.framework.readers.ConfigReader;
import com.auto.spring.springselenium.pages.amazon.AmazonProductPage;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;

public class AmazonTest extends SpringSeleniumBaseTestNGTest
{
    @LazyAutowired
    private ConfigReader configReader;

    @LazyAutowired
    private AmazonPage amazonPage;

    @LazyAutowired
    private AmazonProductPage amazonProductPage;

    @Test
    public void amazonTest_001()
    {
        /*open amazon.in*/
        Assert.assertTrue(this.amazonPage.goTo(), "failed to navigate to amazon site");
        /*verify amazon page is opened*/
        Assert.assertTrue(this.amazonPage.isAt(), "failed to load amazon home page");

        /*click on chain hamburger menu and their sub menus and reach tv pages*/
        Assert.assertTrue(this.amazonPage.getHeaderContent().clickOnAllNavigationHamburger(), "failed to click on all hamburger menu");
        Assert.assertTrue(this.amazonPage.getHeaderContent().scrollToAllNavigationHamburgerMenuHeading(configReader.getHeadingName()), "failed to scroll to "+configReader.getHeadingName()+" hamburger menu heading");
        Assert.assertTrue(this.amazonPage.getHeaderContent().clickOnAllNavigationHamburgerMenuHeadingSubMenu(configReader.getSubMenuName()), "failed to click on "+configReader.getHeadingName()+" hamburger menu heading's "+configReader.getSubMenuName()+" submenu");
        Assert.assertTrue(this.amazonPage.getHeaderContent().clickOnAllNavigationHamburgerMenuHeadingSubMenuRightExtensionSubMenu(configReader.getRightExtensionSubMenuName()), "failed to click on "+configReader.getHeadingName()+" hamburger menu heading's "+configReader.getSubMenuName()+" submenu's '"+configReader.getRightExtensionSubMenuName()+"' right extension submenu");
        /*verify filter content is loaded*/
        Assert.assertTrue(this.amazonPage.getFilterContent().isAt(configReader.getFilterCategoryHeading()), "failed to load filter contents");

        /*click on the required filter category*/
        Assert.assertTrue(this.amazonPage.getFilterContent().clickOnFilterContentUnderCategory(configReader.getFilterCategoryHeading(), configReader.getFilterCategoryContentName()), "failed to click on "+configReader.getFilterCategoryHeading()+" filter heading content and "+configReader.getFilterCategoryContentName()+" filter category category");
        /*verify product catalogue contents are displayed*/
        Assert.assertTrue(this.amazonPage.getProductContent().isAt(), "failed to load "+configReader.getFilterCategoryContentName()+" product catalogue contents");

        /*click on the nth highest valued product from the available list*/
        Assert.assertTrue(this.amazonPage.getProductContent().clickOnTheNthHighestPricedProduct(configReader.getProductIndex()), "failed to click on the "+configReader.getProductIndex()+" highest valued product");
        /*verify if the product page is loaded and content is displayed*/
        Assert.assertTrue(this.amazonProductPage.isAt(), "failed to load individual product specific page");
        Assert.assertTrue(this.amazonProductPage.scrollToProductTextContent(), "failed to scroll to product about section");
        Assert.assertFalse(this.amazonProductPage.getProductTextContent().isEmpty(), "product about section is displayed");
    }
}
