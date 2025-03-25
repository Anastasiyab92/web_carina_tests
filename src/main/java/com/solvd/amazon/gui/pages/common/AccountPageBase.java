package com.solvd.amazon.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AccountPageBase extends AbstractPage {

    public AccountPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTitlePresent();
}
