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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tvs.pgm.twoW.mobile.base.DriverManager;

import io.appium.java_client.AppiumDriver;

public class BaseTest {
	
	protected static ExtentReports extent;
    protected static ExtentTest test;
    protected static AppiumDriver driver;

    private static final String SCREENSHOT_DIR = "test-output/screenshots/";

    @BeforeSuite
    public void setup() throws MalformedURLException {
        DriverManager.initializeDriver();

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Tester", "Garima Mishra");
        extent.setSystemInfo("Project", "Mobile App Testing - 2Wheeler");
        extent.setSystemInfo("Environment", "Dev");
        extent.setSystemInfo("OS", "Android");
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));

        // Create screenshots directory if not exists
        try {
            Files.createDirectories(Paths.get(SCREENSHOT_DIR));
        } catch (IOException e) {
            System.err.println("Failed to create screenshot directory: " + e.getMessage());
        }
    }

    @BeforeMethod
    public void startTest(Method method) {
        Test testAnnotation = method.getAnnotation(Test.class);
        String testCaseName = (testAnnotation != null && !testAnnotation.description().isEmpty())
                ? testAnnotation.description()
                : method.getName();

        test = extent.createTest(testCaseName);
    }

    @AfterMethod
    public void captureResult(ITestResult result) {
        String screenshotPath = SCREENSHOT_DIR + result.getName() + ".jpeg";

        if (DriverManager.getDriver() != null) {
            File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileHandler.copy(screenshot, new File(screenshotPath));
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (IOException e) {
                test.warning("Screenshot capture failed: " + e.getMessage());
            }
        }

        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                test.pass("Test Passed");
                break;
            case ITestResult.FAILURE:
                test.fail("Test Failed: " + result.getThrowable());
                break;
            case ITestResult.SKIP:
                test.skip("Test Skipped: " + result.getThrowable());
                break;
        }
    }

    @AfterSuite
    public void tearDown() {
        DriverManager.quitDriver();
        if (extent != null) {
            extent.flush();
        }
    }

}
