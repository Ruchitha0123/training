package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NewsletterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By emailInput = By.id("newsletter-email");
    private By subscribeButton = By.id("newsletter-subscribe-button");

    public NewsletterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void subscribeNewsletter(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailField);
        emailField.clear();
        emailField.sendKeys(email);
        sleep(500);

        WebElement subscribeBtn = wait.until(ExpectedConditions.elementToBeClickable(subscribeButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", subscribeBtn);

        // Wait a little to let subscription complete
        sleep(1000);
    }

    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
