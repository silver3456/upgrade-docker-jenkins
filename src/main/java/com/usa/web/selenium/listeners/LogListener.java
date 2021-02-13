package com.usa.web.selenium.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class LogListener implements ITestListener {
    private static Logger LOG = Logger.getLogger(LogListener.class.getName());

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOG.info("/nTest started with name: " + iTestResult.getTestName());

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOG.info("Test2 started with name: " + iTestResult.getTestName() + " success\n");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOG.error("Test2 started with name: " + iTestResult.getTestName() + " fail\n");
        LOG.error("Test2 error: " + iTestResult.getThrowable());

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}