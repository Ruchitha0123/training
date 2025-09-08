package com.nopcommerce.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.nopcommerce.base.Basetest;

public class TestListener implements ITestListener {
    private AtomicInteger passed = new AtomicInteger(0);
    private AtomicInteger failed = new AtomicInteger(0);
    private AtomicInteger skipped = new AtomicInteger(0);
    private List<String> failedTests = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void onTestStart(ITestResult result) {
        // create Extent test for this method
        ExtentTest t = Basetest.extent.createTest(result.getMethod().getMethodName());
        result.setAttribute("extentTest", t);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        passed.incrementAndGet();
        ExtentTest t = (ExtentTest) result.getAttribute("extentTest");
        if (t != null) t.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failed.incrementAndGet();
        failedTests.add(result.getTestClass().getName() + ":" + result.getMethod().getMethodName());

        ExtentTest t = (ExtentTest) result.getAttribute("extentTest");
        if (t != null) {
            t.fail(result.getThrowable());
            String screenshot = Basetest.takeScreenshot(result.getMethod().getMethodName());
            if (screenshot != null) {
                try { t.addScreenCaptureFromPath(screenshot); } catch (Exception e) { e.printStackTrace(); }
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skipped.incrementAndGet();
        ExtentTest t = (ExtentTest) result.getAttribute("extentTest");
        if (t != null) t.skip("Test skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        int total = passed.get() + failed.get() + skipped.get();
        System.out.println("\n===== TESTNG SUMMARY (custom listener) =====");
        System.out.println("Total tests run: " + total);
        System.out.println("Passed: " + passed.get());
        System.out.println("Failed: " + failed.get());
        System.out.println("Skipped: " + skipped.get());

        if (!failedTests.isEmpty()) {
            System.out.println("\nFailed tests list:");
            failedTests.forEach(System.out::println);
        }
        System.out.println("===========================================\n");

        // flush Extent here as well to ensure report updated
        if (Basetest.extent != null) {
            Basetest.extent.flush();
        }
    }

    // other listener methods left empty
}
