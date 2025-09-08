package com.nopcommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.LoginPage;

import com.nopcommerce.utils.Excelutil;

public class LoginTest extends Basetest {

    @Test
    public void loginWithValidData() throws Exception {
        LoginPage login = new LoginPage(driver);
        login.openLoginPage();

        // Fetch data from Excel sheet "Sheet1"
        String email = Excelutil.getData("Sheet1", 2, 0);
        String pass = Excelutil.getData("Sheet1", 2, 1);

        login.login(email, pass);

        // Wait for 5 seconds to allow page to load
        Thread.sleep(5000);

        // Assertion: user should see "My account"
        Assert.assertTrue(driver.getPageSource().contains("My account"),
                "Login failed with valid credentials!");
    }
}
