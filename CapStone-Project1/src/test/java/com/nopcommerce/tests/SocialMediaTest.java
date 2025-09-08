package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.SocialMediaPage;
import org.testng.annotations.Test;

public class SocialMediaTest extends Basetest {

    @Test(priority = 14)
    public void testSocialMediaLinks() {
        SocialMediaPage socialPage = new SocialMediaPage(driver);

        // Check each social media link
        socialPage.clickFacebook();
        socialPage.clickTwitter();
//        socialPage.clickRSS();
        socialPage.clickYouTube();
        socialPage.clickInstagram();

        // Optional wait to finish
        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
