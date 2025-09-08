package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MyAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By myAccountLink = By.cssSelector("a.ico-account");
    private By saveButton = By.id("save-info-button");
    private By siteLogo = By.cssSelector("img[alt='nopCommerce demo store']");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Click My Account link
    public void clickMyAccount() {
        WebElement accountLink = wait.until(ExpectedConditions.presenceOfElementLocated(myAccountLink));
        scrollToElement(accountLink);
        clickElement(accountLink);
        sleep(2000);
    }

    // Click Save button
    public void clickSave() {
        WebElement saveBtn = wait.until(ExpectedConditions.presenceOfElementLocated(saveButton));
        scrollToElement(saveBtn);
        clickElement(saveBtn);
        sleep(2000);
    }

    // Click site logo
    public void clickLogo() {
        WebElement logo = wait.until(ExpectedConditions.presenceOfElementLocated(siteLogo));
        scrollToElement(logo);
        clickElement(logo);
        sleep(2000);
    }

    // Utility: scroll to element
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", element);
    }

    // Utility: click with JS fallback
    private void clickElement(WebElement element) throws ElementClickInterceptedException {
        try {
            element.click();
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    // Utility: thread sleep
    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
