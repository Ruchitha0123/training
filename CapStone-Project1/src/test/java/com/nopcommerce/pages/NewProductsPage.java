package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By newProductsLink = By.xpath("//ul[@class='list']/li/a[text()='New products']");
    private By productsContainer = By.cssSelector("div.product-grid"); // adjust selector if different

    public NewProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickNewProductsLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(newProductsLink));
        scrollToElement(link);
        sleep(500);
        link.click();
    }

    public void waitForNewProductsPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsContainer));
        sleep(1000); // light sleep to simulate reading products
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
