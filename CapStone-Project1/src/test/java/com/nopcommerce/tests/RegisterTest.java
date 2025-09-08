package com.nopcommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.RegisterPage;
import com.nopcommerce.utils.Excelutil;

public class RegisterTest extends Basetest {

    @Test
    public void registerWithValidData() throws Exception {
        RegisterPage register = new RegisterPage(driver);
        register.openRegisterPage();

        // Fetch test data from Excel (Sheet "Register")
        String fName = Excelutil.getData("Sheet2", 1, 0);
        String lName = Excelutil.getData("Sheet2", 1, 1);
        String email = Excelutil.getData("Sheet2", 1, 2);
        String pass = Excelutil.getData("Sheet2", 1, 3);

        register.register(fName, lName, email, pass);

        // Assertion
        Assert.assertTrue(register.getSuccessMessage().contains("Your registration completed"),
                "Registration failed with valid data!");
    }
}
