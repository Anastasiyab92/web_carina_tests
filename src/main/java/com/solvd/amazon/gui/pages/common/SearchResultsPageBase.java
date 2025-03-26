package com.solvd.amazon.gui.pages.common;

import com.solvd.amazon.gui.components.ProductItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SearchResultsPageBase extends AbstractPage {

    public SearchResultsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPageBase openFirstProduct();

    public abstract ProductPageBase openFirstAvailableProduct(String nameButton);

    public abstract boolean isSearchResultPresent();

    public abstract List<ProductItem> getProductItems();

}
