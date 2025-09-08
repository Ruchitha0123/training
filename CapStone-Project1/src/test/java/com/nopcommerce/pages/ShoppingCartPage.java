package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ShoppingCartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By shoppingCartHeader = By.cssSelector("div.page-title h1");
    private By termsCheckbox = By.id("termsofservice"); // Terms of Service checkbox

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Get page title
    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartHeader)).getText();
    }

    // Tick Terms of Service checkbox
    public void tickTermsOfService() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox));
        if (!checkbox.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
            checkbox.click();
        }
    }
}
