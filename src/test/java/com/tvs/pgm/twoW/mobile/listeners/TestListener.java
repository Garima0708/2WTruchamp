package com.tvs.pgm.twoW.mobile.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("📌 Test Suite Started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("📌 Test Suite Finished");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("✅ Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test Failed: " + result.getName());
        System.out.println("Reason: " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠️ Test Skipped: " + result.getName());
        if (result.getThrowable() != null) {
            System.out.println("Reason: " + result.getThrowable().getMessage());
        }
    }

    // Catch configuration (setup/teardown) failures
    
}
