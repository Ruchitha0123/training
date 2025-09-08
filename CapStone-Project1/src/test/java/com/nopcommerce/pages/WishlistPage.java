package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WishlistPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By wishlistLink = By.cssSelector("a.ico-wishlist");
    private By wishlistHeader = By.cssSelector("div.page-title h1");

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Open Wishlist page
    public void openWishlist() {
        WebElement wishlist = wait.until(ExpectedConditions.elementToBeClickable(wishlistLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wishlist);
        wishlist.click();

        // Wait until Wishlist page header is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(wishlistHeader));
    }

    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(wishlistHeader)).getText();
    }
}
