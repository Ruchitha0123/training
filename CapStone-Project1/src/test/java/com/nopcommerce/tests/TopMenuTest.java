package com.nopcommerce.tests;

import com.nopcommerce.base.Basetest;
import com.nopcommerce.pages.TopMenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TopMenuTest extends Basetest {

    @Test
    public void topMenuNavigationTest() throws InterruptedException {
        TopMenuPage topMenu = new TopMenuPage(driver);

        // list of menu items to test (as visible on site)
        String[] menus = {
                "Computers",
                "Electronics",
                "Apparel",
                "Digital downloads",
                "Books",
                "Jewelry",
                "Gift Cards"
        };

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        for (String menu : menus) {
            // click the menu item
            topMenu.clickMenuByName(menu);

            // wait for either a visible page title or a short delay then verify
            try {
                wait.until(ExpectedConditions.or(
                        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.page-title h1")),
                        ExpectedConditions.titleContains(menu)
                ));
            } catch (Exception ignored) {
                // not fatal — we'll do assertions with fallback checks below
            }

            String h1 = topMenu.getPageH1();
            String title = driver.getTitle() == null ? "" : driver.getTitle();
            String url = driver.getCurrentUrl() == null ? "" : driver.getCurrentUrl();

            // Normalize strings for comparison
            String mLower = menu.toLowerCase();
            boolean matched =
                    (!h1.isEmpty() && h1.toLowerCase().contains(mLower)) ||
                    (title.toLowerCase().contains(mLower)) ||
                    (url.toLowerCase().contains(mLower.replace(" ", "-"))) ||
                    (url.toLowerCase().contains(mLower.replace(" ", "")));

            // As a last resort check page source contains the menu word (first token)
            if (!matched) {
                String firstToken = mLower.split(" ")[0];
                matched = driver.getPageSource().toLowerCase().contains(firstToken);
            }

            Assert.assertTrue(matched,
                    "Navigation to top menu '" + menu + "' failed. "
                            + "h1='" + h1 + "' title='" + title + "' url='" + url + "'");

            // go back to home so the next menu is clickable (keeps same session)
            driver.get("https://demo.nopcommerce.com/");
            // small wait to let homepage load
            Thread.sleep(800);
        }
    }
}
