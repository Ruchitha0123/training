package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentInformationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By creditCardTypeSelect = By.id("CreditCardType");
    private By cardholderNameInput = By.id("CardholderName");
    private By cardNumberInput = By.id("CardNumber");
    private By expireMonthSelect = By.id("ExpireMonth");
    private By expireYearSelect = By.id("ExpireYear");
    private By cardCodeInput = By.id("CardCode");
    private By continueButton = By.cssSelector("button.payment-info-next-step-button");

    public PaymentInformationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    // Wait until all credit card fields are ready
    public void waitForPaymentFields() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardTypeSelect));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardholderNameInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(expireMonthSelect));
        wait.until(ExpectedConditions.visibilityOfElementLocated(expireYearSelect));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardCodeInput));
    }

    // Fill payment information
    public void fillPaymentInformation(String cardType, String cardholderName, String cardNumber,
                                       String expireMonth, String expireYear, String cardCode) {

        waitForPaymentFields(); // Ensure fields are ready

        new Select(driver.findElement(creditCardTypeSelect)).selectByVisibleText(cardType);

        WebElement nameField = driver.findElement(cardholderNameInput);
        nameField.clear();
        nameField.sendKeys(cardholderName);

        WebElement numberField = driver.findElement(cardNumberInput);
        numberField.clear();
        numberField.sendKeys(cardNumber);

        new Select(driver.findElement(expireMonthSelect)).selectByVisibleText(expireMonth);
        new Select(driver.findElement(expireYearSelect)).selectByVisibleText(expireYear);

        WebElement codeField = driver.findElement(cardCodeInput);
        codeField.clear();
        codeField.sendKeys(cardCode);
    }

    // Click continue
    public void clickContinue() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
        continueBtn.click();

        // Wait until next step is loaded (Confirm Order)
        wait.until(ExpectedConditions.urlContains("checkout"));
    }
}
