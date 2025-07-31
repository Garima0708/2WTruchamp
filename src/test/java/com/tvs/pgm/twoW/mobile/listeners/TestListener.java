package com.tvs.pgm.twoW.mobile.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.*;
import com.tvs.pgm.twoW.mobile.utils.*;

public class TestListener implements ITestListener {

    private static ExtentReports report;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        System.out.println("📌 Test Suite Started");
        report = ExtentReportManager.getInstance();
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("📌 Test Suite Finished");
        if (report != null) {
            report.flush();
            System.out.println("📄 ExtentReport generated.");
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("✅ Test Started: " + result.getName());

        String className = result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName();

        ExtentTest extentTest = report.createTest(className + " :: " + methodName);
        test.set(extentTest);

        extentTest.log(Status.INFO, "📌 Test case '" + methodName + "' execution started.");
        extentTest.log(Status.INFO, "Test Description: " + result.getMethod().getDescription());
        extentTest.log(Status.INFO, "Browser/Device: " + ConfigReader.getProperty("browser", "N/A"));

        String env = ConfigReader.getProperty("environment", "QA");
        extentTest.log(Status.INFO, "URL: " + ConfigReader.getProperty(env + ".url", "N/A"));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test Passed: " + result.getName());
        Markup m = MarkupHelper.createLabel("✅ Test passed: " + result.getName(), ExtentColor.GREEN);
        test.get().log(Status.PASS, m);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test Failed: " + result.getName());
        System.out.println("Reason: " + result.getThrowable().getMessage());

        String methodName = result.getMethod().getMethodName();
        String screenshotPath = ScreenshotUtil.captureScreenshot("LoginPage", "verifyLocationPermissionPopupDisplayed");

        Markup m = MarkupHelper.createLabel("❌ Test failed: " + methodName, ExtentColor.RED);
        test.get().log(Status.FAIL, m);
        test.get().log(Status.INFO, "Exception: " + result.getThrowable());

        try {
            if (screenshotPath != null && !screenshotPath.isEmpty()) {
                test.get().addScreenCaptureFromPath(screenshotPath);
                test.get().log(Status.INFO, "Screenshot saved at: " + screenshotPath);
            }
        } catch (Exception e) {
            System.out.println("❗ Failed to attach screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠️ Test Skipped: " + result.getName());
        if (result.getThrowable() != null) {
            System.out.println("Reason: " + result.getThrowable().getMessage());
        }
        Markup m = MarkupHelper.createLabel("⚠️ Test Skipped: " + result.getName(), ExtentColor.ORANGE);
        test.get().log(Status.SKIP, m);
        if (result.getThrowable() != null) {
            test.get().log(Status.SKIP, result.getThrowable());
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("⚠️ Test Failed but within success percentage: " + result.getName());
        test.get().log(Status.WARNING, "Test failed but within success percentage");
    }
}