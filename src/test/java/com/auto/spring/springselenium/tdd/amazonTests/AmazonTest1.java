package com.auto.spring.springselenium.tdd.amazonTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.auto.spring.springselenium.pages.amazon.AmazonPage;
import com.auto.spring.springselenium.SpringSeleniumBaseTestNGTest;
import com.auto.spring.springselenium.framework.readers.ConfigReader;
import com.auto.spring.springselenium.pages.amazon.AmazonProductPage;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;

public class AmazonTest1 extends SpringSeleniumBaseTestNGTest
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
        this.amazonPage.goTo();
        /*verify amazon page is opened*/
        Assert.assertTrue(this.amazonPage.isAt(), "failed to load amazon home page");

        /*click on chain hamburger menu and their sub menus and reach tv pages*/

        this.amazonPage.getHeaderContent().clickOnAllNavigationHamburger();
        this.amazonPage.getHeaderContent().scrollToAllNavigationHamburgerMenuHeading(configReader.getHeadingName());
        this.amazonPage.getHeaderContent().clickOnAllNavigationHamburgerMenuHeadingSubMenu(configReader.getSubMenuName());
        this.amazonPage.getHeaderContent().clickOnAllNavigationHamburgerMenuHeadingSubMenuRightExtensionSubMenu(configReader.getRightExtensionSubMenuName());
        /*verify filter content is loaded*/
        Assert.assertTrue(this.amazonPage.getFilterContent().isAt(configReader.getFilterCategoryHeading()));

        /*click on the required filter category*/
        this.amazonPage.getFilterContent().clickOnFilterContentUnderCategory(configReader.getFilterCategoryHeading(), configReader.getFilterCategoryContentName());
        /*verify product catalogue contents are displayed*/
        Assert.assertTrue(this.amazonPage.getProductContent().isAt(), "failed to load "+configReader.getFilterCategoryContentName()+" product catalogue contents");

        /*click on the nth highest valued product from the available list*/
        this.amazonPage.getProductContent().clickOnTheNthHighestPricedProduct(configReader.getProductIndex());
        /*verify if the product page is loaded and content is displayed*/
        Assert.assertTrue(this.amazonProductPage.isAt(), "failed to load individual product specific page");
        Assert.assertTrue(this.amazonProductPage.scrollToProductTextContent(), "failed to scroll to product about section");
        Assert.assertFalse(this.amazonProductPage.getProductTextContent().isEmpty(), "product about section is displayed");
    }
}
