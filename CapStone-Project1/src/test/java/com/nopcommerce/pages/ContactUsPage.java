package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By contactUsLink = By.xpath("//ul[@class='list']/li/a[text()='Contact us']");
    private By fullNameInput = By.id("FullName");
    private By emailInput = By.id("Email");
    private By enquiryTextArea = By.id("Enquiry");
    private By submitButton = By.cssSelector("button.button-1.contact-us-button");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickContactUs() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(contactUsLink));
        scrollToElement(link);
        sleep(500);
        link.click();
    }

    public void fillContactForm(String name, String email, String enquiry) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameInput));
        WebElement emailField = driver.findElement(emailInput);
        WebElement enquiryField = driver.findElement(enquiryTextArea);

        scrollToElement(nameField);
        sleep(300);
        nameField.clear();
        nameField.sendKeys(name);

        emailField.clear();
        emailField.sendKeys(email);

        enquiryField.clear();
        enquiryField.sendKeys(enquiry);
    }

    public void submitForm() {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        scrollToElement(submit);
        sleep(300);
        submit.click();
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
