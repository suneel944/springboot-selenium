package com.auto.spring.springselenium.framework.Readers;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import com.auto.spring.springselenium.framework.annotations.LazyConfiguration;

@Getter
@LazyConfiguration
public class ConfigReader
{
    @Value("${window.title}")
    private String productPageTitle;

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
}
