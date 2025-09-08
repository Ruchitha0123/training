package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlogPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By blogLink = By.xpath("//ul[@class='list']/li/a[text()='Blog']");
    private By blogContainer = By.cssSelector("div.blog-posts"); // adjust if actual container is different

    public BlogPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickBlogLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(blogLink));
        scrollToElement(link);
        sleep(500);
        link.click();
    }

    public void waitForBlogPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(blogContainer));
        sleep(1000); // light sleep to "read" the blog
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
