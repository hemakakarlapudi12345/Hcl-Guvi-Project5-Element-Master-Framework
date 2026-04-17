package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.*;

import utils.ExtentManager;
import utils.ScreenshotUtil;
import base.BaseTest;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReportInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        // 🔥 GET DRIVER FROM TEST CLASS (IMPORTANT FIX)
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).driver;

        String path = ScreenshotUtil.captureScreenshot(driver, result.getName());

        test.fail("Test Failed");
        test.fail(result.getThrowable());

        try {
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}