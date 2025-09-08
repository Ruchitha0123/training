package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NewsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By viewAllNews = By.cssSelector("div.view-all > a");
    private By firstNewsDetails = By.cssSelector("div.buttons > a.read-more");
    private By commentTitleInput = By.id("AddNewComment_CommentTitle");
    private By commentTextInput = By.id("AddNewComment_CommentText");
    private By submitCommentButton = By.name("add-comment"); // if there is a submit button with name add-comment, adjust if needed

    public NewsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickViewNewsArchive() {
        WebElement viewAll = wait.until(ExpectedConditions.elementToBeClickable(viewAllNews));
        scrollToElement(viewAll);
        sleep(500);
        viewAll.click();
        sleep(1000);
    }

    public void openFirstNewsDetails() {
        WebElement newsDetails = wait.until(ExpectedConditions.elementToBeClickable(firstNewsDetails));
        scrollToElement(newsDetails);
        sleep(500);
        newsDetails.click();
        sleep(1000);
    }

    public void addComment(String title, String comment) {
        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(commentTitleInput));
        scrollToElement(titleInput);
        sleep(500);
        titleInput.clear();
        titleInput.sendKeys(title);

        WebElement textInput = wait.until(ExpectedConditions.visibilityOfElementLocated(commentTextInput));
        textInput.clear();
        textInput.sendKeys(comment);

        // Submit button if present, else remove this line
        // driver.findElement(submitCommentButton).click();
        sleep(500);
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
