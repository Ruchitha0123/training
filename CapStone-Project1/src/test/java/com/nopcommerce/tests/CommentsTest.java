package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.CommentsPage;
import org.testng.annotations.Test;

public class CommentsTest extends Basetest {

    @Test(priority = 18)
    public void testAddCommentAndScroll() {
        CommentsPage commentsPage = new CommentsPage(driver);

        // Fill the comment fields
        commentsPage.fillComment("Automated Test Comment", "This is a test comment added by automation.");

        // Click submit comment
        commentsPage.submitComment();

        // Scroll to comments section
        commentsPage.scrollToComments();

        // Scroll further down to footer
        commentsPage.scrollToFooter();
    }
}
