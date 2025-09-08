package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VendorApplyDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    private By nameInput = By.id("Name");
    private By emailInput = By.id("Email");
    private By descriptionTextarea = By.id("Description");
    private By submitButton = By.id("apply-vendor");

    public VendorApplyDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
    }

    public void fillVendorDetails(String name, String email, String description) {
        WebElement nameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        scrollToElement(nameElem);
        sleep(500);
        nameElem.clear();
        nameElem.sendKeys(name);

        WebElement emailElem = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        scrollToElement(emailElem);
        sleep(500);
        emailElem.clear();
        emailElem.sendKeys(email);

        WebElement descElem = wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionTextarea));
        scrollToElement(descElem);
        sleep(500);
        descElem.clear();
        descElem.sendKeys(description);

        sleep(500); // light wait before submit
    }

    public void clickSubmit() {
        WebElement submitElem = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        scrollToElement(submitElem);
        sleep(500);
        submitElem.click();
    }

    private void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
