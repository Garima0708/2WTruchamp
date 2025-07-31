package com.tvs.pgm.twoW.mobile.utils;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.tvs.pgm.twoW.mobile.base.DriverManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    private static AppiumDriver driver = DriverManager.getDriver();

    /**
     * Captures screenshot with page name and test method in filename
     * @param pageName - e.g., "LoginPage"
     * @param testName - e.g., "verifyLocationPermissionPopupDisplayed"
     * @return relative path of saved screenshot for report attachment
     */
    public static String captureScreenshot(String pageName, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Folder path for screenshots
        String dirPath = "src/test/resources/Screenshots";

        // Create directory if it doesn't exist
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Filename pattern: LoginPage_verifyLocationPermissionPopupDisplayed_20250727_121530.png
        String fileName = pageName + "_" + testName + "_" + timestamp + ".png";

        // Full path to save screenshot
        String filePath = dirPath + "/" + fileName;

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("❗ Screenshot capture failed: " + e.getMessage());
        }

        // Return relative path for report attachment
        return filePath;
    }
}
