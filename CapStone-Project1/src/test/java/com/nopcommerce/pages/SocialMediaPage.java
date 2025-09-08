package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class SocialMediaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By facebookLink = By.cssSelector("ul.networks li.facebook a");
    private By twitterLink = By.cssSelector("ul.networks li.twitter a");
//    private By rssLink = By.cssSelector("ul.networks li.rss a");
    private By youtubeLink = By.cssSelector("ul.networks li.youtube a");
    private By instagramLink = By.cssSelector("ul.networks li.instagram a");

    public SocialMediaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Generic method to click a social media link
    private void clickSocialLink(By locator) {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(locator));

        String mainWindow = driver.getWindowHandle();
        link.click();
        sleep(1000); // wait for new tab/window to open

        // Switch to new window/tab
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                sleep(1500); // wait to load page
                driver.close(); // close new tab/window
                break;
            }
        }

        driver.switchTo().window(mainWindow);
        sleep(500); // wait before next action
    }

    public void clickFacebook() { clickSocialLink(facebookLink); }
    public void clickTwitter() { clickSocialLink(twitterLink); }
//    public void clickRSS() { clickSocialLink(rssLink); }
    public void clickYouTube() { clickSocialLink(youtubeLink); }
    public void clickInstagram() { clickSocialLink(instagramLink); }

    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
