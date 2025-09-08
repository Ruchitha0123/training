package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VendorApplyPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By vendorApplyLink = By.xpath("//ul[@class='list']/li/a[text()='Apply for vendor account']");
    private By applyForm = By.cssSelector("form#apply-vendor-form"); // adjust if needed

    public VendorApplyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickVendorApplyLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(vendorApplyLink));
        scrollToElement(link);
        sleep(500);
        link.click();
    }

    public void waitForVendorApplyPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(applyForm));
        sleep(1000); // light sleep to simulate reading/viewing the form
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
