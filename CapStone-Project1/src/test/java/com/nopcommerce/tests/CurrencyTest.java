package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.CurrencyPage;
import org.testng.annotations.Test;

public class CurrencyTest extends Basetest {

    @Test(priority = 15)
    public void testSelectCurrency() {
        CurrencyPage currencyPage = new CurrencyPage(driver);

        // Scroll and select Euro
        currencyPage.selectCurrency("Euro");

        // Scroll and switch back to US Dollar
        currencyPage.selectCurrency("US Dollar");
    }
}
