package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    // Locators
    By registerLink = By.linkText("Register");
    By genderMale = By.id("gender-male");
    By genderFemale = By.id("gender-female");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By email = By.id("Email");
    By password = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");
    By successMsg = By.className("result");
    By logoutLink = By.className("ico-logout"); // new locator

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void openRegisterPage() {
        driver.findElement(registerLink).click();
    }

    public void register(String fName, String lName, String mail, String pass) {
        driver.findElement(genderFemale).click(); // choose gender
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        driver.findElement(registerButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }

    public void logout() {
        driver.findElement(logoutLink).click();
    }
}
