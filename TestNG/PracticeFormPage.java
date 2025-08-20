package TestNG;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeFormPage {
WebDriver driver;
WebDriverWait wait;

public PracticeFormPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}

By firstNameInput = By.id("firstName");
By lastNameInput = By.id("lastName");
By emailInput = By.id("userEmail");
By genderFemaleRadio = By.xpath("//label[@for='gender-radio-2']");
By mobileInput = By.id("userNumber");
By dateOfBirthInput = By.id("dateOfBirthInput");
By subjectsInput = By.id("subjectsInput");
By hobbiesReadingCheckbox = By.xpath("//label[@for='hobbies-checkbox-2']");
By currentAddressInput = By.id("currentAddress");
By stateDropdownInput = By.id("react-select-3-input");
By cityDropdownInput = By.id("react-select-4-input");
By submitButton = By.id("submit");

public void enterFirstName(String firstName) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).sendKeys(firstName);
}

public void enterLastName(String lastName) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput)).sendKeys(lastName);
}

public void enterEmail(String email) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
}

public void selectGenderFemale() {
    WebElement genderFemaleElem = wait.until(ExpectedConditions.elementToBeClickable(genderFemaleRadio));
    scrollToElement(genderFemaleElem);
    genderFemaleElem.click();
}

public void enterMobile(String mobile) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(mobileInput)).sendKeys(mobile);
}

public void enterDateOfBirth(String date) {
    WebElement dobInput = wait.until(ExpectedConditions.elementToBeClickable(dateOfBirthInput));
    dobInput.sendKeys(Keys.CONTROL + "a"); // select all
    dobInput.sendKeys(date);
    dobInput.sendKeys(Keys.ENTER);
}

public void enterSubjects(String subject) {
    WebElement subjectElem = wait.until(ExpectedConditions.visibilityOfElementLocated(subjectsInput));
    subjectElem.sendKeys(subject);
    subjectElem.sendKeys(Keys.ENTER);
}

public void selectHobbiesReading() {
    WebElement hobbyCheckbox = wait.until(ExpectedConditions.elementToBeClickable(hobbiesReadingCheckbox));
    scrollToElement(hobbyCheckbox);
    hobbyCheckbox.click();
}

public void enterCurrentAddress(String address) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(currentAddressInput)).sendKeys(address);
}

public void selectState(String state) {
    WebElement stateElem = wait.until(ExpectedConditions.visibilityOfElementLocated(stateDropdownInput));
    stateElem.sendKeys(state);
    stateElem.sendKeys(Keys.ENTER);
}

public void selectCity(String city) {
    WebElement cityElem = wait.until(ExpectedConditions.visibilityOfElementLocated(cityDropdownInput));
    cityElem.sendKeys(city);
    cityElem.sendKeys(Keys.ENTER);
}

public void clickSubmit() {
    WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
    scrollToElement(submitBtn);
    submitBtn.click();
}

// Helper methods
private void scrollToElement(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
}
}
