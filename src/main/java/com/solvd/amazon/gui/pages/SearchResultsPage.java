package com.solvd.amazon.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class SearchResultsPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@data-component-type='s-search-result']//span//a//h2//span")
    private List<ExtendedWebElement> searchResult;

    @FindBy(id = "nav-search-submit-button")
    private ExtendedWebElement button;

    @FindBy(xpath = "//span/button")
    private List<ExtendedWebElement> addToCartButtons;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage openFirstProduct(){
        WebElement product = searchResult.get(0).getElement();
        product.click();
        return new ProductPage(driver);
    }

    public ProductPage openFirstAvailableProduct(String nameButton) {
        for(int i= 0; i<searchResult.size();i++){
            ExtendedWebElement product = searchResult.get(i);
            ExtendedWebElement button = addToCartButtons.get(i);

            if(button.isPresent() && button.getText().contains(nameButton)){
                product.click();
                return new ProductPage(driver);
            }
        }
        LOGGER.info("There are no products available for purchase!");
        return null;
    }

    public boolean isSearchResultPresent() {
        return !searchResult.isEmpty();
    }
}
