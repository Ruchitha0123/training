package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.BlogPage;
import org.testng.annotations.Test;

public class BlogTest extends Basetest {

    @Test(priority = 21)
    public void testBlogPage() {
        BlogPage blogPage = new BlogPage(driver);

        // Click Blog link
        blogPage.clickBlogLink();

        // Wait and simulate reading
        blogPage.waitForBlogPage();

        System.out.println("Blog page opened and read successfully.");
    }
}
