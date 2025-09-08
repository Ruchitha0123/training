package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PollPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By pollContainer = By.id("poll-block-1");
    private By pollOption1 = By.id("pollanswers-1");
    private By pollOption2 = By.id("pollanswers-2");
    private By pollOption3 = By.id("pollanswers-3");
    private By pollOption4 = By.id("pollanswers-4");
    private By voteButton = By.id("vote-poll-1");

    public PollPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void votePoll(String option) {
        // Scroll to poll container
        WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(pollContainer));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", container);
        sleep(500);

        By optionLocator;
        switch(option.toLowerCase()) {
            case "excellent": optionLocator = pollOption1; break;
            case "good": optionLocator = pollOption2; break;
            case "poor": optionLocator = pollOption3; break;
            case "very bad": optionLocator = pollOption4; break;
            default: throw new IllegalArgumentException("Invalid poll option: " + option);
        }

        // Wait for visibility and click using JS
        WebElement radio = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio);
        sleep(500);

        WebElement voteBtn = wait.until(ExpectedConditions.elementToBeClickable(voteButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", voteBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", voteBtn);

        // Wait after voting
        sleep(1500);
    }

    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
