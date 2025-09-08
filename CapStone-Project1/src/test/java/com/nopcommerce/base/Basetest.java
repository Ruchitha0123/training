package com.nopcommerce.base;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
    public static WebDriver driver;
    public static ExtentReports extent;

    private static final String REPORT_FOLDER = "reports";
    private static final String REPORT_FILE = REPORT_FOLDER + "/ExtentReport.html";
    private static final String SCREENSHOT_DIR = REPORT_FOLDER + "/screenshots";

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        // Init Extent
        ExtentSparkReporter spark = new ExtentSparkReporter(REPORT_FILE);
        spark.config().setReportName("nopCommerce Automation Report");
        spark.config().setDocumentTitle("Automation Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        // Start single browser for the whole suite
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");

        // OPTIONAL: auto-login here if you want (read credentials from config or Excel)
        // new com.nopcommerce.pages.LoginPage(driver).login("email@example.com","Password123");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            if (extent != null) {
                extent.flush();
            }
        }
    }

    // helper to take screenshot and return the saved path (absolute or relative)
    public static String takeScreenshot(String testName) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            Path destPath = Paths.get(SCREENSHOT_DIR, testName + "_" + timestamp + ".png");
            Files.createDirectories(destPath.getParent());
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
            return destPath.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
