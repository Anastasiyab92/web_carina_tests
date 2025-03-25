package com.solvd.amazon.gui.pages;

import com.solvd.amazon.gui.pages.common.AccountPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AccountPageBase.class)
public class AccountPage extends AccountPageBase {

    @FindBy(xpath = ".//h1[contains(text(), 'Your Account')]")
    private ExtendedWebElement titlePage;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitlePresent() {
        return titlePage.isElementPresent(5);
    }
}
