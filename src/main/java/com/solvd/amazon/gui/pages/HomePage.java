package com.solvd.amazon.gui.pages;

import com.solvd.amazon.gui.pages.common.HomePageBase;
import com.solvd.amazon.gui.pages.common.SearchResultsPageBase;
import com.solvd.amazon.gui.pages.common.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private ExtendedWebElement signInButton;

    @FindBy(id = "twotabsearchtextbox")
    private ExtendedWebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private ExtendedWebElement button;

    @FindBy(id = "nav-logo-sprites")
    private ExtendedWebElement amazonLogo;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchResultsPageBase searchFor(String query) {
        searchBox.type(query);
        button.click();
        return initPage(driver, SearchResultsPageBase.class);
    }

    @Override
    public SignInPageBase clickSignIn() {
        signInButton.clickIfPresent(5);
        return initPage(driver, SignInPageBase.class);
    }

    @Override
    public boolean isAmazonLogoPresent() {
        return amazonLogo.isElementPresent(5);
    }
}
