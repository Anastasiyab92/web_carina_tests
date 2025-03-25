package com.solvd.amazon;

import com.solvd.amazon.gui.pages.common.AccountPageBase;
import com.solvd.amazon.gui.pages.common.HomePageBase;
import com.solvd.amazon.gui.pages.common.SignInPageBase;
import com.zebrunner.carina.core.IAbstractTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {

    @Test
    public void testSignIn() {
        String email = "anastasiashashok6@gmail.com";
        String password = "fadXuc-4gewso-qijcuf";
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(5), "Home page didn't open.");

        SignInPageBase loginPage = homePage.clickSignIn();
        AccountPageBase accountPage = loginPage.login(email, password);
        homePage.clickSignIn();

        Assert.assertTrue(accountPage.isTitlePresent(), "Failed to log in to your personal account.");
    }
}
