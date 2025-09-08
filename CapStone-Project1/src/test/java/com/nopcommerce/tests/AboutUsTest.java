package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.AboutUsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutUsTest extends Basetest {

    @Test(priority = 19)
    public void testClickAboutUs() {
        AboutUsPage aboutUsPage = new AboutUsPage(driver);

        // Click About Us link
        aboutUsPage.clickAboutUs();

        // Verify About Us page title
        String title = aboutUsPage.getPageTitle();
        System.out.println("Navigated to page: " + title);
        Assert.assertEquals(title, "About us"); // Adjust if actual page title differs
    }
}
