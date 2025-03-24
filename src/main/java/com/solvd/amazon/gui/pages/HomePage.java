package com.solvd.amazon.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(id= "nav-link-accountList-nav-line-1")
    private ExtendedWebElement signInButton;

    @FindBy(id = "twotabsearchtextbox")
    private ExtendedWebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private ExtendedWebElement button;

    @FindBy(id = "nav-logo-sprites")
    private ExtendedWebElement amazonLogo;

    @FindBy(xpath = "//input[@data-action-type='DISMISS']")
    private ExtendedWebElement dismissButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        super.open();
        dismissButton.clickIfPresent();
    }

    public boolean isAmazonLogoPresent() {
        return amazonLogo.isElementPresent(5);
    }

    public SearchResultsPage searchFor(String query) {
        searchBox.type(query);
        button.click();
        return new SearchResultsPage(driver);
    }

    public SignInPage clickSignIn(){
        signInButton.clickIfPresent(5);
        return new SignInPage(driver);
    }
}
