package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By checkoutHeader = By.cssSelector("div.page-title h1");
    private By termsOfServiceCheckbox = By.id("termsofservice");
    private By checkoutButton = By.id("checkout");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getCheckoutPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutHeader)).getText();
    }

    public void agreeToTerms() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(termsOfServiceCheckbox));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void clickCheckoutButton() {
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutBtn.click();
    }
}
