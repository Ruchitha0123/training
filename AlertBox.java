package TestNG;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertBox {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        // Disable popups/ads as much as possible
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Helper method: safe click with scroll + JS fallback
    private void safeClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            // If intercepted by ads, use JS click
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    @Test
    public void testAlerts() {
        driver.get("https://demoqa.com/alerts");

        // 1. Simple Alert
        safeClick(By.id("alertButton"));
        Alert simpleAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Simple Alert Text: " + simpleAlert.getText());
        simpleAlert.accept();

        // 2. Timer Alert
        safeClick(By.id("timerAlertButton"));
        Alert timerAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Timer Alert Text: " + timerAlert.getText());
        timerAlert.accept();

        // 3. Confirmation Alert
        safeClick(By.id("confirmButton"));
        Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Confirm Alert Text: " + confirmAlert.getText());
        confirmAlert.dismiss();

        // 4. Prompt Alert
        safeClick(By.id("promtButton"));
        Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Prompt Alert Text: " + promptAlert.getText());
        promptAlert.sendKeys("Tharun Testing");
        promptAlert.accept();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}