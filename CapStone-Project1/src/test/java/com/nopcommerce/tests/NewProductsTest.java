package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.NewProductsPage;
import org.testng.annotations.Test;

public class NewProductsTest extends Basetest {

    @Test(priority = 22)
    public void testNewProductsPage() {
        NewProductsPage newProductsPage = new NewProductsPage(driver);

        // Click New Products link
        newProductsPage.clickNewProductsLink();

        // Wait and simulate viewing products
        newProductsPage.waitForNewProductsPage();

        System.out.println("New Products page opened and viewed successfully.");
    }
}
