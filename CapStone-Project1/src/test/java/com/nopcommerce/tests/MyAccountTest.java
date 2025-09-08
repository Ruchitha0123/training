package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.MyAccountPage;
import org.testng.annotations.Test;

public class MyAccountTest extends Basetest {

    @Test(priority = 11)
    public void testMyAccountSaveAndGoHome() {
        MyAccountPage accountPage = new MyAccountPage(driver);

        // Click My Account
        accountPage.clickMyAccount();

        // Click Save
        accountPage.clickSave();

        // Click site logo to go to homepage
        accountPage.clickLogo();
    }
}
