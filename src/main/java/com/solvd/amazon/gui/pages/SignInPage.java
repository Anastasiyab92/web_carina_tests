package com.solvd.amazon.gui.pages;

import com.solvd.amazon.gui.pages.common.AccountPageBase;
import com.solvd.amazon.gui.pages.common.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass =SignInPageBase.class)
public class SignInPage extends SignInPageBase {

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

    public AccountPageBase login(String email, String password) {
        emailField.type(email);
        continueButton.click();
        passwordField.type(password);
        singInButton.click();
        return initPage(driver, AccountPageBase.class);
    }
}
