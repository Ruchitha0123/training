package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentMethodPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By paymentOption1 = By.id("paymentmethod_0"); // Check / Money Order
    private By paymentOption2 = By.id("paymentmethod_1"); // Credit Card
    private By continueButton = By.cssSelector("button.button-1.payment-method-next-step-button");

    public PaymentMethodPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Select payment method if not already selected
    public void selectPaymentMethod(String method) {
        WebElement option;
        if (method.equalsIgnoreCase("Check / Money Order")) {
            option = wait.until(ExpectedConditions.elementToBeClickable(paymentOption1));
        } else {
            option = wait.until(ExpectedConditions.elementToBeClickable(paymentOption2));
        }

        if (!option.isSelected()) {
            option.click();
        }
    }

    // Click Continue button
    public void clickContinue() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
        continueBtn.click();

        // Wait after clicking continue for page to load
        try {
            Thread.sleep(2000); // 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
