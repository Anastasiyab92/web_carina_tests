package com.solvd.amazon.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignInPageBase extends AbstractPage {

    public SignInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AccountPageBase login(String email, String password);
}
