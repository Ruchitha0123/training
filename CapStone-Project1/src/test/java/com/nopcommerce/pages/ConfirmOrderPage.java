package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ConfirmOrderPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By confirmButton = By.cssSelector("button.confirm-order-next-step-button");
    private By pleaseWaitSpan = By.id("confirm-order-please-wait");
    private By continueButton = By.cssSelector("button.order-completed-continue-button");

    public ConfirmOrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    // Click Confirm order button
    public void clickConfirm() {
        WebElement confirmBtn = wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmBtn);
        confirmBtn.click();

        // Wait until "Submitting order" message disappears
        try {
            Thread.sleep(3000); // wait 3 seconds for confirmation process
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(pleaseWaitSpan));
    }

    // Click Continue button on Order Completed page
    public void clickContinueAfterOrder() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
        continueBtn.click();

        // Wait a bit for homepage to load
        try {
            Thread.sleep(3000); // wait 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Optional: get order confirmation message
    public String getOrderConfirmationMessage() {
        try {
            By orderSuccessMsg = By.cssSelector("div.section.order-completed div.title strong");
            return wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessMsg)).getText();
        } catch (TimeoutException e) {
            return "Order confirmation message not found!";
        }
    }
}
