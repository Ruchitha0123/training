package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.BillingAddressPage;
import org.testng.annotations.Test;

public class BillingAddressTest extends Basetest {

    @Test(priority = 6)
    public void testFillBillingAddressIfNeeded() {
        BillingAddressPage billingPage = new BillingAddressPage(driver);

        // Fill billing info only if not already filled
        billingPage.fillBillingAddressIfNeeded(
                "AutomationUser", "Test", "ruchithareddy@gmail.com",
                "MyCompany", "United States of America", "California", "Los Angeles",
                "123 Main St", "Suite 100", "90001", "1234567890", "123456789"
        );

        // Click Continue
        billingPage.clickContinue();
    }
}
