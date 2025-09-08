package com.nopcommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BillingAddressPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By firstNameInput = By.id("BillingNewAddress_FirstName");
    private By continueButton = By.cssSelector("button.new-address-next-step-button");

    public BillingAddressPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Check if form is already filled
    private boolean isAlreadyFilled() {
        try {
            String firstName = driver.findElement(firstNameInput).getAttribute("value");
            return firstName != null && !firstName.isEmpty();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Fill billing details if not already filled
    public void fillBillingAddressIfNeeded(String firstName, String lastName, String email,
                                           String company, String country, String state, String city,
                                           String address1, String address2, String zip,
                                           String phone, String fax) {

        if (isAlreadyFilled()) {
            System.out.println("Billing address already filled, skipping form.");
        } else {
            driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys(firstName);
            driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys(lastName);
            driver.findElement(By.id("BillingNewAddress_Email")).sendKeys(email);
            driver.findElement(By.id("BillingNewAddress_Company")).sendKeys(company);

            Select countryDropdown = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
            countryDropdown.selectByVisibleText(country);

            try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

            Select stateDropdown = new Select(driver.findElement(By.id("BillingNewAddress_StateProvinceId")));
            stateDropdown.selectByVisibleText(state);

            driver.findElement(By.id("BillingNewAddress_City")).sendKeys(city);
            driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys(address1);
            driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys(address2);
            driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys(zip);
            driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys(phone);
            driver.findElement(By.id("BillingNewAddress_FaxNumber")).sendKeys(fax);
        }
    }

    // Click Continue button
    public void clickContinue() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
        continueBtn.click();
    }
}
