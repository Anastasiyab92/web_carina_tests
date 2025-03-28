package com.solvd.carina.demo;

import com.solvd.carina.demo.gui.pages.common.CompareModelsPageBase;
import com.solvd.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * This sample shows how works page opening strategy
 *
 * @author qpsdemo
 */
public class PageOpeningStrategySampleTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "qpsdemo")
    public void testByElementOpeningStrategy() {

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        CompareModelsPageBase compareModelsPage = homePage.openComparePage();
        compareModelsPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);

        softAssert.assertTrue(compareModelsPage.isPageOpened(), "Compare page is not opened");
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    public void testByURLOpeningStrategy() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.setPageOpeningStrategy(PageOpeningStrategy.BY_URL);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        CompareModelsPageBase compareModelsPage = homePage.openComparePage();
        compareModelsPage.setPageOpeningStrategy(PageOpeningStrategy.BY_URL);

        softAssert.assertTrue(compareModelsPage.isPageOpened(), "Compare page is not opened");
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    public void testByUrlAndElementOpeningStrategy() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        CompareModelsPageBase compareModelsPage = homePage.openComparePage();
        compareModelsPage.setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);

        softAssert.assertTrue(compareModelsPage.isPageOpened(), "Compare page is not opened");
        softAssert.assertAll();
    }

}
