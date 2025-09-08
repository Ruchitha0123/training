package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.ContactUsPage;
import org.testng.annotations.Test;

public class ContactUsTest extends Basetest {

    @Test(priority = 20)
    public void testContactUsForm() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        // Click Contact Us link
        contactUsPage.clickContactUs();

        // Fill contact form
        contactUsPage.fillContactForm(
                "AutomationUser Test",
                "ganeshtest@gmail.com",
                "This is a test enquiry from automation script."
        );

        // Submit form
        contactUsPage.submitForm();

        System.out.println("Contact Us form submitted successfully.");
    }
}
