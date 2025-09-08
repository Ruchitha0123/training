package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ShippingMethodPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By shippingOptionRadioButtons = By.name("shippingoption");
    private By continueButton = By.cssSelector("button.shipping-method-next-step-button");

    public ShippingMethodPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Select shipping option by index (0-based)
    public void selectShippingOption(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(shippingOptionRadioButtons));
        java.util.List<WebElement> options = driver.findElements(shippingOptionRadioButtons);

        if (index < 0 || index >= options.size()) {
            throw new IllegalArgumentException("Invalid shipping option index: " + index);
        }

        WebElement option = options.get(index);
        if (!option.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
            option.click();
        }
    }

    // Click Continue button
    public void clickContinue() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
        continueBtn.click();
    }
}
