package com.auto.spring.springselenium.pages.amazon;

import com.auto.spring.springselenium.pages.Base;
import org.springframework.context.annotation.Lazy;
import com.auto.spring.springselenium.framework.annotations.Page;
import org.springframework.beans.factory.annotation.Value;
import com.auto.spring.springselenium.framework.service.BrowserActions;
import org.springframework.beans.factory.annotation.Autowired;

@Page
public class AmazonPage extends Base
{
    @Lazy
    @Autowired
    private BrowserActions browserActions;

    @Lazy
    @Autowired
    private FilterContent filterContent;

    @Lazy
    @Autowired
    private HeaderContent headerContent;

    @Lazy
    @Autowired
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
