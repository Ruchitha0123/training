package ExcelData_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebOrdersLoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000); // just to see result clearly
        driver.quit();
    }

    @Test(dataProvider = "loginData", dataProviderClass = WebOrdersDataProvider.class)
    public void loginTest(String username, String password, String expected) {
        // Enter username and password
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        if (expected.equals("success")) {
            // On successful login → page title should contain "Web Orders"
            String title = driver.getTitle();
            Assert.assertTrue(title.contains("Web Orders"),
                    "Login failed for valid user: " + username);
            System.out.println("Login successful for user: " + username);

        } else if (expected.equals("invalid")) {
            // Invalid credentials → error message is displayed
            String errorMsg = driver.findElement(By.id("ctl00_MainContent_status")).getText();
            Assert.assertTrue(errorMsg.contains("Invalid"),
                    "Expected invalid login error but got: " + errorMsg);
            System.out.println("Invalid login for user: " + username);
        }
    }
}
