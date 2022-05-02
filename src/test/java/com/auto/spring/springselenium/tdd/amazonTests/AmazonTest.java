package com.auto.spring.springselenium.tdd.amazonTests;

import org.slf4j.Logger;
import org.testng.Assert;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Value;
import com.auto.spring.springselenium.pages.amazon.AmazonPage;
import com.auto.spring.springselenium.SpringSeleniumBaseTestNGTest;
import com.auto.spring.springselenium.pages.amazon.AmazonProductPage;
import com.auto.spring.springselenium.framework.annotations.LazyAutowired;

public class AmazonTest extends SpringSeleniumBaseTestNGTest
{
    private static final Logger logger = LoggerFactory.getLogger(AmazonTest.class);

    @Value("${filters.categoryHeading}")
    private String filterCategoryHeading;

    @Value("${filters.categoryContentName}")
    private String filterCategoryContentName;

    @Value("${navigationFromAll.heading.subMenu.rightExtension.subMenu}")
    private String rightExtensionSubMenuName;

    @Value("${navigationFromAll.heading.subMenu}")
    private String subMenuName;

    @Value("${navigationFromAll.heading}")
    private String headingName;

    @Value("${nthHighestProduct.index:1}")
    private Integer productIndex;

    @LazyAutowired
    private AmazonPage amazonPage;

    @LazyAutowired
    private AmazonProductPage amazonProductPage;

    @Test
    public void amazonTest()
    {
        /*open amazon.in*/
        Assert.assertTrue(this.amazonPage.goTo(), "failed to navigate to amazon site");
        /*verify amazon page is opened*/
        Assert.assertTrue(this.amazonPage.isAt(), "failed to load amazon home page");

        /*click on chain hamburger menu and their sub menus and reach tv pages*/
        Assert.assertTrue(this.amazonPage.getHeaderContent().clickOnAllNavigationHamburger(), "failed to click on all hamburger menu");
        Assert.assertTrue(this.amazonPage.getHeaderContent().scrollToAllNavigationHamburgerMenuHeading(headingName), "failed to scroll to "+headingName+" hamburger menu heading");
        Assert.assertTrue(this.amazonPage.getHeaderContent().clickOnAllNavigationHamburgerMenuHeadingSubMenu(subMenuName), "failed to click on "+headingName+" hamburger menu heading's "+subMenuName+" submenu");
        Assert.assertTrue(this.amazonPage.getHeaderContent().clickOnAllNavigationHamburgerMenuHeadingSubMenuRightExtensionSubMenu(rightExtensionSubMenuName), "failed to click on "+headingName+" hamburger menu heading's "+subMenuName+" submenu's '"+rightExtensionSubMenuName+"' right extension submenu");
        /*verify filter content is loaded*/
        Assert.assertTrue(this.amazonPage.getFilterContent().isAt(), "failed to load filter contents");

        /*click on the required filter category*/
        Assert.assertTrue(this.amazonPage.getFilterContent().clickOnFilterContentUnderCategory(filterCategoryHeading, filterCategoryContentName), "failed to click on "+filterCategoryHeading+" filter heading content and "+filterCategoryContentName+" filter category category");
        /*verify product catalogue contents are displayed*/
        Assert.assertTrue(this.amazonPage.getProductContent().isAt(), "failed to load "+filterCategoryContentName+" product catalogue contents");

        /*click on the nth highest valued product from the available list*/
        Assert.assertTrue(this.amazonPage.getProductContent().clickOnTheNthHighestPricedProduct(productIndex), "failed to click on the "+productIndex+" highest valued product");
        /*verify if the product page is loaded and content is displayed*/
        Assert.assertTrue(this.amazonProductPage.isAt(), "failed to load individual product specific page");
    }
}
