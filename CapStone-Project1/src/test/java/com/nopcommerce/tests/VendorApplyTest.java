package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.VendorApplyPage;
import org.testng.annotations.Test;

public class VendorApplyTest extends Basetest {

    @Test(priority = 23)
    public void testVendorApplyPage() {
        VendorApplyPage vendorPage = new VendorApplyPage(driver);

        // Click the Apply for vendor account link
        vendorPage.clickVendorApplyLink();

        // Wait and simulate viewing the vendor apply page
        vendorPage.waitForVendorApplyPage();

        System.out.println("Vendor Apply page opened and viewed successfully.");
    }
}
