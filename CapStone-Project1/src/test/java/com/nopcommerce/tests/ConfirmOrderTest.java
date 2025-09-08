package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.ConfirmOrderPage;
import org.testng.annotations.Test;

public class ConfirmOrderTest extends Basetest {

    @Test(priority = 10)
    public void testConfirmOrderAndContinue() {
        ConfirmOrderPage confirmPage = new ConfirmOrderPage(driver);

        // Click Confirm and wait
        confirmPage.clickConfirm();

        // Optional: Verify order confirmation message
        String message = confirmPage.getOrderConfirmationMessage();
        System.out.println("Order confirmation: " + message);

        // Click Continue to go to homepage
        confirmPage.clickContinueAfterOrder();
    }
}
