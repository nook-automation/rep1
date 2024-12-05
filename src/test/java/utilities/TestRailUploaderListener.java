package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.HttpClient; // Not needed anymore, it's in HttpClients
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import functionalLibrary.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestRailUploaderListener extends TestBase implements ITestListener {
	//public static File screenshot;
	public static String screenshotPath="";
	public static String testCaseId="";


    // Assuming driver is available (you can retrieve it from your test class if needed)

    // This method is invoked before each test method runs
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    // This method is invoked if the test passes
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        // Optionally, you can upload successful test results to TestRail or handle other actions
    }

    // This method is invoked if the test fails
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());

        try {
//            // Capture screenshot on failure
//            screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + result.getName() + ".png";
//
//            // Save the screenshot locally
//            Files.copy(screenshot.toPath(), Paths.get(screenshotPath));
//
        	System.out.print("im here");
        	
        	
        	
    	    TakesScreenshot screenshot = (TakesScreenshot) driver;
    	    screenshot= (TakesScreenshot) screenshot.getScreenshotAs(OutputType.FILE);
    	    File targetDir = new File(System.getProperty("user.dir") + "/Screenshots");
    	    if (!targetDir.exists()) {
    	        targetDir.mkdirs();
    	    }
    	   // String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    	    File target = new File(targetDir, "screenshot_" + result.getName()  + ".png");

    	    try {
    	        FileUtils.copyFile((File) screenshot, target);
    	        System.out.println("Screenshot saved: " + target.getAbsolutePath());
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }
        	
        	
        	
            // Extract TestRail ID from the test name
            String testCaseId = extractTestCaseId(result.getTestName());
            System.out.println("TestCase ID: " + testCaseId);

            screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + result.getName() + ".png";

            // Upload the screenshot to TestRail
            TestRailAPI.uploadScreenshot(screenshotPath, testCaseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This method is invoked if the test is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    // This method is invoked if the test fails but within success percentage (if configured in TestNG)
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but within success percentage: " + result.getName());
    }

    // This method is invoked when the test suite starts
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    // This method is invoked when the test suite finishes
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
    }

    // Helper method to extract TestRail ID from the test name (modify as needed)
    private String extractTestCaseId(String testName) {
        // Example: Extract first 6 characters (TestRail ID logic, modify if needed)
        if (testName.length() >= 7) {
            return testName.substring(1, 7); // Adjust substring based on your naming convention
        }
        return "Unknown";
    }

}


