package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CurrencyPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By currencyDropdown = By.id("customerCurrency");

    public CurrencyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void selectCurrency(String currency) {
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(currencyDropdown));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
        sleep(500);

        Select select = new Select(dropdownElement);
        select.selectByVisibleText(currency);
        sleep(1000); // wait for page reload after selection
    }

    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
