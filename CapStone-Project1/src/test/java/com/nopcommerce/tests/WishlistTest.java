package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.WishlistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTest extends Basetest {

    @Test(priority = 3)
    public void testOpenWishlistPage() {
        WishlistPage wishlistPage = new WishlistPage(driver);

        // Open Wishlist
        wishlistPage.openWishlist();

        // Verify Wishlist page title
        String pageTitle = wishlistPage.getPageTitle();
        Assert.assertTrue(pageTitle.equalsIgnoreCase("Wishlist"),
                "Wishlist page not opened correctly! Got: " + pageTitle);

        // Optional: pause for visual confirmation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
