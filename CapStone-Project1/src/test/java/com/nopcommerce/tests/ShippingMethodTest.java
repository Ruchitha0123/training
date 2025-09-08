package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.ShippingMethodPage;
import org.testng.annotations.Test;

public class ShippingMethodTest extends Basetest {

    @Test(priority = 7)
    public void testSelectShippingMethod() {
        ShippingMethodPage shippingPage = new ShippingMethodPage(driver);

        // Select Ground shipping (index 0)
        shippingPage.selectShippingOption(0);

        // Click Continue
        shippingPage.clickContinue();
    }
}
