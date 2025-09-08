package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    private WebDriver driver;

    // Locators
    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.xpath("//button[@type='submit' and @class='button-1 search-box-button']");
    private By noResultMessage = By.className("no-result");
    private By searchResultItems = By.cssSelector(".product-item h2.product-title a");

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterSearchText(String text) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(text);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public boolean isNoResultDisplayed() {
        return driver.findElements(noResultMessage).size() > 0;
    }

    public boolean isSearchResultDisplayed() {
        return driver.findElements(searchResultItems).size() > 0;
    }

    // Click on the first product from search results
    public void clickOnFirstProduct() {
        List<WebElement> results = driver.findElements(searchResultItems);
        if (!results.isEmpty()) {
            results.get(0).click();
        } else {
            throw new RuntimeException("No products found to click");
        }
    }

    // Click on a product by name (supports partial match)
    public void clickOnProductByName(String productName) {
        List<WebElement> results = driver.findElements(searchResultItems);
        for (WebElement product : results) {
            String productText = product.getText().trim();
            if (productText.equalsIgnoreCase(productName) || productText.toLowerCase().contains(productName.toLowerCase())) {
                product.click();
                return;
            }
        }
        throw new RuntimeException("Product with name " + productName + " not found in search results");
    }
}
