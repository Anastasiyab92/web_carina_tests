package com.solvd.amazon;

import com.solvd.amazon.gui.pages.common.CartPageBase;
import com.solvd.amazon.gui.pages.common.HomePageBase;
import com.solvd.amazon.gui.pages.common.ProductPageBase;
import com.solvd.amazon.gui.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    @Test
    public void testOpenHomePage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isAmazonLogoPresent(), "Logo amazon isn't present");
        Assert.assertTrue(homePage.isPageOpened(5), "Home page didn't open.");
    }

    @Test
    public void testSearchProduct() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SearchResultsPageBase searchResultsPage = homePage.searchFor("iphone");
        Assert.assertTrue(searchResultsPage.isSearchResultPresent(), "Search results not found");

        ProductPageBase productPage = searchResultsPage.openFirstProduct();
        Assert.assertTrue(productPage.isProductPageOpened(), "Page didn't open.");
    }

    @Test()
    public void testAddToCartProduct() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SearchResultsPageBase searchResultsPage = homePage.searchFor("laptop");
        ProductPageBase productPage = searchResultsPage.openFirstAvailableProduct("Add to cart");

        CartPageBase cartPage = productPage.addToCart();

        Assert.assertTrue(cartPage.isCartTitlePresent(), "The cart did not open!");
    }
}
