package com.tvs.pgm.twoW.mobile.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        // Get values using ConfigReader
        String baseReportPath = ConfigReader.getProperty("reportPath", "./test-output/ExtentReport.html");

        // Append timestamp to avoid overwrite
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = baseReportPath.replace(".html", "_" + timeStamp + ".html");

        String reportName = ConfigReader.getProperty("reportName", "Mobile Automation Report");
        String documentTitle = ConfigReader.getProperty("documentTitle", "Execution Report");
        String theme = ConfigReader.getProperty("theme", "DARK").toUpperCase();

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setReportName(reportName);
        sparkReporter.config().setDocumentTitle(documentTitle);
        sparkReporter.config().setTheme(theme.equals("STANDARD") ? Theme.STANDARD : Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add system/environment info
        extent.setSystemInfo("Tester", ConfigReader.getProperty("testerName", "Automation Engineer"));
        extent.setSystemInfo("Project", ConfigReader.getProperty("projectName", "Appium Test Project"));
        extent.setSystemInfo("Environment", ConfigReader.getProperty("environment", "QA"));
        extent.setSystemInfo("Platform", ConfigReader.getPlatform());
        extent.setSystemInfo("Device Name", ConfigReader.getProperty("deviceName", "Unknown Device"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));

        // Optional: include browser/app type
        String browserOrApp = ConfigReader.getProperty("browser", "Mobile App");
        extent.setSystemInfo("Browser/App", browserOrApp);

        return extent;
    }
}