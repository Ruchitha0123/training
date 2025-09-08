package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.LogoutPage;
import org.testng.annotations.Test;

public class LogoutTest extends Basetest {

    @Test(priority = 26)
    public void testLogout() {
        LogoutPage logoutPage = new LogoutPage(driver);

        // Click on Logout
        logoutPage.clickLogout();

        // Wait 5 seconds after logout
        logoutPage.waitAfterLogout();

        System.out.println("Logout performed and waited successfully.");
    }
}
