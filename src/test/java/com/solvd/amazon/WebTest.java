package com.solvd.amazon;

import com.solvd.amazon.gui.pages.*;
import com.zebrunner.carina.core.IAbstractTest;
import dev.failsafe.internal.util.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    @Test
    public void testOpenHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.isTrue(homePage.isAmazonLogoPresent(), "Logo amazon isn't present");
        Assert.isTrue(homePage.isPageOpened(5), "Home page didn't open.");
    }

    @Test
    public void testSearchProduct() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.isTrue(homePage.isPageOpened(), "Home page is not opened");

        SearchResultsPage searchResultsPage = homePage.searchFor("iphone");
        Assert.isTrue(searchResultsPage.isSearchResultPresent(), "Search results not found");

        ProductPage productPage = searchResultsPage.openFirstProduct();
        productPage.isPageOpened();
    }

    @Test()
    public void testAddToCartProduct() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.isTrue(homePage.isPageOpened(), "Home page is not opened");

        SearchResultsPage searchResultsPage = homePage.searchFor("laptop");
        ProductPage productPage = searchResultsPage.openFirstAvailableProduct("Add to cart");

        CartPage cartPage = productPage.addToCart();

        Assert.isTrue(cartPage.isCartTitlePresent(), "The cart did not open!");
    }
}
