package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.ProductPage;
import com.nopcommerce.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends Basetest {

    @Test(priority = 1)
    public void testAddProductToCart() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchText("Apple MacBook");
        searchPage.clickSearchButton();
        searchPage.clickOnProductByName("Apple MacBook Pro"); // works with partial match

        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.getProductName().contains("MacBook"), "Product page not loaded correctly");

        productPage.addToCart();
        String successMsg = productPage.getSuccessMessage().toLowerCase();
        Assert.assertTrue(successMsg.contains("shopping cart"), "Add to cart failed! Got: " + successMsg);
    }

    @Test(priority = 2)
    public void testAddProductToWishlist() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchText("Asus");
        searchPage.clickSearchButton();
        searchPage.clickOnProductByName("Asus"); // works with partial match

        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.getProductName().contains("Asus"), "Product page not loaded correctly");

        productPage.addToWishlist();
        String successMsg = productPage.getSuccessMessage().toLowerCase();
        Assert.assertTrue(successMsg.contains("wishlist"), "Add to wishlist failed! Got: " + successMsg);
    }
}
