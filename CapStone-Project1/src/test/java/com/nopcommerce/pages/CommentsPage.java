package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommentsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By commentTitleInput = By.id("AddNewComment_CommentTitle");
    private By commentTextInput = By.id("AddNewComment_CommentText");
    private By submitCommentButton = By.cssSelector("button[name='add-comment']");
    private By commentsSection = By.cssSelector("div.comment-list");
    private By footerSection = By.cssSelector("div.footer");

    public CommentsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void fillComment(String title, String text) {
        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(commentTitleInput));
        scrollToElement(titleInput);
        sleep(500);
        titleInput.clear();
        titleInput.sendKeys(title);

        WebElement textInput = wait.until(ExpectedConditions.visibilityOfElementLocated(commentTextInput));
        textInput.clear();
        textInput.sendKeys(text);
        sleep(500);
    }

    public void submitComment() {
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(submitCommentButton));
        scrollToElement(submitBtn);
        sleep(500);
        submitBtn.click();
        sleep(1000);
    }

    public void scrollToComments() {
        WebElement comments = wait.until(ExpectedConditions.visibilityOfElementLocated(commentsSection));
        scrollToElement(comments);
        sleep(1000);
    }

    public void scrollToFooter() {
        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(footerSection));
        scrollToElement(footer);
        sleep(1000);
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
