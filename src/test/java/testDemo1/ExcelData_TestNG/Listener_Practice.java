package ExcelData_TestNG;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExcelData_TestNG.MyListener_Report.class)   // ✅ Use MyListener_Report to generate ExtentReport
public class Listener_Practice {
    public WebDriver driver;

    @BeforeClass
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // ✅ PASS Case
    @Test(priority = 1)
    public void logIn() {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Enter valid credentials
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_username")))
            .sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        // Click Login button
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        // Validate login success
        String title = driver.getTitle();
        Assert.assertEquals(title, "Web Orders", "Login Failed!");
    }

    // ❌ FAIL Case
    @Test(priority = 2)
    public void checkTitleName() {
        String expectedName = "Invalid Title";   // intentionally wrong
        String actualName = driver.getTitle();
        Assert.assertEquals(actualName, expectedName, "Title mismatch - This will FAIL");
    }

    // ⏭️ SKIP Case
    @Test(priority = 3)
    public void skipTestExample() {
        System.out.println("This test will be skipped intentionally.");
        throw new SkipException("Skipping this test for demo purposes.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
