package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.PaymentInformationPage;
import org.testng.annotations.Test;

public class PaymentInformationTest extends Basetest {

    @Test(priority = 9)
    public void testFillCreditCardPaymentInfo() {
        PaymentInformationPage paymentInfoPage = new PaymentInformationPage(driver);

        // Wait for form fields after selecting credit card in previous step
        paymentInfoPage.waitForPaymentFields();

        // Fill credit card information
        paymentInfoPage.fillPaymentInformation(
                "Visa",
                "Automation User",
                "4111111111111111",
                "01",
                "2026",
                "123"
        );

        // Click Continue
        paymentInfoPage.clickContinue();
    }
}
