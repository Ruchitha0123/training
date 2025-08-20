package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticeFormTest {
WebDriver driver;
PracticeFormPage formPage;

@BeforeClass
public void setup() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://demoqa.com/automation-practice-form");
    formPage = new PracticeFormPage(driver);
}

@Test
public void fillFormAndSubmit() {
    formPage.enterFirstName("Ruchitha");
    formPage.enterLastName("Reddy");
    formPage.enterEmail("Ruchi@example.com");
    formPage.selectGenderFemale();
    formPage.enterMobile("9876543210");
    formPage.enterDateOfBirth("01 Oct 2003");
    formPage.enterSubjects("English");
    formPage.selectHobbiesReading();
    formPage.enterCurrentAddress("Main Street, Hyderabad");
    formPage.selectState("NCR");   // use values that exist on site (ex: NCR, Haryana, Rajasthan, Uttar Pradesh)
    formPage.selectCity("Delhi");  // use valid city for chosen state (ex: Delhi for NCR)
    formPage.clickSubmit();

    // ✅ Assertion: check modal popup is displayed
    boolean modalVisible = driver.getPageSource().contains("Thanks for submitting the form");
    Assert.assertTrue(modalVisible, "Form submission failed!");
}

@AfterClass
public void teardown() {
    if (driver != null) {
        driver.quit();
    }
}
}
