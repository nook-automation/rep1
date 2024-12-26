package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestReportListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports with HTML Reporter
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./extent-reports/test-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a test entry in the report
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log success with green color
        test.pass(MarkupHelper.createLabel(result.getMethod().getMethodName() + " passed", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log failure with red color
        test.fail(MarkupHelper.createLabel(result.getMethod().getMethodName() + " failed", ExtentColor.RED));
        // Optionally capture a screenshot (see below for how)
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip(MarkupHelper.createLabel(result.getMethod().getMethodName() + " skipped", ExtentColor.YELLOW));
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the report to generate the final output
        extent.flush();
    }
}
