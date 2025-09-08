package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.PaymentMethodPage;
import org.testng.annotations.Test;

public class PaymentMethodTest extends Basetest {

    @Test(priority = 8)
    public void testSelectCreditCardAndContinue() {
        PaymentMethodPage paymentPage = new PaymentMethodPage(driver);

        // Select Credit Card payment method
        paymentPage.selectPaymentMethod("Credit Card");

        // Click Continue and wait for next page
        paymentPage.clickContinue();
    }
}
