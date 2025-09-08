package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.ProductPage;
import com.nopcommerce.pages.SearchPage;
import com.nopcommerce.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends Basetest {

    @Test(priority = 4)
    public void testOpenShoppingCartAndTickTerms() {
        // Search for product and add to cart
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchText("Apple MacBook");
        searchPage.clickSearchButton();
        searchPage.clickOnProductByName("Apple MacBook Pro");

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();

        // Navigate to shopping cart
        driver.get("https://demo.nopcommerce.com/cart");
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);

        // Verify we are on Shopping Cart page
        Assert.assertTrue(cartPage.getPageTitle().contains("Shopping cart"), "Not on Shopping Cart page!");

        // Tick the Terms of Service checkbox
        cartPage.tickTermsOfService();

        // Optional pause for visual confirmation
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
