package com.solvd.amazon.gui.pages;

import com.solvd.amazon.gui.components.ProductItem;
import com.solvd.amazon.gui.pages.common.ProductPageBase;
import com.solvd.amazon.gui.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchResultsPageBase.class)
public class SearchResultsPage extends SearchResultsPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@data-component-type='s-search-result']")
    private List<ProductItem> productItemList;

    @FindBy(id = "nav-search-submit-button")
    private ExtendedWebElement buttonSearch;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductPageBase openFirstProduct() {
        if (!productItemList.isEmpty()) {
            return productItemList.get(0).openProductPage();
        }
        LOGGER.warn("No products found in search results.");
        return null;
    }

    @Override
    public ProductPageBase openFirstAvailableProduct(String nameButton) {
        for (ProductItem productItem : productItemList) {
            if (productItem.isAddToCartButton() && productItem.getAddToCartButton().contains(nameButton)) {
                LOGGER.info("Opening product page: {}", productItem.getProductTitle());
                return productItem.openProductPage();
            }
        }
        LOGGER.info("There are no products available for purchase!");
        return null;
    }

    @Override
    public List<ProductItem> getProductItems() {
        return productItemList;
    }

    @Override
    public boolean isSearchResultPresent() {
        return !productItemList.isEmpty();
    }
}
