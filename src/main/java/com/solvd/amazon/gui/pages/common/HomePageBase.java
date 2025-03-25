package com.solvd.amazon.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class HomePageBase extends AbstractPage {

    @FindBy(xpath = "//input[@data-action-type='DISMISS']")
    private ExtendedWebElement dismissButton;

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SearchResultsPageBase searchFor(String query);

    public abstract SignInPageBase clickSignIn();

    public abstract boolean isAmazonLogoPresent();

    @Override
    public void open() {
        super.open();
        dismissButton.clickIfPresent();
    }
}
