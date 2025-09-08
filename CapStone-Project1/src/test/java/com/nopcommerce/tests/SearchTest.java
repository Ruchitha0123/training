package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends Basetest {

    @Test(priority = 2)
    public void testValidSearchAndClickProduct() {
        SearchPage searchPage = new SearchPage(driver);

        // Search for Apple MacBook
        searchPage.enterSearchText("Apple MacBook pro");
        searchPage.clickSearchButton();

        Assert.assertTrue(searchPage.isSearchResultDisplayed(), "Search results should be displayed");

        // Click on product
        searchPage.clickOnProductByName("Apple MacBook Pro");

        // Verify we landed on product detail page
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Apple MacBook Pro"), "Product detail page should open");
    }

    @Test(priority = 1)
    public void testInvalidSearch_NoProductFound() {
        SearchPage searchPage = new SearchPage(driver);

        searchPage.enterSearchText("xyz123dummy");
        searchPage.clickSearchButton();

        Assert.assertTrue(searchPage.isNoResultDisplayed(), "No result message should be displayed");
    }
}
