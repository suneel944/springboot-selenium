package com.auto.spring.springselenium.pages.amazon;

import java.util.List;
import java.util.Comparator;
import org.openqa.selenium.By;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import com.auto.spring.springselenium.pages.Base;
import org.springframework.context.annotation.Lazy;
import com.auto.spring.springselenium.utility.State;
import com.auto.spring.springselenium.utility.Scrollers;
import org.springframework.beans.factory.annotation.Value;
import com.auto.spring.springselenium.utility.ElementActions;
import org.springframework.beans.factory.annotation.Autowired;
import com.auto.spring.springselenium.annotations.PageFragment;
import com.auto.spring.springselenium.utility.ElementTypeConverter;

@PageFragment
public class ProductContent extends Base
{
    @Lazy
    @Autowired
    private ElementTypeConverter elementTypeConverter;

    @Lazy
    @Autowired
    private Scrollers scrollers;

    @Lazy
    @Autowired
    private State state;

    @Lazy
    @Autowired
    private ElementActions elementActions;

    private By pgProductSearchContent = By.xpath(".//*[@data-component-type='s-search-results']/..");

    private By weProductCardPrices = By.xpath("//span[@class='a-price-whole']");

    @Value("${nthHighestProduct.index:1}")
    private Integer productIndex;

    public boolean clickOnTheNthHighestPricedProduct()
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
            if (Integer.parseInt(e.getText().replaceAll(",","")) == priceList.get(this.productIndex))
            {
                this.scrollers.scrollToElement(e);
                this.wait.until(d -> State.isElementEnabled(e));
                return this.elementActions.clickOnElement(e);
            }
        }
        return false;
    }


    @Override
    public boolean isAt()
    {
        return this.wait.until(d -> this.state.isPageLoaded());
    }
}
