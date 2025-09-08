package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.NewsPage;
import org.testng.annotations.Test;

public class NewsTest extends Basetest {

    @Test(priority = 16)
    public void testNewsComment() {
        NewsPage newsPage = new NewsPage(driver);

        // Scroll and click "View News Archive"
        newsPage.clickViewNewsArchive();

        // Open the first news details
        newsPage.openFirstNewsDetails();

        // Add a comment with title and text
        newsPage.addComment("Automation Test Title", "This is an automated comment for testing.");
    }
}
