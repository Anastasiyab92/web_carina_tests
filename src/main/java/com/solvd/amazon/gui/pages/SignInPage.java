package com.solvd.amazon.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {

    @FindBy(id = "ap_email")
    private ExtendedWebElement emailField;

    @FindBy(id = "continue")
    private ExtendedWebElement continueButton;

    @FindBy(id = "ap_password")
    private ExtendedWebElement passwordField;

    @FindBy(id = "signInSubmit")
    private ExtendedWebElement singInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage login(String email, String password) {
        emailField.type(email);
        continueButton.click();
        passwordField.type(password);
        singInButton.click();
        return new AccountPage(driver);
    }
}
