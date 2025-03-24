package com.solvd.amazon.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains(text(),'Added to cart')]")
    public ExtendedWebElement cartTitle;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartTitlePresent() {
        return cartTitle.isElementPresent(5);
    }
}
