package com.solvd.amazon.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy(xpath = ".//h1[contains(text(), 'Your Account')]")
    private ExtendedWebElement titlePage;

    public AccountPage(WebDriver driver){
        super(driver);
    }

    public boolean isTitlePresent(){
        return titlePage.isElementPresent(5);
    }
}
