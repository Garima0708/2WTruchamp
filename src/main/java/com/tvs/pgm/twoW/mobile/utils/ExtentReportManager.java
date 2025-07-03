package com.tvs.pgm.twoW.mobile.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;

    private ExtentReportManager() {
        // Prevent instantiation
    }

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance();
        }
        return extent;
    }

    private static ExtentReports createInstance() {
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        
        // Optional configurations
        sparkReporter.config().setReportName("2W App Automation Results");
        sparkReporter.config().setDocumentTitle("Test Report");
        sparkReporter.config().setTheme(Theme.DARK);

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Tester", "Garima Mishra");
        extentReports.setSystemInfo("Project", "Mobile App Testing - 2Wheeler");
        extentReports.setSystemInfo("Environment", "Dev");
        extentReports.setSystemInfo("OS", "Android");
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));

        return extentReports;
    }
}