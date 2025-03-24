package com.solvd.amazon;

import com.solvd.amazon.gui.pages.*;
import com.zebrunner.carina.core.IAbstractTest;
import dev.failsafe.internal.util.Assert;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {

    @Test
    public void testSignIn(){
        String email = "anastasiashashok6@gmail.com";
        String password = "fadXuc-4gewso-qijcuf";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.isTrue(homePage.isPageOpened(5), "Home page didn't open.");

        SignInPage loginPage = homePage.clickSignIn();
        AccountPage accountPage = loginPage.login(email,password);
        homePage.clickSignIn();

        Assert.isTrue(accountPage.isTitlePresent(), "Failed to log in to your personal account.");
    }
}
