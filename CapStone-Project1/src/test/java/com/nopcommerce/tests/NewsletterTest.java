package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.NewsletterPage;
import org.testng.annotations.Test;

public class NewsletterTest extends Basetest {

    @Test(priority = 14)
    public void testSubscribeNewsletter() {
        NewsletterPage newsletterPage = new NewsletterPage(driver);

        // Subscribe with a test email
        newsletterPage.subscribeNewsletter("automationtest@example.com");

        // Optional sleep to observe results
        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
