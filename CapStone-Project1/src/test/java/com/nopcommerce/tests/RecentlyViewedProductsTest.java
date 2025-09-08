package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.RecentlyViewedProductsPage;
import org.testng.annotations.Test;

public class RecentlyViewedProductsTest extends Basetest {

    @Test(priority = 25)
    public void testRecentlyViewedProductsPage() {
        RecentlyViewedProductsPage recentlyViewedPage = new RecentlyViewedProductsPage(driver);

        // Click Recently viewed products link
        recentlyViewedPage.clickRecentlyViewedLink();

        // Wait and confirm page is loaded
        recentlyViewedPage.waitForRecentlyViewedPage();

        System.out.println("Recently viewed products page opened successfully.");
    }
}
