package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By productName = By.cssSelector("div.product-name h1");
    private By productPrice = By.cssSelector("div.product-price span");
    private By addToCartButton = By.cssSelector("button.add-to-cart-button");
    private By addToWishlistButton = By.cssSelector("button.add-to-wishlist-button");
    private By successMessage = By.cssSelector("div.bar-notification p.content");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public String getProductPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).getText();
    }

    private void scrollAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void addToCart() {
        scrollAndClick(addToCartButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    }

    public void addToWishlist() {
        scrollAndClick(addToWishlistButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }
}
