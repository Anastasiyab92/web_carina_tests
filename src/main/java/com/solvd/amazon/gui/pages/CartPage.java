package com.solvd.amazon.gui.pages;

import com.solvd.amazon.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass =CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//h1[contains(text(),'Added to cart')]")
    public ExtendedWebElement cartTitle;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCartTitlePresent() {
        return cartTitle.isElementPresent(5);
    }
}
