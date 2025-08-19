package ExcelData_TestNG;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyListener_Report implements ITestListener {

    WebDriver driver;
    ExtentSparkReporter spark;
    ExtentReports extent;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Testing starts...");

        // Create Extent Report
        String reportPath = System.getProperty("user.dir") + "/ExtentReport_WebOrders.html";
        spark = new ExtentSparkReporter(reportPath);

        extent = new ExtentReports();
        extent.attachReporter(spark);

        // System info
        extent.setSystemInfo("Tester", "AutomationUser");
        extent.setSystemInfo("Application", "SmartBear WebOrders");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser", "Chrome");

        // Report style
        spark.config().setDocumentTitle("WebOrders Automation Report");
        spark.config().setReportName("WebOrders Test Execution");
        spark.config().setTheme(Theme.STANDARD);
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("▶️ Test Started: " + result.getName());
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test Passed: " + result.getName());
        test.log(Status.PASS, "Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test Failed: " + result.getName());
        test.log(Status.FAIL, "Test Failed: " + result.getName());
        test.fail(result.getThrowable());

        // Capture screenshot
        Object testClass = result.getInstance();
        driver = ((Listener_Practice) testClass).driver;

        File destDir = new File("Screenshots");
        if (!destDir.exists()) destDir.mkdir();

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String fileName = result.getName() + "_" + timeStamp + ".png";

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(destDir, fileName);

        try {
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + destFile.getPath());

            // Attach screenshot in report
            test.addScreenCaptureFromPath(destFile.getAbsolutePath(), result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⏭️ Test Skipped: " + result.getName());
        test.log(Status.SKIP, "Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        test.log(Status.FAIL, "Test failed due to timeout: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Testing Ended...");
        extent.flush();  // ✅ Writes report to HTML
    }
}