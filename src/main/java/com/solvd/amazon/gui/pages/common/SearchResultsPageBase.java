package com.solvd.amazon.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchResultsPageBase extends AbstractPage {

    public SearchResultsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPageBase openFirstProduct();

    public abstract ProductPageBase openFirstAvailableProduct(String nameButton);

    public abstract boolean isSearchResultPresent();

}
