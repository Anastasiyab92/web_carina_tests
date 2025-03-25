package com.solvd.amazon.gui.pages;

import com.solvd.amazon.gui.pages.common.CartPageBase;
import com.solvd.amazon.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(id="titleSection")
    private ExtendedWebElement titleProduct;

    @FindBy(id = "add-to-cart-button")
    private ExtendedWebElement addToCartButton;



    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPageBase addToCart() {
        addToCartButton.click();
        return initPage(driver, CartPageBase.class);
    }

    @Override
    public boolean isProductPageOpened() {
        return titleProduct.isElementPresent(3);
    }
}
