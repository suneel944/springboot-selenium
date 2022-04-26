package com.auto.spring.springselenium.pages.amazon;

import org.springframework.stereotype.Component;
import com.auto.spring.springselenium.pages.Base;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import com.auto.spring.springselenium.utility.BrowserActions;

@Component
public class AmazonPage extends Base
{
    @Autowired
    private BrowserActions browserActions;
    @Autowired
    private FilterContent filterContent;

    @Autowired
    private HeaderContent headerContent;

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
