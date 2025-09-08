package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.VendorApplyDetailsPage;
import org.testng.annotations.Test;

public class VendorApplyDetailsTest extends Basetest {

    @Test(priority = 24)
    public void testVendorApplyForm() {
        VendorApplyDetailsPage vendorPage = new VendorApplyDetailsPage(driver);

        // Fill the vendor form without file upload
        vendorPage.fillVendorDetails(
                "Automations Vendor",
                "automationvendor@test1.com",
                "This is a test vendor description"
        );

        // Submit the vendor form
        vendorPage.clickSubmit();

        System.out.println("Vendor details submitted successfully.");
    }
}
