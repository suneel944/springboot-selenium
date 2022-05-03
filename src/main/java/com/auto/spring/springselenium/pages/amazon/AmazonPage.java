package com.auto.spring.springselenium.pages.amazon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.auto.spring.springselenium.pages.Base;
import org.springframework.beans.factory.annotation.Value;
import com.auto.spring.springselenium.framework.annotations.Page;
import com.auto.spring.springselenium.framework.service.Launcher;
import com.auto.spring.springselenium.framework.annotations.LazyAutowired;

@Page
public class AmazonPage extends Base
{
    private Logger logger = LoggerFactory.getLogger(AmazonPage.class);
    @LazyAutowired
    private Launcher launcher;

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
        return this.launcher.launchUrl(url);
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
    public boolean isAt(String... args)
    {
        /*delegating to header content*/
        return this.wait.until(d -> this.headerContent.isAt());
    }
}
