package ExcelData_TestNG;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFile {
    WebDriver driver;

    @Test(dataProvider="getdata", dataProviderClass = ExcelDataProvider.class)
    public void login(String userName, String password) throws InterruptedException {
        System.out.println("Launching the browser.");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        System.out.println("Logging with: " + userName + " / " + password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Enter username & password
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_MainContent_username"))).sendKeys(userName);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        Thread.sleep(2000);

        try {
            // Case 1: Successful login (check for "Web Orders" heading)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Web Orders']")));
            System.out.println("Login successful for user: " + userName);
        } catch (Exception e) {
            // Case 2: Failed login (check for error message)
            List<WebElement> errorMsgs = driver.findElements(By.id("ctl00_MainContent_status"));
            if (!errorMsgs.isEmpty()) {
                String errorMsg = errorMsgs.get(0).getText();
                System.out.println(" Login failed for user: " + userName + " | Message: " + errorMsg);
                Assert.fail("Login failed for user: " + userName + " | Message: " + errorMsg);
            } else {
                System.out.println("⚠ Login failed for user: " + userName + " | Unknown reason (no error msg)");
                Assert.fail("Login failed for user: " + userName + " | Unknown reason");
            }
        } finally {
            driver.quit();
        }
    }
}