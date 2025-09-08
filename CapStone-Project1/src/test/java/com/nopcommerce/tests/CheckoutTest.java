package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends Basetest {

    @Test(priority = 5)
    public void testProceedToCheckout() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Agree to terms and click checkout
        checkoutPage.agreeToTerms();
        checkoutPage.clickCheckoutButton();

        String title = checkoutPage.getCheckoutPageTitle();
        Assert.assertTrue(title.contains("Checkout"), "Checkout page not opened correctly! Got: " + title);
    }
}
