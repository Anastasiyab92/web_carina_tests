package com.solvd.amazon.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCartTitlePresent();
}
