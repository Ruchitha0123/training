package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    private By logoutLink = By.xpath("//li/a[@href='/logout' and contains(@class,'ico-logout')]");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
    }

    public void clickLogout() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        scrollToTop();
        sleep(500);
        link.click();
    }

    public void waitAfterLogout() {
        // wait 5 seconds after logout
        sleep(5000);
    }

    private void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0);");
    }

    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
