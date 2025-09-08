package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutUsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By aboutUsLink = By.xpath("//ul[@class='list']/li/a[text()='About us']");
    private By pageTitle = By.cssSelector("div.page-title h1"); // Assuming About Us page has a title

    public AboutUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickAboutUs() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(aboutUsLink));
        scrollToElement(link);
        sleep(500);
        link.click();
    }

    public String getPageTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return title.getText();
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
