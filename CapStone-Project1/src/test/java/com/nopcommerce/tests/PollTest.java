package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.PollPage;
import org.testng.annotations.Test;

public class PollTest extends Basetest {

    @Test(priority = 13)
    public void testVotePoll() {
        PollPage pollPage = new PollPage(driver);

        // Vote for "Excellent"
        pollPage.votePoll("Excellent");

        // Optional sleep to observe results
        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
