package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecentlyViewedProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    private By recentlyViewedLink = By.xpath("//li/a[@href='/recentlyviewedproducts']");
    private By pageTitle = By.xpath("//div[@class='page-title']/h1[text()='Recently viewed products']");

    public RecentlyViewedProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
    }

    public void clickRecentlyViewedLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(recentlyViewedLink));
        scrollToElement(link);
        sleep(500);
        link.click();
    }

    public void waitForRecentlyViewedPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        sleep(1000); // simulate reading the page
    }

    private void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
