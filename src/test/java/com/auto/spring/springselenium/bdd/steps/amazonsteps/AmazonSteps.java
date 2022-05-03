package com.auto.spring.springselenium.bdd.steps.amazonsteps;

import org.testng.Assert;
import io.cucumber.java.en.*;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import com.auto.spring.springselenium.pages.amazon.AmazonPage;
import static org.apache.commons.lang3.reflect.TypeUtils.isInstance;
import com.auto.spring.springselenium.pages.amazon.AmazonProductPage;
import com.auto.spring.springselenium.framework.annotations.LazyAutowired;

@SpringBootTest
@CucumberContextConfiguration
public class AmazonSteps
{
        @LazyAutowired
        private AmazonPage amazonPage;

        @LazyAutowired
        private AmazonProductPage amazonProductPage;

        @Given("^I am on the amazon site$")
        public void launchSite()
        {
                this.amazonPage.goTo();
                this.amazonPage.isAt();
        }
        @When("^I select \"([^\"]*)\" right extension submenu from \"([^\"]*)\" heading's \"([^\"]*)\" submenu's$")
        public void clickOnAllNavigationHamburgerMenuHeadingSubMenuRightExtensionSubMenu(String rightExtensionSubMenuName, String headingName, String subMenuName)
        {
                this.amazonPage.getHeaderContent().clickOnAllNavigationHamburger();
                this.amazonPage.getHeaderContent().scrollToAllNavigationHamburgerMenuHeading(headingName);
                this.amazonPage.getHeaderContent().clickOnAllNavigationHamburgerMenuHeadingSubMenu(subMenuName);
                this.amazonPage.getHeaderContent().clickOnAllNavigationHamburgerMenuHeadingSubMenuRightExtensionSubMenu(rightExtensionSubMenuName);
        }
        @And("^I filter for \"([^\"]*)\" product under \"([^\"]*)\" category$")
        public void clickOnFilterContentUnderCategory(String filterCategoryContentName, String filterCategoryHeading)
        {
                this.amazonPage.getFilterContent().isAt();
                this.amazonPage.getFilterContent().clickOnFilterContentUnderCategory(filterCategoryHeading, filterCategoryContentName);
        }
        @Then("^I should see \"([^\"]*)\" brand products$")
        public void verifyProductCataloguePage(String product)
        {
                Assert.assertTrue(this.amazonPage.getProductContent().isAt(product), "failed to load "+product+" product catalogue contents");
        }
        @When("^I click on the (\\d+) highest priced product$")
        public void clickOnTheNthHighestPricedProduct(Integer productIndex)
        {
                this.amazonPage.getProductContent().clickOnTheNthHighestPricedProduct(productIndex);
        }

        @Then("^I should see the individual product page$")
        public void verifyProductPageIsDisplayed()
        {
                Assert.assertTrue(this.amazonProductPage.isAt(), "failed to load individual product specific page");
        }

        @When("^I scroll to feature bullet content$")
        public void scrollToProductTextContent()
        {
                this.amazonProductPage.scrollToProductTextContent();
        }

        @Then("^I should see feature bullet content for the product$")
        public void verifyProductContentIsDisplayed()
        {
                Assert.assertTrue(isInstance(this.amazonProductPage.getProductTextContent(), String.class) && !this.amazonProductPage.getProductTextContent().isEmpty(), "failed to visualise product feature bullet points");
        }
}

