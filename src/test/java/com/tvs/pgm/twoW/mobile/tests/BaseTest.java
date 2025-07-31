package com.tvs.pgm.twoW.mobile.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.tvs.pgm.twoW.mobile.base.DriverManager;
import com.tvs.pgm.twoW.mobile.utils.ExtentReportManager;

import io.appium.java_client.AppiumDriver;

public class BaseTest {

    private static final String SCREENSHOT_DIR = "test-output/screenshots/";
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setupSuite() {
        extent = ExtentReportManager.getInstance();
        try {
            Files.createDirectories(Paths.get(SCREENSHOT_DIR));
        } catch (IOException e) {
            System.err.println("❌ Failed to create screenshot directory: " + e.getMessage());
        }
    }

    @BeforeClass
    public void setupDriver() throws MalformedURLException {
        DriverManager.initializeDriver();
    }

    @BeforeMethod
    public void startTest(Method method) {
        if (extent == null) {
            throw new IllegalStateException("ExtentReports not initialized. Call setupSuite() first.");
        }

        Test testAnnotation = method.getAnnotation(Test.class);
        String testCaseName = (testAnnotation != null && !testAnnotation.description().isEmpty())
                ? testAnnotation.description()
                : method.getName();

        test = extent.createTest(testCaseName);
    }

    @AfterMethod
    public void captureResult(ITestResult result) {
        AppiumDriver driver = DriverManager.getDriver();

        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = SCREENSHOT_DIR + result.getName() + "_" + System.currentTimeMillis() + ".jpeg";

            try {
                FileHandler.copy(screenshot, new File(screenshotPath));
                if (test != null) {
                    test.addScreenCaptureFromPath(screenshotPath);
                }
            } catch (IOException e) {
                if (test != null) test.warning("⚠️ Screenshot capture failed: " + e.getMessage());
            }
        }

        if (test != null) {
            switch (result.getStatus()) {
                case ITestResult.SUCCESS:
                    test.pass("✅ Test Passed");
                    break;
                case ITestResult.FAILURE:
                    test.fail("❌ Test Failed: " + result.getThrowable());
                    break;
                case ITestResult.SKIP:
                    test.skip("⏭️ Test Skipped: " + result.getThrowable());
                    break;
            }
        }
    }

    @AfterClass
    public void tearDownDriver() {
        DriverManager.quitDriver();
    }

    @AfterSuite
    public void tearDownSuite() {
        if (extent != null) {
            extent.flush();
        }
    }
}