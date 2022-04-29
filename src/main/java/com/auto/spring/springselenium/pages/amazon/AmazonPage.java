package com.auto.spring.springselenium.pages.amazon;

import com.auto.spring.springselenium.pages.Base;
import org.springframework.beans.factory.annotation.Value;
import com.auto.spring.springselenium.framework.annotations.Page;
import com.auto.spring.springselenium.framework.service.BrowserActions;
import com.auto.spring.springselenium.framework.annotations.LazyAutowired;

@Page
public class AmazonPage extends Base
{
    @LazyAutowired
    private BrowserActions browserActions;

    @LazyAutowired
    private FilterContent filterContent;

    @LazyAutowired
    private HeaderContent headerContent;

    @LazyAutowired
    private ProductContent productContent;

    @Value("${application.url}")
    private String url;

    public boolean goTo()
    {
        return this.browserActions.launchUrl(url);
    }

    public FilterContent getFilterContent()
    {
        return filterContent;
    }

    public HeaderContent getHeaderContent()
    {
        return headerContent;
    }

    public ProductContent getProductContent()
    {
        return productContent;
    }

    @Override
    public boolean isAt()
    {
        /*delegating to header content*/
        return this.wait.until(d -> this.headerContent.isAt());
    }
}
