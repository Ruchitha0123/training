package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    private By loginLink = By.className("ico-login");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By loginBtn = By.xpath("//button[@class='button-1 login-button']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigate to login page
    public void openLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    // Perform login
    public void login(String user, String pass) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        emailField.clear();
        emailField.sendKeys(user);

        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passField.clear();
        passField.sendKeys(pass);

        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }
}
