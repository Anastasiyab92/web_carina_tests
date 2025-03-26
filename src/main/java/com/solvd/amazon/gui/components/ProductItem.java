package com.solvd.amazon.gui.components;

import com.solvd.amazon.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = ".//h2/span")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = "//div[@data-component-type='s-search-result']//a[contains(@href, '/dp/')]")
    private ExtendedWebElement productLink;

    @FindBy(xpath = ".//span/button")
    private ExtendedWebElement addToCartButton;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getAddToCartButton() {
        return addToCartButton.getText();
    }

    public boolean isAddToCartButton() {
        return addToCartButton.isElementPresent();
    }


    public ProductPageBase openProductPage() {
        productLink.click();
        return initPage(driver, ProductPageBase.class);
    }
}
