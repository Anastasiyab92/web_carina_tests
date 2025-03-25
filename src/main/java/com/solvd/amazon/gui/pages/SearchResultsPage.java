package com.solvd.amazon.gui.pages;

import com.solvd.amazon.gui.pages.common.ProductPageBase;
import com.solvd.amazon.gui.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass =SearchResultsPageBase.class)
public class SearchResultsPage extends SearchResultsPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@data-component-type='s-search-result']//span//a//h2//span")
    private List<ExtendedWebElement> searchResult;

    @FindBy(id = "nav-search-submit-button")
    private ExtendedWebElement buttonSearch;

    @FindBy(xpath = "//span/button")
    private List<ExtendedWebElement> addToCartButtons;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductPageBase openFirstProduct() {
        WebElement product = searchResult.get(0).getElement();
        product.click();
        return initPage(driver, ProductPageBase.class);
    }

    @Override
    public ProductPageBase openFirstAvailableProduct(String nameButton) {
        for (int i = 0; i < searchResult.size(); i++) {
            ExtendedWebElement product = searchResult.get(i);
            ExtendedWebElement button = addToCartButtons.get(i);

            if (button.isPresent() && button.getText().contains(nameButton)) {
                product.click();
                return initPage(driver, ProductPageBase.class);
            }
        }
        LOGGER.info("There are no products available for purchase!");
        return null;
    }

    @Override
    public boolean isSearchResultPresent() {
        return !searchResult.isEmpty();
    }
}
