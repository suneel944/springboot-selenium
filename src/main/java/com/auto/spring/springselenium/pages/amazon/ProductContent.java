package com.auto.spring.springselenium.pages.amazon;

import java.util.List;
import java.util.Comparator;
import org.openqa.selenium.By;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import com.auto.spring.springselenium.pages.BasePage;
import com.auto.spring.springselenium.framework.service.State;
import com.auto.spring.springselenium.framework.service.Scrollers;
import com.auto.spring.springselenium.framework.service.ElementActions;
import com.auto.spring.springselenium.framework.service.ElementTypeConverter;
import com.auto.spring.springselenium.framework.annotations.others.PageFragment;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;

@PageFragment
public class ProductContent extends BasePage
{
    @LazyAutowired
    private ElementTypeConverter elementTypeConverter;

    @LazyAutowired
    private Scrollers scrollers;

    @LazyAutowired
    private State state;

    @LazyAutowired
    private ElementActions elementActions;

    private By pgProductSearchContent = By.xpath(".//*[@data-component-type='s-search-results']/..");

    private By weProductCardPrices = By.xpath("//span[@class='a-price-whole']");

    public boolean clickOnTheNthHighestPricedProduct(Integer productIndex)
    {
        List<WebElement> elements = this.elementTypeConverter.returnWebElements(this.weProductCardPrices);
        /*remove sponsored product adds from the list as they are not visible in the UI*/
        elements.remove(0);
        elements.remove(1);
        List<Integer> priceList = elements.stream().map(s -> Integer.parseInt(s.getText().replaceAll(",",""))).collect(Collectors.toList());
        priceList = priceList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (WebElement e: elements
             )
        {
            if (Integer.parseInt(e.getText().replaceAll(",","")) == priceList.get(productIndex))
            {
                this.scrollers.scrollToElement(e);
                this.wait.until(d -> this.state.isElementEnabled(e));
                return this.elementActions.clickOnElementUsingJs(e);
            }
        }
        return false;
    }

    @Override
    public boolean isAt(String... args)
    {
        return this.wait.until(d -> this.state.isPageLoaded());
    }
}
