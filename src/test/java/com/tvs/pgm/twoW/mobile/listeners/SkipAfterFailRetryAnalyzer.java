package com.tvs.pgm.twoW.mobile.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class SkipAfterFailRetryAnalyzer implements IRetryAnalyzer {

    private static boolean hasFailed = false;

    @Override
    public boolean retry(ITestResult result) {
        if (!hasFailed && result.getStatus() == ITestResult.FAILURE) {
            hasFailed = true;
        }
        return false;
    }

    public static boolean hasPreviouslyFailed() {
        return hasFailed;
    }
}

