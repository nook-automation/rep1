package tests;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.annotations.VisibleForTesting;

import common.Property;
import config.Config;
import functionalLibrary.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import pages.PageObjectManager;
import utilities.TestListener;
//import utilities.TestListener;
import utilities.TestRailUploaderListener;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.TestResult;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebElement;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;


public class TestApp extends TestBase implements ITestListener{ 
	public static String bundleId ="com.bnenterprise.B-N-eReader";
	//bundle id of appstore build
	//com.barnesandnoble.B-N-eReader
	String name1="";

	String name=date();
	SoftAssert softAssert = new SoftAssert();
	TestRailUploaderListener obj=new TestRailUploaderListener();

	
	

	PageObjectManager page= new PageObjectManager();
	int implicitWait = 20;

	

	@BeforeClass
	public void testOnLocaldevice() throws Exception {


		//String propertyFileName = System.getProperty("user.dir") + "/device_Input/general.properties";
		String propertyFileName = System.getProperty("user.dir") +File.separator+"device_Input"+File.separator+"general.properties";
		//System.out.println(propertyFileName);
		propertyMap = new Property().getMap(propertyFileName);
		TEST_RUN_ID = propertyMap.get("TEST_RUN_ID");
		TESTRAIL_USERNAME = propertyMap.get("TESTRAIL_USERNAME");
		TESTRAIL_PASSWORD = propertyMap.get("TESTRAIL_PASSWORD");
			DesiredCapabilities capabilities = Config.getIphone();
			setup(capabilities);
			baseDriverwait(implicitWait);
	}	
	
	
	
//	@AfterSuite
//	public static void sendTestReportEmail()
//	{
//		System.out.println(TestListener.reportPath);
//		TestListener.sendEmailWithAttachment(TestListener.reportPath);
//
//	}
//	
	
//	@AfterClass
//	public void assertion()
//	{
//		softAssert.assertAll();
//	}
	
    
	    @Test(priority = -1)
	    @Description("This is a test case to verify the account creation functionality.")
	    @Step("Creating a random account with current date and time as email and password: Test1234")
	    public void C1736451_CreateAccount() throws Exception {
	        try {
	            waitUntilVisible(page.getSignINScreen().getBtnCreateAccount());
	            touchAtCenterOfElement(page.getSignINScreen().getBtnCreateAccount());
	            
	            waitUntilVisible(page.getCreateAccountScreen().getTxtBoxFirstName());
	            touchAtCenterOfElement(page.getCreateAccountScreen().getTxtBoxFirstName());
	            sendKeys("FName");

	            waitUntilVisible(page.getCreateAccountScreen().getTxtBoxLastName());
	            touchAtCenterOfElement(page.getCreateAccountScreen().getTxtBoxLastName());
	            sendKeys("LName");

	            waitUntilVisible(page.getCreateAccountScreen().getTxtBoxEmail());
	            touchAtCenterOfElement(page.getCreateAccountScreen().getTxtBoxEmail());
	            String emailid = date();
	            String emailid1 = "Test" + emailid + "@bn.com";
	            sendKeys(emailid1);

	            waitUntilVisible(page.getCreateAccountScreen().getTxtBoxPassword());
	            touchAtCenterOfElement(page.getCreateAccountScreen().getTxtBoxPassword());
	            sendKeys("Test1234");

	            swipeScreen(Direction.UP);

	            waitUntilVisible(page.getCreateAccountScreen().getTxtBoxConfirmPassword());
	            touchAtCenterOfElement(page.getCreateAccountScreen().getTxtBoxConfirmPassword());
	            sendKeys("Test1234");

	            waitUntilVisible(page.getCreateAccountScreen().getTxtBoxSecurityAnswer());
	            touchAtCenterOfElement(page.getCreateAccountScreen().getTxtBoxSecurityAnswer());
	            sendKeys("Chennai");

	            waitUntilVisible(page.getCreateAccountScreen().getBtnCreateAccount());
	            touchAtCenterOfElement(page.getCreateAccountScreen().getBtnCreateAccount());

	            waitUntilVisible(page.getCreateAccountScreen().getBtnAccept());
	            touchAtCenterOfElement(page.getCreateAccountScreen().getBtnAccept());

	            waitUntilVisible(page.getSignINScreen().getBtnContinue());
	            touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());

	            if (isElementDisplayed(page.getSignINScreen().getBtnNotNow())) {
	                waitUntilVisible(page.getSignINScreen().getBtnNotNow());
	                touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
	            }

	            waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	            touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	            
	            waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());

	            if (isElementDisplayed(page.getLibraryScreen().getTxtTitleLibrary())) {
	                System.out.println("Create new BN account");
	                System.out.println("Test Passed - C1736451");
	                TestBase.addResultForTestCase("1736451", 1, "");
	                softAssert.assertTrue(true);
	            } else {
	                System.out.println("Create new BN account");
	                System.out.println("Test Failed - C1736451");
	                TestBase.addResultForTestCase("1736451", 5, "");
	            	softAssert.assertTrue(false, "Assertion failed: Condition is false.");
	                
	            }

	            // Sign out and end the session
	            waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
	            touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
	            
	        	waitUntilVisible(page.getAccountScreen().getBtnFavoriteCategories());
	        	swipeScreen(Direction.UP);

	            waitUntilVisible(page.getAccountScreen().getBtnSignOut());
	            touchAtCenterOfElement(page.getAccountScreen().getBtnSignOut());

	            waitUntilVisible(page.getAccountScreen().getBtnOKSignout());
	            touchAtCenterOfElement(page.getAccountScreen().getBtnOKSignout());

	            waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	        } 
	            catch (Exception e) {
	          	e.printStackTrace();
	    		getScreenshot();
	    		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	    		driver.terminateApp(bundleId);
	    		driver.activateApp("com.apple.Preferences");
	    		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
	    		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
	    		HashMap<String, Object> scrollObject = new HashMap<>();
	    		scrollObject.put("element", elementId);
	    		scrollObject.put("toVisible", true);
	    		driver.executeScript("mobile:scroll", scrollObject);
	    		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
	    		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
	    		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	    	     // Get screen dimensions
	            Dimension size = driver.manage().window().getSize();
	            int screenHeight = size.height;
	            int screenWidth = size.width;

	            // Scroll to halfway point
	            int middleY = screenHeight / 2;
	            int startX = screenWidth / 2;
	            int endY = screenHeight / 4; 

	            Point startPoint = new Point(startX, middleY);
	            Point endPoint = new Point(startX, endY);

	            TouchAction touchAction = new TouchAction(driver);
	            touchAction.press(PointOption.point(startPoint.x, startPoint.y))
	                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
	                    .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
	                    .release()
	                    .perform();
	    		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
	    		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
	    		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
	    		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
	    		driver.activateApp(bundleId);

	        }
	    }

	    // Handle exception and attach details for debugging
	    private void handleException(Exception e) {
	        System.out.println("Test Case Rerun Started");

	        // Attach exception stack trace to Allure for easier debugging
	        attachLog("Exception occurred: " + e.getMessage());
	        e.printStackTrace();

	        // Additional actions can be added here to capture logs, screenshots, etc.
	    }

	    // Example method to attach logs
	    @Attachment(value = "Test Logs", type = "text/plain")
	    public String attachLog(String log) {
	        return log;
	    }

	    // Example method for taking screenshots
	    @Attachment(value = "Screenshot", type = "image/png")
	    public byte[] takeScreenshot() {
	        // Capture the screenshot using WebDriver
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    }


//@Test(priority=1)
public void SignInAccount() throws Exception

{	
	try
	{
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
	waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
	sendKeys("autacc_001@bn.com");
	waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
	sendKeys("Test1234");
	waitUntilVisible(page.getSignINScreen().getBtnLogin());
	touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
	waitUntilVisible(page.getSignINScreen().getBtnContinue());
	touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
	if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getSignINScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
	}
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
	if(isElementDisplayed(page.getLibraryScreen().getTxtTitleLibrary()))
	{
		System.out.println("Sign in existing BN account");
		System.out.println("Test Passed - C1697654");
		TestBase.addResultForTestCase("1697654", 1, "");
        softAssert.assertTrue(true);


	}
	else
	{
		System.out.println("Sign in existing BN account");
		System.out.println("Test Failed - C1697654");
		TestBase.addResultForTestCase("1697654", 5, "");
    	softAssert.assertTrue(false, "Assertion failed: Condition is false.");
	}
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
	waitUntilVisible(page.getAccountScreen().getBtnFavoriteCategories());
//	driver.findElement(MobileBy.iOSNsPredicateString("scrollTo(\"name CONTAINS 'SIGN OUT'\")"));
	swipeScreen(Direction.UP);
	Thread.sleep(3000);
	waitUntilVisible(page.getAccountScreen().getBtnSignOut());
	touchAtCenterOfElement(page.getAccountScreen().getBtnSignOut());
	waitUntilVisible(page.getAccountScreen().getBtnOKSignout());
	touchAtCenterOfElement(page.getAccountScreen().getBtnOKSignout());
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	}
	catch (Exception e) {
    	e.printStackTrace();
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
        // Explicitly fail the test
       //Assert.fail("Test failed due to exception: " + e.getMessage());

	}
	
}



//@Test(priority=2)
public void LibrarySignIn() throws Exception

{	
	try
	{
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
	waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
	sendKeys("autacc_001@bn.com");
	waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
	sendKeys("Test1234");
	waitUntilVisible(page.getSignINScreen().getBtnLogin());
	touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
	waitUntilVisible(page.getSignINScreen().getBtnContinue());
	touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
	if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getSignINScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
	}
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
	Thread.sleep(40000);
	waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	Thread.sleep(3000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(3000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=3)
public void LibraryRecentTab() throws Exception

{	
	try
	{
	touchAtCenterOfElement(page.getLibraryScreen().getTxtTabRecents());
	if(isElementDisplayed(page.getLibraryScreen().getTxtNookTips()))
	{
		touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelNookTips());
	}
	Thread.sleep(3000);
	boolean assert1=isElementDisplayed(page.getLibraryScreen().getTxtTabRecentReads());
	boolean assert2=isElementDisplayed(page.getLibraryScreen().getTxtTabRecentReadsBook1());
	boolean assert3=isElementDisplayed(page.getLibraryScreen().getTxtTabRecentPurchases());
	boolean assert4=isElementDisplayed(page.getLibraryScreen().getTxtTabRecentPurchasesBook1());
	if(assert1&&assert2&&assert3&&assert4)
	{
		System.out.println("Library - Recent Tab");
		System.out.println("Test Passed - C1736535");
		TestBase.addResultForTestCase("1736535", 1, "");

	}
	else
	{
		System.out.println("Library - Recent Tab");
		System.out.println("Test Failed - C1736535");
		TestBase.addResultForTestCase("1736535", 5, "");
	}
	waitUntilVisible(page.getLibraryScreen().getTxtTabAllTitles());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtTabAllTitles());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=4)
public void alltitlesCategoryFilter() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	boolean books=isElementDisplayed(page.getLibraryScreen().getTxtFilterByBooks());
	boolean all=isElementDisplayed(page.getLibraryScreen().getTxtFilterByAllTypes());
	boolean ab=isElementDisplayed(page.getLibraryScreen().getTxtFilterByAudioBooks());
	boolean cat=isElementDisplayed(page.getLibraryScreen().getTxtFilterByCatalog());
	boolean com=isElementDisplayed(page.getLibraryScreen().getTxtFilterByComic());
	boolean kid=isElementDisplayed(page.getLibraryScreen().getTxtFilterByKids());
	boolean mag=isElementDisplayed(page.getLibraryScreen().getTxtFilterByMyFiles());
	boolean news=isElementDisplayed(page.getLibraryScreen().getTxtFilterByNewspaper());
	if(books&&all&&ab&&cat&&com&&kid&&mag&&news)
	{
		System.out.println("Library: All Titles tab - Category filter function");
		System.out.println("Test Passed - C1697664");
		TestBase.addResultForTestCase("1697664", 1, "");

	}
	else
	{
		
		System.out.println("Library: All Titles tab - Category filter function");
		System.out.println("Test Failed - C1697664");
		TestBase.addResultForTestCase("1697664", 5, "");

	}
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByAllTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByAllTypes());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=5)
public void mostRecent() throws Exception

{	
	try
	{
	waitUntilVisible(page.getLibraryScreen().getTxtFilterSortType());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterSortType());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterSortByMostRecent());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterSortByMostRecent());
	waitUntilVisible(page.getLibraryScreen().getTxtBookNamesLibrary());
	if(isElementDisplayed(page.getLibraryScreen().getTxtBookNamesLibrary()))
	{
		System.out.println("Library: All Titles tab - Sort by Most Recent");
		System.out.println("Test Passed - C1697665");
		TestBase.addResultForTestCase("1697665", 1, "");
	}
	else
	{
		System.out.println("Library: All Titles tab - Sort by Most Recent");
		System.out.println("Test Failed - C1697665");
		TestBase.addResultForTestCase("1697665", 5, "");
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}

//@Test(priority=6)
public void sortByTitle() throws Exception

{	
	try
	{
	waitUntilVisible(page.getLibraryScreen().getTxtFilterSortType());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterSortType());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterSortByTitle());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterSortByTitle());
	waitUntilVisible(page.getLibraryScreen().getImgCoverAdventuresOfPinocchio());
	if(isElementDisplayed(page.getLibraryScreen().getImgCoverAdventuresOfPinocchio()))
	{
		System.out.println("Library: All Titles tab - Sort by Title");
		System.out.println("Test Passed - C1730448");
		TestBase.addResultForTestCase("1730448", 1, "");
	}
	else
	{
		System.out.println("Library: All Titles tab - Sort by Title");
		System.out.println("Test Failed - C1730448");
		TestBase.addResultForTestCase("1730448", 5, "");
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=7)
public void sortByAuthor() throws Exception

{	
	try {
	waitUntilVisible(page.getLibraryScreen().getTxtFilterSortType());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterSortType());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterSortByAuthor());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterSortByAuthor());
	Thread.sleep(3000);
	if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getSignINScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
	}
	waitUntilVisible(page.getLibraryScreen().getTxtBookNamesSortedByAuthor());
	if(isElementDisplayed(page.getLibraryScreen().getTxtBookNamesSortedByAuthor()))
	{
		System.out.println("Library: All Titles tab - Sort by Author");
		System.out.println("Test Passed - C1730449");
		TestBase.addResultForTestCase("1730449", 1, "");

	}
	else
	{
		System.out.println("Library: All Titles tab - Sort by Author");
		System.out.println("Test Failed - C1730449");
		TestBase.addResultForTestCase("1730449", 5, "");

	}
	waitUntilVisible(page.getLibraryScreen().getTxtFilterSortType());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterSortType());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterSortByMostRecent());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterSortByMostRecent());
	if(isElementDisplayed(page.getLibraryScreen().getBtnSkip()))
	{
		touchAtCenterOfElement(page.getLibraryScreen().getBtnSkip());
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}

//@Test(priority=8)
public void allTitlesPdp() throws Exception

{	
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	waitUntilVisible(page.getLibraryScreen().getTxtBoxSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtBoxSearch());
	sendKeys("2940162667933");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBoyfriendEffectSearchLib());
	if(isElementDisplayed(page.getLibraryScreen().getImgCoverBoyfriendEffectSearchLib()))
	{
		longPress(page.getLibraryScreen().getImgCoverBoyfriendEffectSearchLib());
	}
	if(isElementDisplayed(page.getLibraryScreen().getBtnView())!=true)
	{
		longPress(page.getLibraryScreen().getImgCoverBoyfriendEffectSearchLibLongPress());
	}
	waitUntilVisible(page.getLibraryScreen().getBtnView());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnView());
	waitUntilVisible(page.getLibraryScreen().getBtnDetails());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnDetails());
	Thread.sleep(5000);
	boolean overview=isElementDisplayed(page.getPdpScreen().getTxtTtlOverview());
	boolean mov=isElementDisplayed(page.getPdpScreen().getBtnMoveToCloud());
	boolean add=isElementDisplayed(page.getPdpScreen().getBtnAddToWishlist());
	if(overview&&mov||add)
	{
		System.out.println("Library: All Titles tab - PDP (Product Detail Page)");
		System.out.println("Test Passed - C1736713");
		TestBase.addResultForTestCase("1736713", 1, "");
	}
	else
	{
		System.out.println("Library: All Titles tab - PDP (Product Detail Page)");
		System.out.println("Test Failed - C1736713");
		TestBase.addResultForTestCase("1736713", 5, "");
	}
	waitUntilVisible(page.getPdpScreen().getBtnBack());
	touchAtCenterOfElement(page.getPdpScreen().getBtnBack());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());	
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}

//@Test(priority=9)
public void archiveAnItem() throws Exception

{	
	try
	{
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByCatalog());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByCatalog());
	waitUntilVisible(page.getLibraryScreen().getImgCatalogNordStorm());
	longPress(page.getLibraryScreen().getImgCatalogNordStorm());
	waitUntilVisible(page.getLibraryScreen().getBtnArchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnArchive());
	waitUntilVisible(page.getLibraryScreen().getBtnArchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnArchive());
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnViewArchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnViewArchive());
	waitUntilVisible(page.getLibraryScreen().getImgCatalogNordStorm());
	if(isElementDisplayed(page.getLibraryScreen().getImgCatalogNordStorm()))
	{
		System.out.println("Library: All Titles tab - Archive an item");
		System.out.println("Test Passed - C1697697");
		TestBase.addResultForTestCase("1697697", 1, "");
	}
	else
	{
		System.out.println("Library: All Titles tab - Archive an item");
		System.out.println("Test Failed - C1697697");
		TestBase.addResultForTestCase("1697697", 5, "");
	}
	waitUntilVisible(page.getLibraryScreen().getImgCatalogNordStorm());
	longPress(page.getLibraryScreen().getImgCatalogNordStorm());
	waitUntilVisible(page.getLibraryScreen().getBtnUnarchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnUnarchive());
	waitUntilVisible(page.getLibraryScreen().getBtnUnarchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnUnarchive());
	waitUntilVisible(page.getLibraryScreen().getBtnBack());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBack());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}

//@Test(priority=10)
public void unarchiveAnItem() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByCatalog());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByCatalog());
	waitUntilVisible(page.getLibraryScreen().getImgCatalogNordStorm());
	if(isElementDisplayed(page.getLibraryScreen().getImgCatalogNordStorm()))
	{
		System.out.println("Library: All Titles tab - Unarchive an item");
		System.out.println("Test Passed - C1697698");
		TestBase.addResultForTestCase("1697698", 1, "");
	}
	else
	{
		System.out.println("Library: All Titles tab - Unarchive an item");
		System.out.println("Test Failed - C1697698");
		TestBase.addResultForTestCase("1697698", 5, "");
	
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}

//@Test(priority=11)
public void permenantlyDelete() throws Exception

{	
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavEbooks());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavEbooks());
	Thread.sleep(5000);
	if(isElementDisplayed(page.getBookstoreScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getBookstoreScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getBookstoreScreen().getBtnNotNow());
	}
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavEbooks());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavEbooks());
	Thread.sleep(3000);
	if(isElementDisplayed(page.getBookstoreScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getBookstoreScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getBookstoreScreen().getBtnNotNow());
	}
	waitUntilVisible(page.getBookstoreScreen().getBtnSearch());
	touchAtCenterOfElement(page.getBookstoreScreen().getBtnSearch());
	waitUntilVisible(page.getBookstoreScreen().getTxtBoxSearchBookstore());
	touchAtCenterOfElement(page.getBookstoreScreen().getTxtBoxSearchBookstore());
	//check free book or free sample
	sendKeys("2940185765982");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getBookstoreScreen().getTxtCoverAllThisTime());
	touchAtCenterOfElement(page.getBookstoreScreen().getTxtCoverAllThisTime());
	Thread.sleep(10000);
	new TouchAction(driver).tap(PointOption.point(345, 660)).perform();
	//Touch not working
//    waitUntilVisible(page.getPdpScreen().getBtnFreeSample());
//	touchAtCenterOfElement(page.getPdpScreen().getBtnFreeSample());
	Thread.sleep(5000);
	new TouchAction(driver).tap(PointOption.point(273, 409)).perform();
	waitUntilInvisible(page.getPdpScreen().getBtnCancelBy());
	Thread.sleep(15000);
	waitUntilVisible(page.getPdpScreen().getBtnReadSample());
	touchAtCenterOfElement(page.getPdpScreen().getBtnBack());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	if(isElementDisplayed(page.getBookstoreScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getBookstoreScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getBookstoreScreen().getBtnNotNow());
	}
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	
	// check here #1
	
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("2940185765982");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverAllThisTimeLibrary());
	longPress(page.getLibraryScreen().getImgCoverAllThisTimeLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnArchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnArchive());
	waitUntilVisible(page.getLibraryScreen().getBtnArchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnArchive());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByAllTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByAllTypes());
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnViewArchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnViewArchive());
	waitUntilVisible(page.getLibraryScreen().getImgCoverAllThisTimeLibrary());
	longPress(page.getLibraryScreen().getImgCoverAllThisTimeLibrary());
	Thread.sleep(2000);
	swipeScreen(Direction.UP);
	waitUntilVisible(page.getLibraryScreen().getBtnPermenantlyDelete());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnPermenantlyDelete());
	if(isElementDisplayed(page.getLibraryScreen().getBtnPermenantlyDelete()))
	{
		waitUntilVisible(page.getLibraryScreen().getBtnPermenantlyDelete());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnPermenantlyDelete());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getBtnConfirmDelete());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnConfirmDelete());
	}
	if(isElementDisplayed(page.getLibraryScreen().getImgCoverAllThisTimeLibrary())!=true)
	{
		System.out.println("Library: All Titles tab - Permanently Delete");
		System.out.println("Test Passed - C1729639");
		TestBase.addResultForTestCase("1729639", 1, "");
	}
	else
	{
		System.out.println("Library: All Titles tab - Permanently Delete");
		System.out.println("Test Failed - C1729639");
		TestBase.addResultForTestCase("1729639", 5, "");
	}
	waitUntilVisible(page.getLibraryScreen().getBtnBack());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBack());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}

//@Test(priority=12)
public void viewAnnotations() throws Exception

{	
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	waitUntilVisible(page.getLibraryScreen().getTxtBoxSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtBoxSearch());
	sendKeys("2940162667933");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	if(isElementDisplayed(page.getLibraryScreen().getImgCoverBoyfriendEffectSearchLib()))
	{
		longPress(page.getLibraryScreen().getImgCoverBoyfriendEffectSearchLib());
	}
	if(isElementDisplayed(page.getLibraryScreen().getBtnView())!=true)
	{
		longPress(page.getLibraryScreen().getImgCoverBoyfriendEffectSearchLibLongPress());
	}
	waitUntilVisible(page.getLibraryScreen().getBtnView());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnView());
	waitUntilVisible(page.getLibraryScreen().getBtnAnnotations());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnAnnotations());
	waitUntilVisible(page.getLibraryScreen().getTxtAnnotationBoyfriend());
	boolean anno1=isElementDisplayed(page.getLibraryScreen().getTxtAnnotationBoyfriend());
	boolean anno2=isElementDisplayed(page.getLibraryScreen().getTxtNoteForRelief());
	if(anno1&&anno2)
	{
		System.out.println("Library: All Titles tab - View annotations");
		System.out.println("Test Passed - C1736700");
		TestBase.addResultForTestCase("1736700", 1, "");
	}
	else
	{
		System.out.println("Library: All Titles tab - View annotations");
		System.out.println("Test Failed - C1736700");
		TestBase.addResultForTestCase("1736700", 5, "");
	}
	waitUntilVisible(page.getLibraryScreen().getBtnBack());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBack());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
}
catch (Exception e) {
	getScreenshot();
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	driver.terminateApp(bundleId);
	driver.activateApp("com.apple.Preferences");
	WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
	String elementId = ((RemoteWebElement) elementToScrollTo).getId();
	HashMap<String, Object> scrollObject = new HashMap<>();
	scrollObject.put("element", elementId);
	scrollObject.put("toVisible", true);
	driver.executeScript("mobile:scroll", scrollObject);
	waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
	touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
	waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

     // Get screen dimensions
    Dimension size = driver.manage().window().getSize();
    int screenHeight = size.height;
    int screenWidth = size.width;

    // Scroll to halfway point
    int middleY = screenHeight / 2;
    int startX = screenWidth / 2;
    int endY = screenHeight / 4; 

    Point startPoint = new Point(startX, middleY);
    Point endPoint = new Point(startX, endY);

    TouchAction touchAction = new TouchAction(driver);
    touchAction.press(PointOption.point(startPoint.x, startPoint.y))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
            .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
            .release()
            .perform();
	waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
	touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
	waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
	touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
	driver.activateApp(bundleId);
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
	waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
	sendKeys("autacc_001@bn.com");
	waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
	sendKeys("Test1234");
	waitUntilVisible(page.getSignINScreen().getBtnLogin());
	touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
	waitUntilVisible(page.getSignINScreen().getBtnContinue());
	touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
	if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getSignINScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
	}
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
	Thread.sleep(40000);
	waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	Thread.sleep(3000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(3000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
}
}

//@Test(priority=13)
public void createShelf() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getTxtTabShelves());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtTabShelves());
	Thread.sleep(3500);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnAddShelf());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnAddShelf());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByBooks());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByBooks());
	waitUntilVisible(page.getLibraryScreen().getImgCoverPosition1Shelf());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverPosition1Shelf());
	waitUntilVisible(page.getLibraryScreen().getImgCoverPosition2Shelf());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverPosition2Shelf());
	waitUntilVisible(page.getLibraryScreen().getImgCoverPosition3Shelf());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverPosition3Shelf());
	waitUntilVisible(page.getLibraryScreen().getBtnNextShelfTab());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnNextShelfTab());
	sendKeys("Dec");
	waitUntilVisible(page.getLibraryScreen().getBtnSaveShelf());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSaveShelf());
	waitUntilVisible(page.getLibraryScreen().getTxtShelfDecember());
	if(isElementDisplayed(page.getLibraryScreen().getTxtShelfDecember()))
	{
		System.out.println("Library: Shelves tab - Create shelf");
		System.out.println("Test Passed - C1697699");
		TestBase.addResultForTestCase("1697699", 1, "");
	}
	else
	{
		System.out.println("Library: Shelves tab - Create shelf");
		System.out.println("Test Failed - C1697699");
		TestBase.addResultForTestCase("1697699", 5, "");
	}
	Thread.sleep(7000);
}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}


//@Test(priority=14)
public void renameShelf() throws Exception

{	
	try
	{
	waitUntilVisible(page.getLibraryScreen().getTxtTabShelves());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtTabShelves());
	Thread.sleep(3500);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getTxtShelfDecember());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtShelfDecember());
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnRenameShelf());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnRenameShelf());
	sendKeys("New Year");
	waitUntilVisible(page.getLibraryScreen().getBtnSaveShelf());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSaveShelf());
	waitUntilVisible(page.getLibraryScreen().getTxtShelfNameNewYear());
	if(isElementDisplayed(page.getLibraryScreen().getTxtShelfNameNewYear()))
	{
		System.out.println("Library: Shelves tab - Rename shelf");
		System.out.println("Test Passed - C1729658");
		TestBase.addResultForTestCase("1729658", 1, "");
	}
	else
	{
		System.out.println("Library: Shelves tab - Rename shelf");
		System.out.println("Test Failed - C1729658");
		TestBase.addResultForTestCase("1729658", 1, "");
	}
	waitUntilVisible(page.getLibraryScreen().getBtnBack());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBack());
}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}


//@Test(priority=15)
public void manageContentInShelf() throws Exception

{	
	try
	{
	waitUntilVisible(page.getLibraryScreen().getTxtTabShelves());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtTabShelves());
	Thread.sleep(3500);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getTxtShelfNameNewYear());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtShelfNameNewYear());
	Thread.sleep(3000);
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnManageContent());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnManageContent());
	waitUntilVisible(page.getLibraryScreen().getImgCoverPosition3Shelf());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverPosition3Shelf());
	waitUntilVisible(page.getLibraryScreen().getBtnDoneShelf());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnDoneShelf());
	waitUntilVisible(page.getLibraryScreen().getTxtShelfNewYear2Contents());
	if(isElementDisplayed(page.getLibraryScreen().getTxtShelfNewYear2Contents()))
	{
		System.out.println("Library: Shelves tab - Manage content in shelf");
		System.out.println("Test Passed - C1729659");
		TestBase.addResultForTestCase("1729659", 1, "");
		
	}
	else
	{
		System.out.println("Library: Shelves tab - Manage content in shelf");
		System.out.println("Test Failed - C1729659");
		TestBase.addResultForTestCase("1729659", 5, "");
	}
	if(isElementDisplayed(page.getLibraryScreen().getBtnBack()))
	{
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBack());
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
	
}
//@Test(priority=16)
public void deleteShelf() throws Exception

{	
	try
	{
	waitUntilVisible(page.getLibraryScreen().getTxtTabShelves());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtTabShelves());
	Thread.sleep(3500);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getTxtShelfNameNewYear());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtShelfNameNewYear());
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnDeleteShelf());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnDeleteShelf());
	waitUntilVisible(page.getLibraryScreen().getBtnConfirmDelete());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnConfirmDelete());
	if(isElementDisplayed(page.getLibraryScreen().getTxtShelfNameNewYear())!=true)
	{
		System.out.println("Library: Shelves tab - Delete shelf");
		System.out.println("Test Passed - C1729657");
		TestBase.addResultForTestCase("1729657", 1, "");
	}
	else
	{
		System.out.println("Library: Shelves tab - Delete shelf");
		System.out.println("Test Failed - C1729657");
		TestBase.addResultForTestCase("1729657", 5, "");
	}
	waitUntilVisible(page.getLibraryScreen().getTxtTabAllTitles());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtTabAllTitles());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
	
}
//@Test(priority=17)
public void markAsCompleted() throws Exception
{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnManageProgress());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnManageProgress());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByMagazines());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByMagazines());
	waitUntilVisible(page.getLibraryScreen().getImgCoverTimeMagazineManageProgress());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverTimeMagazineManageProgress());
	waitUntilVisible(page.getLibraryScreen().getBtnCompletedManageProgress());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCompletedManageProgress());
	waitUntilVisible(page.getLibraryScreen().getBtnConfirm());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnConfirm());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByMagazines());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByMagazines());
	waitUntilVisible(page.getLibraryScreen().getBtnGridView());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnGridView());
	waitUntilVisible(page.getLibraryScreen().getImgCompletedBadge());
    if(isElementDisplayed(page.getLibraryScreen().getImgCompletedBadge()))
    {
		System.out.println("Library: Manage Progress - Mark as Completed");
    	System.out.println("Test Passed - C1735164");
		TestBase.addResultForTestCase("1735164", 1, "");
    }
    else
    {
		System.out.println("Library: Manage Progress - Mark as Completed");
    	System.out.println("Test Failed - C1735164");
		TestBase.addResultForTestCase("1735164", 5, "");
    }
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getBtnGridView());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnGridView());

	}
	
}

//@Test(priority=18)
public void markAsNotStarted() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnManageProgress());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnManageProgress());
	waitUntilVisible(page.getLibraryScreen().getTxtTabMarkAsNotStarted());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtTabMarkAsNotStarted());
	waitUntilVisible(page.getLibraryScreen().getImgCoverTimeMagazineManageProgress());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverTimeMagazineManageProgress());
	waitUntilVisible(page.getLibraryScreen().getBtnNotStarted());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnNotStarted());
	waitUntilVisible(page.getLibraryScreen().getBtnConfirm());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnConfirm());
	waitUntilVisible(page.getLibraryScreen().getImgCoverTimeMagazineManageProgress());
    if(isElementDisplayed(page.getLibraryScreen().getImgCompletedBadge())!=true)
    {
		System.out.println("Library: Manage Progress - Mark as Not Started");
    	System.out.println("Test Passed - C1735165");
		TestBase.addResultForTestCase("1735165", 1, "");
    }
    else
    {
		System.out.println("Library: Manage Progress - Mark as Not Started");
    	System.out.println("Test Failed - C1735165");
		TestBase.addResultForTestCase("1735165", 5, "");
    }
    waitUntilVisible(page.getLibraryScreen().getBtnListView());
    touchAtCenterOfElement(page.getLibraryScreen().getBtnListView());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
	
}
//@Test(priority=19)
public void unreadItemsOnlyEnable() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByAllTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByAllTypes());
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnLibrarySettings());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnLibrarySettings());
	String btnstat=page.getLibraryScreen().getBtnUnreadItemsOnly().getAttribute("value");
	System.out.println(btnstat);
	boolean unread=btnstat.equalsIgnoreCase("0");
	if(unread)
	{
		waitUntilVisible(page.getLibraryScreen().getBtnUnreadItemsOnly());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnUnreadItemsOnly());
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
		
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnManageProgress());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnManageProgress());
	waitUntilVisible(page.getLibraryScreen().getImgCoverTimeMagazineManageProgress());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverTimeMagazineManageProgress());
	waitUntilVisible(page.getLibraryScreen().getBtnCompletedManageProgress());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCompletedManageProgress());
	waitUntilVisible(page.getLibraryScreen().getBtnConfirm());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnConfirm());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByMagazines());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByMagazines());
	Thread.sleep(3000);
	if(isElementDisplayed(page.getLibraryScreen().getImgCoverTimeMagazineManageProgress())!=true)
	{
		System.out.println("Library: Settings - Enable \"\"Unread Items Only\"\"");
		System.out.println("Test Passed - C1736710");
		TestBase.addResultForTestCase("1736710", 1, "");
	}
	else
	{
		System.out.println("Library: Settings - Enable \"\"Unread Items Only\"\"");
		System.out.println("Test Failed - C1736710");
		TestBase.addResultForTestCase("1736710", 5, "");
	}

	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
	
}
//@Test(priority=20)
public void unreadItemsOnlyDisable() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnLibrarySettings());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnLibrarySettings());
	String btnstat1=page.getLibraryScreen().getBtnUnreadItemsOnly().getAttribute("value");
	System.out.println(btnstat1);
	boolean unread1=btnstat1.equalsIgnoreCase("1");
	if(unread1)
	{
		waitUntilVisible(page.getLibraryScreen().getBtnUnreadItemsOnly());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnUnreadItemsOnly());
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
		
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnManageProgress());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnManageProgress());
	waitUntilVisible(page.getLibraryScreen().getTxtTabMarkAsNotStarted());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtTabMarkAsNotStarted());
	waitUntilVisible(page.getLibraryScreen().getImgCoverTimeMagazineManageProgress());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverTimeMagazineManageProgress());
	waitUntilVisible(page.getLibraryScreen().getBtnNotStarted());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnNotStarted());
	waitUntilVisible(page.getLibraryScreen().getBtnConfirm());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnConfirm());
	waitUntilVisible(page.getLibraryScreen().getImgCoverTimeMagazineManageProgress());
	if(isElementDisplayed(page.getLibraryScreen().getImgCoverTimeMagazineManageProgress()))
	{
		System.out.println("Library: Settings - Disable \"\"Unread Items Only\"\"");
		System.out.println("Test Passed - C1736709");
		TestBase.addResultForTestCase("1736709", 1, "");
	}
	else
	{
		System.out.println("Library: Settings - Disable \"\"Unread Items Only\"\"");
		System.out.println("Test Failed - C1736709");
		TestBase.addResultForTestCase("1736709", 5, "");
	}
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByAllTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByAllTypes());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
}
}


//@Test(priority=21)
public void downloadedItemsOnlyEnable() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnLibrarySettings());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnLibrarySettings());
	String download=page.getLibraryScreen().getSwcDownloadedItemsOnly().getAttribute("value");
	System.out.println(download);
	boolean download1=download.equalsIgnoreCase("0");
	if(download1)
	{
		waitUntilVisible(page.getLibraryScreen().getSwcDownloadedItemsOnly());
		touchAtCenterOfElement(page.getLibraryScreen().getSwcDownloadedItemsOnly());
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
		
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	if(isElementDisplayed(page.getLibraryScreen().getImgCloudIconLibrary())!=true)
	{
		System.out.println("Library: Settings - Enable \"\"Downloaded Items Only\"\"");
		System.out.println("Test Passed - C1736703");
		TestBase.addResultForTestCase("1736703", 1, "");
	}
	else
	{
		System.out.println("Library: Settings - Enable \"\"Downloaded Items Only\"\"");
		System.out.println("Test Failed - C1736703");
		TestBase.addResultForTestCase("1736703", 5, "");
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}

//@Test(priority=22)
public void downloadedItemsOnlyDiable() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnLibrarySettings());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnLibrarySettings());
	String download11=page.getLibraryScreen().getSwcDownloadedItemsOnly().getAttribute("value");
	System.out.println(download11);
	boolean downloading=download11.equalsIgnoreCase("1");
	if(downloading)
	{
		waitUntilVisible(page.getLibraryScreen().getSwcDownloadedItemsOnly());
		touchAtCenterOfElement(page.getLibraryScreen().getSwcDownloadedItemsOnly());
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
		
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	if(isElementDisplayed(page.getLibraryScreen().getImgCloudIconLibrary())==true)
	{
		System.out.println("Library: Settings - Disable \"\"Downloaded Items Only\"\"");
		System.out.println("Test Passed - C1736706");
		TestBase.addResultForTestCase("1736706", 1, "");
	}
	else
	{
		System.out.println("Library: Settings - Disable \"\"Downloaded Items Only\"\"");
		System.out.println("Test Failed - C1736706");
		TestBase.addResultForTestCase("1736706", 5, "");
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}

//@Test(priority=23)
public void AnnotatedItemsOnlyEnable() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnLibrarySettings());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnLibrarySettings());
	String annotate=page.getLibraryScreen().getSwcAnnotatedItemsOnly().getAttribute("value");
	System.out.println(annotate);
	boolean annotated=annotate.equalsIgnoreCase("0");
	if(annotated)
	{
		waitUntilVisible(page.getLibraryScreen().getSwcAnnotatedItemsOnly());
		touchAtCenterOfElement(page.getLibraryScreen().getSwcAnnotatedItemsOnly());
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByKids());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByKids());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	if(isElementDisplayed(page.getLibraryScreen().getImgCoverMinniesValentine())!=true)
	{
		System.out.println("Library: Settings - Enable \"\"Annotated Item Only\"\"");
		System.out.println("Test Passed - C1736711");
		TestBase.addResultForTestCase("1736711", 1, "");
	}
	else
	{
		System.out.println("Library: Settings - Enable \"\"Annotated Item Only\"\"");
		System.out.println("Test Failed - C1736711");
		TestBase.addResultForTestCase("1736711", 5, "");
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}

//@Test(priority=24)
public void AnnotatedItemsOnlyDisable() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnLibrarySettings());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnLibrarySettings());
	String annotate1=page.getLibraryScreen().getSwcAnnotatedItemsOnly().getAttribute("value");
	System.out.println(annotate1);
	boolean annotated1=annotate1.equalsIgnoreCase("1");
	if(annotated1)
	{
		waitUntilVisible(page.getLibraryScreen().getSwcAnnotatedItemsOnly());
		touchAtCenterOfElement(page.getLibraryScreen().getSwcAnnotatedItemsOnly());
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	waitUntilVisible(page.getLibraryScreen().getImgCoverMinniesValentine());
	if(isElementDisplayed(page.getLibraryScreen().getImgCoverMinniesValentine())==true)
	{
		System.out.println("Library: Settings - Disable  \"\"Annotated Item Only\"\"");
		System.out.println("Test Passed - C1736712");
		TestBase.addResultForTestCase("1736712", 1, "");
	}
	else
	{
		System.out.println("Library: Settings - Disable  \"\"Annotated Item Only\"\"");
		System.out.println("Test Failed - C1736712");
		TestBase.addResultForTestCase("1736712", 5, "");
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=25)
public void showSamplesEnable() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnLibrarySettings());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnLibrarySettings());
	String showsamp=page.getLibraryScreen().getSwcShowSamples().getAttribute("value");
	System.out.println(showsamp);
	boolean showsamples=showsamp.equalsIgnoreCase("1");
	if(showsamples)
	{

		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getSwcShowSamples());
		touchAtCenterOfElement(page.getLibraryScreen().getSwcShowSamples());
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	waitUntilVisible(page.getLibraryScreen().getImgCoverWimpyKid());
	if(isElementDisplayed(page.getLibraryScreen().getImgCoverWimpyKid())==true)
	{
		System.out.println("Library: Settings - Enable \"\"Show Samples\"\"");
		System.out.println("Test Passed - C1736707");
		TestBase.addResultForTestCase("1736707", 1, "");
	}
	else
	{
		System.out.println("Library: Settings - Enable \"\"Show Samples\"\"");
		System.out.println("Test Failed - C1736707");
		TestBase.addResultForTestCase("1736707", 5, "");
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=26)
public void showSamplesDisable() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnLibrarySettings());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnLibrarySettings());
	String showsamp1=page.getLibraryScreen().getSwcShowSamples().getAttribute("value");
	System.out.println(showsamp1);
	boolean showsamples1=showsamp1.equalsIgnoreCase("0");
	if(showsamples1)
	{

		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getSwcShowSamples());
		touchAtCenterOfElement(page.getLibraryScreen().getSwcShowSamples());
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	if(isElementDisplayed(page.getLibraryScreen().getImgCoverWimpyKid())!=true)
	{
		System.out.println("Library: Settings - Disable \"\"Show Samples\"\"");
		System.out.println("Test Passed - C1736704");
		TestBase.addResultForTestCase("1736704", 1, "");
	}
	else
	{
		System.out.println("Library: Settings - Disable \"\"Show Samples\"\"");
		System.out.println("Test Failed - C1736704");
		TestBase.addResultForTestCase("1736704", 5, "");
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}

//@Test(priority=27)
public void showShelvedItemsEnable() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnLibrarySettings());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnLibrarySettings());
	String showsamp2=page.getLibraryScreen().getSwcShowSamples().getAttribute("value");
	System.out.println(showsamp2);
	boolean showsamples2=showsamp2.equalsIgnoreCase("1");
	if(showsamples2)
	{

		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getSwcShowSamples());
		touchAtCenterOfElement(page.getLibraryScreen().getSwcShowSamples());
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByAllTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByAllTypes());
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnLibrarySettings());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnLibrarySettings());
	String showitems=page.getLibraryScreen().getSwcShowItemsInShelves().getAttribute("value");
	System.out.println(showitems);
	boolean showit=showitems.equalsIgnoreCase("1");
	if(showit)
	{

		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getSwcShowItemsInShelves());
		touchAtCenterOfElement(page.getLibraryScreen().getSwcShowItemsInShelves());
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByMagazines());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByMagazines());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	if(isElementDisplayed(page.getLibraryScreen().getImgCoverTimeMagazineManageProgress())==true)
	{
		System.out.println("Library: Settings - Enable \"\"Show Shelved Items\"\"");
		System.out.println("Test Passed - C1736708");
		TestBase.addResultForTestCase("1736708", 1, "");
	}
	else
	{
		System.out.println("Library: Settings - Enable \"\"Show Shelved Items\"\"");
		System.out.println("Test Failed - C1736708");
		TestBase.addResultForTestCase("1736708", 5, "");
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=28)
public void showShelvedItemsDisable() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnLibrarySettings());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnLibrarySettings());
	String showitems1=page.getLibraryScreen().getSwcShowItemsInShelves().getAttribute("value");
	System.out.println(showitems1);
	boolean showit1=showitems1.equalsIgnoreCase("1");
	if(showit1)
	{
		waitUntilVisible(page.getLibraryScreen().getSwcShowItemsInShelves());
		touchAtCenterOfElement(page.getLibraryScreen().getSwcShowItemsInShelves());
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	if(isElementDisplayed(page.getLibraryScreen().getImgCoverTimeMagazineManageProgress())!=true)
	{
		System.out.println("Library: Settings - Disable \"\"Show Shelved Items\"\"");
		System.out.println("Test Passed - C1736705");
		TestBase.addResultForTestCase("1736705", 1, "");
	}
	else
	{
		System.out.println("Library: Settings - Disable \"\"Show Shelved Items\"\"");
		System.out.println("Test Failed - C1736705");
		TestBase.addResultForTestCase("1736705", 5, "");
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=29)
public void searchInLibraryAndBookstore() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnLibrarySettings());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnLibrarySettings());
	String showitems11=page.getLibraryScreen().getSwcShowItemsInShelves().getAttribute("value");
	System.out.println(showitems11);
	boolean showit11=showitems11.equalsIgnoreCase("1");
	if(showit11)
	{
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getSwcShowItemsInShelves());
		touchAtCenterOfElement(page.getLibraryScreen().getSwcShowItemsInShelves());
		waitUntilVisible(page.getLibraryScreen().getImgDismissLibrarySettings());
		touchAtCenterOfElement(page.getLibraryScreen().getImgDismissLibrarySettings());
	}
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByAllTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByAllTypes());
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getBtnViewResults());
	boolean boy=isElementDisplayed(page.getLibraryScreen().getImgCoverBoyfriendEffectSearchLib());
	boolean boy1=isElementDisplayed(page.getLibraryScreen().getImgCoverBoyfriendEffectSearchLibLongPress());
	boolean viewres=isElementDisplayed(page.getLibraryScreen().getBtnViewResults());
	if(boy1||boy&&viewres)
	{
		System.out.println(boy);
		System.out.println(viewres);
		System.out.println("Lib Result & View Results Displayed");
		waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavEbooks());
	//Dont Show Again Tip
	//if(isElementDisplayed(page.getBookstoreScreen().getdo))
	waitUntilVisible(page.getBookstoreScreen().getBtnSearch());
	touchAtCenterOfElement(page.getBookstoreScreen().getBtnSearch());
	sendKeys("School");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	Thread.sleep(7000);
	waitUntilVisible(page.getBookstoreScreen().getImgCoverBookstoreResults());
	boolean filter=isElementDisplayed(page.getLibraryScreen().getTxtFilterMediaTypes());
	boolean resultsBookstore=isElementDisplayed(page.getBookstoreScreen().getImgCoverBookstoreResults());
	boolean btnlistorgrid=isElementDisplayed(page.getLibraryScreen().getBtnListView());
	if(filter&&resultsBookstore&&btnlistorgrid)
	{
		System.out.println("Search: Search in Library and Bookstore");
		System.out.println("Test Passed - C1697666");
		TestBase.addResultForTestCase("1697666", 1, "");

	}
	else
	{
		System.out.println("Search: Search in Library and Bookstore");
		System.out.println("Test Failed - C1697666");
		TestBase.addResultForTestCase("1697666", 5, "");
	}
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}

//@Test(priority=30)
public void librarySignOut() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());	
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
	waitUntilVisible(page.getAccountScreen().getBtnFavoriteCategories());
	swipeScreen(Direction.UP);
	Thread.sleep(3000);
	waitUntilVisible(page.getAccountScreen().getBtnSignOut());
	touchAtCenterOfElement(page.getAccountScreen().getBtnSignOut());
	waitUntilVisible(page.getAccountScreen().getBtnOKSignout());
	touchAtCenterOfElement(page.getAccountScreen().getBtnOKSignout());
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
	}
}

//@Test(priority=31)
public void epubSignIn() throws Exception

{
	try
	{
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
	waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
	sendKeys("autacc_001@bn.com");
	waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
	sendKeys("Test1234");
	waitUntilVisible(page.getSignINScreen().getBtnLogin());
	touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
	waitUntilVisible(page.getSignINScreen().getBtnContinue());
	touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
	if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getSignINScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
	}
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
	waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	Thread.sleep(3000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(3000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}

//@Test(priority=32)
public void navigateByMargins() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	if (isElementDisplayed(page.getLibraryScreen().getImgCloudIconSearchLib())) {
		touchAtCenterOfElement(page.getLibraryScreen().getImgCloudIconSearchLib());
		Thread.sleep(50000);
		waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());

	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	}
	Thread.sleep(5000);
	if(isElementDisplayed(page.getReaderScreen().getImgSwipeTipLeftReader()))
	{
		swipeScreen(Direction.LEFT);
		Thread.sleep(3000);
		swipeScreen(Direction.RIGHT);
		waitUntilVisible(page.getReaderScreen().getImgCenterTapTip());
		touchAtCenterOfElement(page.getReaderScreen().getImgCenterTapTip());
	}
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnContents())!=true)
	{
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnContents());
	touchAtCenterOfElement(page.getReaderScreen().getBtnContents());
	waitUntilVisible(page.getReaderScreen().getTxtPage3BfEffect());
	touchAtCenterOfElement(page.getReaderScreen().getTxtPage3BfEffect());
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	tapRightSideofScreen();
	Thread.sleep(3000);
	tapRightSideofScreen();
	Thread.sleep(3000);
	tapLeftSideofScreen();
	Thread.sleep(3000);
	tapLeftSideofScreen();
	Thread.sleep(2500);
	touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	waitUntilVisible(page.getReaderScreen().getTxtPage3of12());
	if(isElementDisplayed(page.getReaderScreen().getTxtPage3of12()))
	{
		System.out.println("EPUB: Navigate by tapping margins");
		System.out.println("Test Passed - C1736720");
		TestBase.addResultForTestCase("1736720", 1, "");
	}
	else
	{	
		System.out.println("EPUB: Navigate by tapping margins");
		System.out.println("Test Failed - C1736720");
		TestBase.addResultForTestCase("1736720", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=33)
public void navigateBySwiping() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnContents());
	touchAtCenterOfElement(page.getReaderScreen().getBtnContents());
	waitUntilVisible(page.getReaderScreen().getTxtPage3BfEffect());
	touchAtCenterOfElement(page.getReaderScreen().getTxtPage3BfEffect());
	Thread.sleep(3000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	swipeScreen(Direction.LEFT);
	Thread.sleep(3000);
	swipeScreen(Direction.LEFT);
	Thread.sleep(3000);
	swipeScreen(Direction.RIGHT);
	Thread.sleep(3000);
	swipeScreen(Direction.RIGHT);
	Thread.sleep(3000);
	touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	waitUntilVisible(page.getReaderScreen().getTxtPage3of12());
	if(isElementDisplayed(page.getReaderScreen().getTxtPage3of12()))
	{
		System.out.println("EPUB: Navigate by swiping");
		System.out.println("Test Passed - C1736721");
		TestBase.addResultForTestCase("1736721", 1, "");
	}
	else
	{	
		System.out.println("EPUB: Navigate by swiping");
		System.out.println("Test Failed - C1736721");
		TestBase.addResultForTestCase("1736721", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=34)
public void gotoPage() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());;
	if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getReaderScreen().getBtnMoreOptions());
	waitUntilVisible(page.getReaderScreen().getBtnGoToPage());
	touchAtCenterOfElement(page.getReaderScreen().getBtnGoToPage());
	waitUntilVisible(page.getReaderScreen().getBtn7IosKeyboard());
	touchAtCenterOfElement(page.getReaderScreen().getBtn7IosKeyboard());
	waitUntilVisible(page.getReaderScreen().getBtnGoIosKeyboard());
	touchAtCenterOfElement(page.getReaderScreen().getBtnGoIosKeyboard());
	waitUntilVisible(page.getReaderScreen().getBtnBackToPrevPage());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToPrevPage());
	if(isElementDisplayed(page.getReaderScreen().getBtnContents())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getTxtPage3of12());
	if(isElementDisplayed(page.getReaderScreen().getTxtPage3of12()))
	{
		System.out.println("EPUB: Go Back to Page");
		System.out.println("Test Passed - C1736722");
		TestBase.addResultForTestCase("1736722", 1, "");
	}
	else
	{	
		System.out.println("EPUB: Go Back to Page");
		System.out.println("Test Failed - C1736722");
		TestBase.addResultForTestCase("1736722", 5, "");

	}
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=35)
public void addOrRemoveBookmarkOvrFlow() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getReaderScreen().getBtnMoreOptions());
	waitUntilVisible(page.getReaderScreen().getBtnAddBookmarkOverflow());
	touchAtCenterOfElement(page.getReaderScreen().getBtnAddBookmarkOverflow());
	waitUntilVisible(page.getReaderScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getReaderScreen().getBtnMoreOptions());
	waitUntilVisible(page.getReaderScreen().getBtnRemoveBookmarkOverflow());
	touchAtCenterOfElement(page.getReaderScreen().getBtnRemoveBookmarkOverflow());
	waitUntilVisible(page.getReaderScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getReaderScreen().getBtnMoreOptions());
	waitUntilVisible(page.getReaderScreen().getBtnAddBookmarkOverflow());
	if(isElementDisplayed(page.getReaderScreen().getBtnAddBookmarkOverflow()))
	{
		System.out.println("EPUB: Add/Remove Bookmark via overflow menu");
		System.out.println("Test Passed - C1736723");
		TestBase.addResultForTestCase("1736723", 1, "");
	}
	else
	{
		System.out.println("EPUB: Add/Remove Bookmark via overflow menu");
		System.out.println("Test Failed - C1736723");
		TestBase.addResultForTestCase("1736723", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getBtnCancel());
	touchAtCenterOfElement(page.getReaderScreen().getBtnCancel());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=36)
public void addOrRemoveBookmarkTapCorner() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnContents())==true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnAddBookmarkReader());
	touchAtCenterOfElement(page.getReaderScreen().getBtnAddBookmarkReader());
	waitUntilVisible(page.getReaderScreen().getBtnRemoveBookmarkReader());
	touchAtCenterOfElement(page.getReaderScreen().getBtnRemoveBookmarkReader());
	waitUntilVisible(page.getReaderScreen().getBtnAddBookmarkReader());
	if(isElementDisplayed(page.getReaderScreen().getBtnAddBookmarkReader()))
	{
		System.out.println("EPUB: Add/Remove Bookmark by tapping top-right corner");
		System.out.println("Test Passed - C1736724");
		TestBase.addResultForTestCase("1736724", 1, "");
	}
	else
	{
		System.out.println("EPUB: Add/Remove Bookmark by tapping top-right corner");
		System.out.println("Test Failed - C1736724");
		TestBase.addResultForTestCase("1736724", 5, "");
	}
	if(isElementDisplayed(page.getReaderScreen().getBtnContents())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}

//@Test(priority=37)
public void toc() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnContents())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnContents());
	touchAtCenterOfElement(page.getReaderScreen().getBtnContents());
	boolean tab1=isElementDisplayed(page.getReaderScreen().getTxtTabContents());
	boolean tab2=isElementDisplayed(page.getReaderScreen().getTxtTabBookmarks());
	boolean tab3=isElementDisplayed(page.getReaderScreen().getTxtTabAnnotations());
	if(tab1&&tab2&&tab3)
	{
		System.out.println("EPUB: Launch TOC (Table of Contents)");
		System.out.println("Test Passed - C1697671");
		TestBase.addResultForTestCase("1697671", 1, "");
	}
	else
	{
		System.out.println("EPUB: Launch TOC (Table of Contents)");
		System.out.println("Test Failed - C1697671");
		TestBase.addResultForTestCase("1697671", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getBtnCancelContentsTab());
	touchAtCenterOfElement(page.getReaderScreen().getBtnCancelContentsTab());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=38)
public void launchAllAnnotations() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnBack())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnContents());
	touchAtCenterOfElement(page.getReaderScreen().getBtnContents());
	waitUntilVisible(page.getReaderScreen().getTxtTabAnnotations());
	touchAtCenterOfElement(page.getReaderScreen().getTxtTabAnnotations());
	waitUntilVisible(page.getReaderScreen().getBtnSeeAnnotationsAcross());
	touchAtCenterOfElement(page.getReaderScreen().getBtnSeeAnnotationsAcross());
	waitUntilVisible(page.getReaderScreen().getBtnAnnotationIconsInSeeAnnotationAcross());
	if(isElementDisplayed(page.getReaderScreen().getBtnAnnotationIconsInSeeAnnotationAcross()))
	{
		System.out.println("EPUB: Launch All Annotations Page");
		System.out.println("Test Passed - C1736732");
		TestBase.addResultForTestCase("1736732", 1, "");
	}
	else
	{
		System.out.println("EPUB: Launch All Annotations Page");
		System.out.println("Test Failed - C1736732");
		TestBase.addResultForTestCase("1736732", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getBtnBack());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBack());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	if(isElementDisplayed(page.getLibraryScreen().getBtnCancelSearch()))
	{
		waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());	
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=39)
public void goToPage() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getReaderScreen().getBtnMoreOptions());
	waitUntilVisible(page.getReaderScreen().getBtnGoToPage());
	touchAtCenterOfElement(page.getReaderScreen().getBtnGoToPage());
	waitUntilVisible(page.getReaderScreen().getBtn3IosKeyboard());
	touchAtCenterOfElement(page.getReaderScreen().getBtn3IosKeyboard());
	waitUntilVisible(page.getReaderScreen().getBtnGoIosKeyboard());
	touchAtCenterOfElement(page.getReaderScreen().getBtnGoIosKeyboard());
	if(isElementDisplayed(page.getReaderScreen().getBtnContents())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getTxtPage3of12());
	if(isElementDisplayed(page.getReaderScreen().getTxtPage3of12()))
	{
		System.out.println("EPUB: Go to page");
		System.out.println("Test Passed - C1697676");
		TestBase.addResultForTestCase("1697676", 1, "");
	}
	else
	{	
		System.out.println("EPUB: Go to page");
		System.out.println("Test Failed - C1697676");
		TestBase.addResultForTestCase("1697676", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	if(isElementDisplayed(page.getLibraryScreen().getBtnCancelSearch()))
	{
		waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());	
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=40)
public void findInBook() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getReaderScreen().getBtnMoreOptions());
    waitUntilVisible(page.getReaderScreen().getBtnFindInBook());
    touchAtCenterOfElement(page.getReaderScreen().getBtnFindInBook());
    waitUntilVisible(page.getReaderScreen().getTxtBoxFindInBook());
    touchAtCenterOfElement(page.getReaderScreen().getTxtBoxFindInBook());
    Thread.sleep(3000);
    sendKeys("Boy");
    waitUntilVisible(page.getReaderScreen().getTxtPage2FindInBook());
    touchAtCenterOfElement(page.getReaderScreen().getTxtPage2FindInBook());
    waitUntilVisible(page.getReaderScreen().getTxtPage2of12Boyfriend());
    if(isElementDisplayed(page.getReaderScreen().getTxtPage2of12Boyfriend()))
    {
		System.out.println("EPUB: Find in Book");
    	System.out.println("Test Passed - C1697677");
		TestBase.addResultForTestCase("1697677", 1, "");

    }
    else
    {
		System.out.println("EPUB: Find in Book");
    	System.out.println("Test Passed - C1697677");
		TestBase.addResultForTestCase("1697677", 5, "");

    }
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	if(isElementDisplayed(page.getLibraryScreen().getBtnCancelSearch()))
	{
		waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());	
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=41)
public void viewDetails() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getReaderScreen().getBtnMoreOptions());
	waitUntilVisible(page.getReaderScreen().getBtnViewDetails());
	touchAtCenterOfElement(page.getReaderScreen().getBtnViewDetails());
	boolean overview1=isElementDisplayed(page.getPdpScreen().getTxtTtlOverview());
	boolean mov1=isElementDisplayed(page.getPdpScreen().getBtnMoveToCloud());
	boolean add1=isElementDisplayed(page.getPdpScreen().getBtnAddToWishlist());
	if(overview1&&mov1||add1)
	{
		System.out.println("EPUB: View Details");
		System.out.println("Test Passed - C1697678");
		TestBase.addResultForTestCase("1697678", 1, "");
	}
	else
	{
		System.out.println("EPUB: View Details");
		System.out.println("Test Failed - C1697678");
		TestBase.addResultForTestCase("1697678", 5, "");
	}
	waitUntilVisible(page.getPdpScreen().getBtnBack());
	touchAtCenterOfElement(page.getPdpScreen().getBtnBack());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=42)
public void readerSettings() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getReaderScreen().getBtnMoreOptions());
	waitUntilVisible(page.getReaderScreen().getBtnSettings());
	touchAtCenterOfElement(page.getReaderScreen().getBtnSettings());
	waitUntilVisible(page.getReaderScreen().getTxtReaderSettings());
	if(isElementDisplayed(page.getReaderScreen().getTxtReaderSettings()))
	{
		System.out.println("EPUB: Launch Reader Settings");
		System.out.println("Test Passed - C1736725");
		TestBase.addResultForTestCase("1736725", 1, "");
	}
	else
	{		
		System.out.println("EPUB: Launch Reader Settings");
		System.out.println("Test Failed - C1736725");
		TestBase.addResultForTestCase("1736725", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getBtnCloseReaderSettings());
	touchAtCenterOfElement(page.getReaderScreen().getBtnCloseReaderSettings());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
	
}
//@Test(priority=43)
public void changeTextSize() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnTextSettings());
	touchAtCenterOfElement(page.getReaderScreen().getBtnTextSettings());
	waitUntilVisible(page.getReaderScreen().getBtnIncreaseFontSize());
	touchAtCenterOfElement(page.getReaderScreen().getBtnIncreaseFontSize());
	waitUntilVisible(page.getReaderScreen().getBtnIncreaseFontSize5());
	if(isElementDisplayed(page.getReaderScreen().getBtnIncreaseFontSize5()))
	{
		System.out.println("EPUB: Change Text Size");
		System.out.println("Test Passed - C1729665");
		TestBase.addResultForTestCase("1729665", 1, "");
	}
	else
	{
		System.out.println("EPUB: Change Text Size");
		System.out.println("Test Failed - C1729665");
		TestBase.addResultForTestCase("1729665", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getBtnDecreaseFontSize());
	touchAtCenterOfElement(page.getReaderScreen().getBtnDecreaseFontSize());
	new TouchAction(driver).tap(PointOption.point(268, 550)).perform();
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=44)
public void changeTextFont() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnTextSettings());
	touchAtCenterOfElement(page.getReaderScreen().getBtnTextSettings());
	waitUntilVisible(page.getReaderScreen().getTxtOriginalFont());
	touchAtCenterOfElement(page.getReaderScreen().getTxtOriginalFont());
	waitUntilVisible(page.getReaderScreen().getTxtFontGeorgia());
	touchAtCenterOfElement(page.getReaderScreen().getTxtFontGeorgia());
	waitUntilVisible(page.getReaderScreen().getBtnBackFont());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackFont());
	waitUntilVisible(page.getReaderScreen().getTxtFontGeorgia());
	if(isElementDisplayed(page.getReaderScreen().getTxtFontGeorgia()))
	{
		System.out.println("EPUB: Change Text Font");
		System.out.println("Test Passed - C1729666");
		TestBase.addResultForTestCase("1729666", 1, "");
	}
	else
	{
		System.out.println("EPUB: Change Text Font");
		System.out.println("Test Failed - C1729666");
		TestBase.addResultForTestCase("1729666", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getTxtFontGeorgia());
	touchAtCenterOfElement(page.getReaderScreen().getTxtFontGeorgia());
	waitUntilVisible(page.getReaderScreen().getTxtOriginalFont());
	touchAtCenterOfElement(page.getReaderScreen().getTxtOriginalFont());
	waitUntilVisible(page.getReaderScreen().getBtnBackFont());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackFont());
	new TouchAction(driver).tap(PointOption.point(268, 550)).perform();
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=45)
public void changeTextMargins() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnTextSettings());
	touchAtCenterOfElement(page.getReaderScreen().getBtnTextSettings());
	waitUntilVisible(page.getReaderScreen().getTxtTabMargins());
	touchAtCenterOfElement(page.getReaderScreen().getTxtTabMargins());
	waitUntilVisible(page.getReaderScreen().getImgMargin3());
	touchAtCenterOfElement(page.getReaderScreen().getImgMargin3());
	String btnmar=page.getReaderScreen().getImgMargin3().getAttribute("value");
	System.out.println(btnmar);
	boolean margin=btnmar.equalsIgnoreCase("1");
	if(margin)
	{
        System.out.println("EPUB: Change Text Margins");
        System.out.println("Test passed - C1729667");
		TestBase.addResultForTestCase("1729667", 1, "");
	}
	else
	{
        System.out.println("EPUB: Change Text Margins");
		System.out.println("Test Failed - C1729667");
		TestBase.addResultForTestCase("1729667", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getImgMargin2());
	touchAtCenterOfElement(page.getReaderScreen().getImgMargin2());
	new TouchAction(driver).tap(PointOption.point(268, 550)).perform();
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=46)
public void changeTextLineSpacing() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnTextSettings());
	touchAtCenterOfElement(page.getReaderScreen().getBtnTextSettings());
	waitUntilVisible(page.getReaderScreen().getTxtTabLineSpacing());
	touchAtCenterOfElement(page.getReaderScreen().getTxtTabLineSpacing());
	waitUntilVisible(page.getReaderScreen().getImgLineSpacing1());
	touchAtCenterOfElement(page.getReaderScreen().getImgLineSpacing1());
	String btnline=page.getReaderScreen().getImgLineSpacing1().getAttribute("value");
	System.out.println(btnline);
	boolean line=btnline.equalsIgnoreCase("1");
	if(line)
	{
        System.out.println("EPUB: Change Text Line Spacing");
        System.out.println("Test passed - C1729668");
		TestBase.addResultForTestCase("1729668", 1, "");
	}
	else
	{
        System.out.println("EPUB: Change Text Line Spacing");
		System.out.println("Test Failed - C1729668");
		TestBase.addResultForTestCase("1729668", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getImgLineSpacing2());
	touchAtCenterOfElement(page.getReaderScreen().getImgLineSpacing2());
	new TouchAction(driver).tap(PointOption.point(268, 550)).perform();
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=47)
public void changeTextJustification() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
	{
		waitUntilVisible(page.getReaderScreen().getImgReaderView());
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnTextSettings());
	touchAtCenterOfElement(page.getReaderScreen().getBtnTextSettings());
	waitUntilVisible(page.getReaderScreen().getTxtTabJustification());
	touchAtCenterOfElement(page.getReaderScreen().getTxtTabJustification());
	waitUntilVisible(page.getReaderScreen().getImgJustify3());
	touchAtCenterOfElement(page.getReaderScreen().getImgJustify3());
	String btnjust=page.getReaderScreen().getImgJustify3().getAttribute("value");
	System.out.println(btnjust);
	boolean just=btnjust.equalsIgnoreCase("1");
	if(just)
	{
        System.out.println("EPUB: Change Text Justification");
        System.out.println("Test passed - C1729669");
		TestBase.addResultForTestCase("1729669", 1, "");
	}
	else
	{
        System.out.println("EPUB: Change Text Justification");
		System.out.println("Test Failed - C1729669");
		TestBase.addResultForTestCase("1729669", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getImgJustify2());
	touchAtCenterOfElement(page.getReaderScreen().getImgJustify2());
	new TouchAction(driver).tap(PointOption.point(268, 550)).perform();
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=48)
public void lastReadPage() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnContents())!=true)
	{
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnContents());
	touchAtCenterOfElement(page.getReaderScreen().getBtnContents());
	waitUntilVisible(page.getReaderScreen().getTxtTabContents());
	touchAtCenterOfElement(page.getReaderScreen().getTxtTabContents());
	waitUntilVisible(page.getReaderScreen().getTxtPage3BfEffect());
	touchAtCenterOfElement(page.getReaderScreen().getTxtPage3BfEffect());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Boyfriend");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverBfEffect());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverBfEffect());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnContents())!=true)
	{
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getTxtPage3of12());
	if(isElementDisplayed(page.getReaderScreen().getTxtPage3of12()))
	{
		System.out.println("EPUB: Keep LRP (Last Read Page)");
		System.out.println("Test Passed - C1697680");
		TestBase.addResultForTestCase("1697680", 1, "");
	}
	else
	{	
		System.out.println("EPUB: Keep LRP (Last Read Page)");
		System.out.println("Test Failed - C1697680");
		TestBase.addResultForTestCase("1697680", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=49)
public void eob() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Saltwater");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib());
	if(isElementDisplayed(page.getLibraryScreen().getImgCloudIconSearchLib()))
	{
		waitUntilVisible(page.getLibraryScreen().getImgCloudIconSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib());
		//waitUntilInvisible(page.getLibraryScreen().getImgCheckMarkPng());
		Thread.sleep(50000);
		System.out.println("Download Complete");
		waitUntilVisible(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib());
	}
	if(isElementDisplayed(page.getReaderScreen().getImgReaderView())!=true)
	{
		waitUntilVisible(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib2());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib2());
	}
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
;
	if(isElementDisplayed(page.getReaderScreen().getImgSwipeTipLeftReader()))
	{
		swipeScreen(Direction.LEFT);
		Thread.sleep(3000);
		swipeScreen(Direction.RIGHT);
		waitUntilVisible(page.getReaderScreen().getImgCenterTapTip());
		touchAtCenterOfElement(page.getReaderScreen().getImgCenterTapTip());
	}
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnContents())!=true)
	{
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getReaderScreen().getBtnMoreOptions());
	waitUntilVisible(page.getReaderScreen().getBtnGoToPage());
	touchAtCenterOfElement(page.getReaderScreen().getBtnGoToPage());
	Thread.sleep(5000);
	sendKeys("176");
	waitUntilVisible(page.getReaderScreen().getBtnGoIosKeyboard());
	touchAtCenterOfElement(page.getReaderScreen().getBtnGoIosKeyboard());
	swipeScreen(Direction.LEFT);
	Thread.sleep(3000);
	boolean compcheck=isElementDisplayed(page.getReaderScreen().getTxtTitleSaltWaterEob());
	if(compcheck)
	{
		touchAtCenterOfElement(page.getReaderScreen().getBtnBack());
	}
	Thread.sleep(5000);
	swipeScreen(Direction.LEFT);
	Thread.sleep(3000);
	waitUntilVisible(page.getReaderScreen().getTxtTitleSaltWaterEob());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibraryEob());
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Saltwater");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib());
	if(isElementDisplayed(page.getLibraryScreen().getImgCloudIconSearchLib()))
	{
		waitUntilVisible(page.getLibraryScreen().getImgCloudIconSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCloudIconSearchLib());
		waitUntilInvisible(page.getLibraryScreen().getImgCancelDownloadSearchLib());
		waitUntilVisible(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib());
	}
	Thread.sleep(5000);
	if(isElementDisplayed(page.getReaderScreen().getImgSwipeTipLeftReader()))
	{
		swipeScreen(Direction.LEFT);
		Thread.sleep(3000);
		swipeScreen(Direction.RIGHT);
		waitUntilVisible(page.getReaderScreen().getImgCenterTapTip());
		touchAtCenterOfElement(page.getReaderScreen().getImgCenterTapTip());
	}
	waitUntilVisible(page.getReaderScreen().getImgReaderView());
	if(isElementDisplayed(page.getReaderScreen().getBtnContents())!=true)
	{
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getReaderScreen().getBtnMoreOptions());
	waitUntilVisible(page.getReaderScreen().getBtnGoToPage());
	touchAtCenterOfElement(page.getReaderScreen().getBtnGoToPage());
	Thread.sleep(5000);
	sendKeys("176");
	waitUntilVisible(page.getReaderScreen().getBtnGoIosKeyboard());
	touchAtCenterOfElement(page.getReaderScreen().getBtnGoIosKeyboard());
	Thread.sleep(3000);
	swipeScreen(Direction.LEFT);
	waitUntilVisible(page.getReaderScreen().getBtnMoveToCloudEob());
	touchAtCenterOfElement(page.getReaderScreen().getBtnMoveToCloudEob());
	waitUntilVisible(page.getReaderScreen().getBtnConfirmMoveToCloudEob());
	touchAtCenterOfElement(page.getReaderScreen().getBtnConfirmMoveToCloudEob());
	if(isElementDisplayed(page.getLibraryScreen().getBtnCancelSearch()))
	{
		waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Saltwater");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib());
	if(isElementDisplayed(page.getLibraryScreen().getImgCloudIconSearchLib()))
	{
		System.out.println("EPUB: EOB (End of Book)");
		System.out.println("Test Passed - C1734553");
		TestBase.addResultForTestCase("1734553", 1, "");
	}
	else
	{
		System.out.println("EPUB: EOB (End of Book)");
		System.out.println("Test Failed - C1734553");
		TestBase.addResultForTestCase("1734553", 5, "");
	}
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=50)
public void openAndReadPdf() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Defiance");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverSaltwaterCoveSearchLib());
	if(isElementDisplayed(page.getLibraryScreen().getImgCloudIconSearchLib()))
	{
		waitUntilVisible(page.getLibraryScreen().getImgCloudIconSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCloudIconSearchLib());
		waitUntilInvisible(page.getLibraryScreen().getImgCancelDownloadSearchLib());
		Thread.sleep(50000);
		System.out.println("Download Complete");
		waitUntilVisible(page.getLibraryScreen().getImgCoverDefianceSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverDefianceSearchLib());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgCoverDefianceSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverDefianceSearchLib());
	}
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
//	if(isElementDisplayed(page.getReaderScreen().getImgPdfReaderView())!=true)
//	{
//		waitUntilVisible(page.getLibraryScreen().getImgCoverDefianceSearchLib1());
//		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverDefianceSearchLib1());
//		waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
//	}
	swipeScreen(Direction.LEFT);
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
	if(isElementDisplayed(page.getReaderScreen().getImgPdfReaderView()))
	{
		System.out.println("PDF: Open and read");
		System.out.println("Test Passed - C1729648");
		TestBase.addResultForTestCase("1729648", 1, "");
	}
	else
	{
		System.out.println("PDF: Open and read");
		System.out.println("Test Failed - C1729648");
		TestBase.addResultForTestCase("1729648", 5, "");
	}
	if(isElementDisplayed(page.getReaderScreen().getBtnBackToLibrary())!=true)
	{
		touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=51)
public void epubSignOut() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
	waitUntilVisible(page.getAccountScreen().getBtnFavoriteCategories());
	swipeScreen(Direction.UP);
	Thread.sleep(3000);
	waitUntilVisible(page.getAccountScreen().getBtnSignOut());
	touchAtCenterOfElement(page.getAccountScreen().getBtnSignOut());
	waitUntilVisible(page.getAccountScreen().getBtnOKSignout());
	touchAtCenterOfElement(page.getAccountScreen().getBtnOKSignout());
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
	}
}
//@Test(priority=52)
public void drpSignIn() throws Exception

{
	try
	{
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
	waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
	sendKeys("autacc_001@bn.com");
	waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
	sendKeys("Test1234");
	waitUntilVisible(page.getSignINScreen().getBtnLogin());
	touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
	waitUntilVisible(page.getSignINScreen().getBtnContinue());
	touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
	if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getSignINScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
	}
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
	Thread.sleep(15000);
	waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	Thread.sleep(3000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(3000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=53)
public void drpNavigateBySwiping() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("2940160684147");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getTxtCoverTimeSearchLib());
	if(isElementDisplayed(page.getLibraryScreen().getImgCloudIconSearchLib()))
	{
		waitUntilVisible(page.getLibraryScreen().getImgCloudIconSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCloudIconSearchLib());
		waitUntilVisible(page.getLibraryScreen().getImgDownloadXMobile());
		waitUntilInvisible(page.getLibraryScreen().getImgXDownload());
		Thread.sleep(50000);
		System.out.println("Download Complete");
		waitUntilVisible(page.getLibraryScreen().getTxtCoverTimeSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getTxtCoverTimeSearchLib());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getTxtCoverTimeSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getTxtCoverTimeSearchLib());
	}
	Thread.sleep(5000);
	if(isElementDisplayed(page.getReaderScreen().getImgSwipeLeftTipMagazine()))
	{
		swipeScreen(Direction.LEFT);
		Thread.sleep(3000);
		swipeScreen(Direction.RIGHT);
		waitUntilVisible(page.getReaderScreen().getImgCenterTapTipMagazine());
		touchAtCenterOfElement(page.getReaderScreen().getImgCenterTapTipMagazine());
	}
	swipeScreen(Direction.LEFT);
	Thread.sleep(2500);
	swipeScreen(Direction.RIGHT);
	waitUntilVisible(page.getReaderScreen().getImgPage0Magazine());
	if(isElementDisplayed(page.getReaderScreen().getImgPage0Magazine()))
	{
		System.out.println("DRP: Navigate by swiping");
		System.out.println("Test Passed - C1697693");
		TestBase.addResultForTestCase("1697693", 1, "");
	}
	else
	{
		System.out.println("DRP: Navigate by swiping");
		System.out.println("Test Failed - C1697693");	
		TestBase.addResultForTestCase("1697693", 5, "");
	}
	touchAtCenterOfElement(page.getReaderScreen().getImgPage0Magazine());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=54)
public void addOOrRemoveBoomark() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("2940160684147");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverTime());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverTime());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgAddBookmarkDrp());
	touchAtCenterOfElement(page.getReaderScreen().getImgAddBookmarkDrp());
	waitUntilVisible(page.getReaderScreen().getImgRemoveBookmarkDrp());
	touchAtCenterOfElement(page.getReaderScreen().getImgRemoveBookmarkDrp());
	waitUntilVisible(page.getReaderScreen().getImgAddBookmarkDrp());
	if(isElementDisplayed(page.getReaderScreen().getImgAddBookmarkDrp()))
	{		
		System.out.println("DRP: Add/Remove Bookmark");
		System.out.println("Test Passed - C1697692");
		TestBase.addResultForTestCase("1697692", 1, "");
	}
	else
	{
		System.out.println("DRP: Add/Remove Bookmark");
		System.out.println("Test Failed - C1697692");
		TestBase.addResultForTestCase("1697692", 5, "");
	}
	touchAtCenterOfElement(page.getReaderScreen().getImgPage0Magazine());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=55)
public void drpArticleAndPageView() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("2940160684147");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getTxtCoverTimeSearchLib());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtCoverTimeSearchLib());
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
    if(isElementDisplayed(page.getReaderScreen().getBtnContentsDrp())!=true)
    {
	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
    }
	Thread.sleep(2000);
	waitUntilVisible(page.getReaderScreen().getBtnContentsDrp());
	touchAtCenterOfElement(page.getReaderScreen().getBtnContentsDrp());
	waitUntilVisible(page.getReaderScreen().getTxtTabContentsDrp());
	touchAtCenterOfElement(page.getReaderScreen().getTxtTabContentsDrp());
	waitUntilVisible(page.getReaderScreen().getTxtPage5Drp());
	touchAtCenterOfElement(page.getReaderScreen().getTxtPage5Drp());
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	waitUntilVisible(page.getReaderScreen().getBtnArticleView());
	touchAtCenterOfElement(page.getReaderScreen().getBtnArticleView());
	waitUntilVisible(page.getReaderScreen().getTxtTitleArticleView());
	touchAtCenterOfElement(page.getReaderScreen().getBtnCloseArticleView());
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
	if(isElementDisplayed(page.getReaderScreen().getImgPdfReaderView()))
	{
		System.out.println("DRP: ArticleView and PageView");
		System.out.println("Test Passed - C1697686");
		TestBase.addResultForTestCase("1697686", 1, "");
	}
	else
	{
		System.out.println("DRP: ArticleView and PageView");
		System.out.println("Test Failed - C1697686");
		TestBase.addResultForTestCase("1697686", 5, "");
	}
	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	waitUntilVisible(page.getReaderScreen().getBtnContentsDrp());
	touchAtCenterOfElement(page.getReaderScreen().getBtnContentsDrp());
	waitUntilVisible(page.getReaderScreen().getTxtTabContentsDrp());
	touchAtCenterOfElement(page.getReaderScreen().getTxtTabContentsDrp());
	waitUntilVisible(page.getReaderScreen().getTxtPage0Drp());
	touchAtCenterOfElement(page.getReaderScreen().getTxtPage0Drp());
	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	Thread.sleep(2000);
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=56)
public void drpTextSettingsForArticleView() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("2940160684147");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getTxtCoverTimeSearchLib());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtCoverTimeSearchLib());
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	waitUntilVisible(page.getReaderScreen().getBtnContentsDrp());
	touchAtCenterOfElement(page.getReaderScreen().getBtnContentsDrp());
	waitUntilVisible(page.getReaderScreen().getTxtTabContentsDrp());
	touchAtCenterOfElement(page.getReaderScreen().getTxtTabContentsDrp());
	waitUntilVisible(page.getReaderScreen().getTxtPage5Drp());
	touchAtCenterOfElement(page.getReaderScreen().getTxtPage5Drp());
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	waitUntilVisible(page.getReaderScreen().getBtnArticleView());
	touchAtCenterOfElement(page.getReaderScreen().getBtnArticleView());
	waitUntilVisible(page.getReaderScreen().getTxtTitleArticleView());
	touchAtCenterOfElement(page.getReaderScreen().getTxtTitleArticleView());
	waitUntilVisible(page.getReaderScreen().getBtnTextSettingsArticleView());
	touchAtCenterOfElement(page.getReaderScreen().getBtnTextSettingsArticleView());
	waitUntilVisible(page.getReaderScreen().getTxtFontGeorgia());
	touchAtCenterOfElement(page.getReaderScreen().getTxtFontGeorgia());
	waitUntilVisible(page.getReaderScreen().getTxtFontDutch());
	touchAtCenterOfElement(page.getReaderScreen().getTxtFontDutch());
	waitUntilVisible(page.getReaderScreen().getBtnBackFont());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackFont());
	boolean dutch=isElementDisplayed(page.getReaderScreen().getTxtFontDutch());
	if(dutch)
	{
		waitUntilVisible(page.getReaderScreen().getImgMargin3());
		touchAtCenterOfElement(page.getReaderScreen().getImgMargin3());
	}
	String btnmar77=page.getReaderScreen().getImgMargin3().getAttribute("value");
	System.out.println(btnmar77);
	boolean margin77=btnmar77.equalsIgnoreCase("1");
	if(margin77)
	{
		System.out.println("DRP: Text Settings for ArticleView");
		System.out.println("Test passed - C1697687");
		TestBase.addResultForTestCase("1697687", 1, "");
	}
	else
	{
		System.out.println("DRP: Text Settings for ArticleView");
		System.out.println("Test Failed - C1697687");
		TestBase.addResultForTestCase("1697687", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getImgMargin2());
	touchAtCenterOfElement(page.getReaderScreen().getImgMargin2());
	waitUntilVisible(page.getReaderScreen().getTxtFontDutch());
	touchAtCenterOfElement(page.getReaderScreen().getTxtFontDutch());
	waitUntilVisible(page.getReaderScreen().getTxtFontGeorgia());
	touchAtCenterOfElement(page.getReaderScreen().getTxtFontGeorgia());
	waitUntilVisible(page.getReaderScreen().getBtnBackFont());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackFont());
	new TouchAction(driver).tap(PointOption.point(268, 550)).perform();
	waitUntilVisible(page.getReaderScreen().getTxtTitleArticleView());
	touchAtCenterOfElement(page.getReaderScreen().getTxtTitleArticleView());
	waitUntilVisible(page.getReaderScreen().getTxtTitleArticleView());
	touchAtCenterOfElement(page.getReaderScreen().getBtnCloseArticleView());
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=57)
public void drpToc() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("2940160684147");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getTxtCoverTimeSearchLib());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtCoverTimeSearchLib());
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	waitUntilVisible(page.getReaderScreen().getBtnContentsDrp());
	touchAtCenterOfElement(page.getReaderScreen().getBtnContentsDrp());
	boolean tab1=isElementDisplayed(page.getReaderScreen().getTxtTabContentsDrp());
	boolean tab2=isElementDisplayed(page.getReaderScreen().getTxtTabBookmarks());
	if(tab1&&tab2)
	{
		waitUntilVisible(page.getReaderScreen().getTxtTabContentsDrp());
		touchAtCenterOfElement(page.getReaderScreen().getTxtTabContentsDrp());
	}
	waitUntilVisible(page.getReaderScreen().getTxtPage5Drp());
	touchAtCenterOfElement(page.getReaderScreen().getTxtPage5Drp());
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	if(isElementDisplayed(page.getReaderScreen().getTxtPage5DrpView()))
	{
		System.out.println("DRP: TOC (Table of Contents)");
		System.out.println("Test Passed - C1697685");
		TestBase.addResultForTestCase("1697685", 1, "");
	}
	else
	{
		System.out.println("DRP: TOC (Table of Contents)");
		System.out.println("Test Failed - C1697685");
		TestBase.addResultForTestCase("1697685", 5, "");
	}
	if(isElementDisplayed(page.getReaderScreen().getBtnContentsDrp())!=true){
		touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnContentsDrp());
	touchAtCenterOfElement(page.getReaderScreen().getBtnContentsDrp());
	waitUntilVisible(page.getReaderScreen().getTxtTabContentsDrp());
	touchAtCenterOfElement(page.getReaderScreen().getTxtTabContentsDrp());
	waitUntilVisible(page.getReaderScreen().getTxtPage0Drp());
	touchAtCenterOfElement(page.getReaderScreen().getTxtPage0Drp());
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=58)
public void drpViewDetails() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("2940160684147");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getTxtCoverTimeSearchLib());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtCoverTimeSearchLib());
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	waitUntilVisible(page.getReaderScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getReaderScreen().getBtnMoreOptions());
	waitUntilVisible(page.getReaderScreen().getBtnViewDetailsDrp());
	touchAtCenterOfElement(page.getReaderScreen().getBtnViewDetailsDrp());
	boolean overview77=isElementDisplayed(page.getPdpScreen().getTxtTtlOverview());
	boolean mov77=isElementDisplayed(page.getPdpScreen().getBtnMoveToCloud());
	boolean add77=isElementDisplayed(page.getPdpScreen().getBtnAddToWishlist());
	if(overview77&&mov77||add77)
	{
		System.out.println("DRP: View Details");
		System.out.println("Test Passed - C1736714");
		TestBase.addResultForTestCase("1736714", 1, "");
	}
	else
	{
		System.out.println("DRP: View Details");
		System.out.println("Test Failed - C1736714");
		TestBase.addResultForTestCase("1736714", 5, "");
	}
	waitUntilVisible(page.getPdpScreen().getBtnBack());
	touchAtCenterOfElement(page.getPdpScreen().getBtnBack());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=59)
public void drpLaunchSettings() throws Exception
{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("2940160684147");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getTxtCoverTimeSearchLib());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtCoverTimeSearchLib());
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	waitUntilVisible(page.getReaderScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getReaderScreen().getBtnMoreOptions());
	waitUntilVisible(page.getReaderScreen().getBtnSettings());
	touchAtCenterOfElement(page.getReaderScreen().getBtnSettings());
	waitUntilVisible(page.getReaderScreen().getTxtReaderSettings());
	if(isElementDisplayed(page.getReaderScreen().getTxtReaderSettings()))
	{
		System.out.println("DRP: Launch Settings");
		System.out.println("Test Passed - C1736715");
		TestBase.addResultForTestCase("1736715", 1, "");
	}
	else
	{		
		System.out.println("DRP: Launch Settings");
		System.out.println("Test Failed - C1736715");
		TestBase.addResultForTestCase("1736715", 5, "");
	}
	waitUntilVisible(page.getReaderScreen().getBtnCloseReaderSettings());
	touchAtCenterOfElement(page.getReaderScreen().getBtnCloseReaderSettings());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=60)
public void openDrpNewspaper() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("2940174390089");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	if(isElementDisplayed(page.getLibraryScreen().getImgCloudIconSearchLib()))
	{
		waitUntilVisible(page.getLibraryScreen().getImgCloudIconSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCloudIconSearchLib());
		Thread.sleep(50000);
		waitUntilVisible(page.getLibraryScreen().getImgCoverSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverSearchLib());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgCoverSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverSearchLib());
	}
	waitUntilVisible(page.getReaderScreen().getImgOnionReaderView());
	if(isElementDisplayed(page.getReaderScreen().getImgOnionReaderView()))
	{
		System.out.println("DRP Newspaper: Open DRP newspaper");
		System.out.println("Test Passed - C1736716");
		TestBase.addResultForTestCase("1736716", 1, "");
	}
	else
	{
		System.out.println("DRP Newspaper: Open DRP newspaper");
		System.out.println("Test Failed - C1736716");
		TestBase.addResultForTestCase("1736716", 5, "");
	}
	if(isElementDisplayed(page.getReaderScreen().getBtnBackToLibrary())!=true)
	{
		touchAtCenterOfElement(page.getReaderScreen().getImgOnionReaderView());
	}
	if(isElementDisplayed(page.getReaderScreen().getBtnBackToLibrary()))
	{
		waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
		touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	}
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
	
}
	
//@Test(priority=61)
public void openDrpComic() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("9780545820080");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	if(isElementDisplayed(page.getLibraryScreen().getImgCloudIconSearchLib()))
	{
		waitUntilVisible(page.getLibraryScreen().getImgCloudIconSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCloudIconSearchLib());
		waitUntilVisible(page.getLibraryScreen().getImgDownloadXMobile());
		waitUntilInvisible(page.getLibraryScreen().getImgXDownload());
		Thread.sleep(50000);
		waitUntilVisible(page.getLibraryScreen().getImgCoverSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverSearchLib());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgCoverSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverSearchLib());
	}
	Thread.sleep(5000);
	if(isElementDisplayed(page.getReaderScreen().getTxtTipZoomView()))
	{
		touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnZoomView());
	touchAtCenterOfElement(page.getReaderScreen().getBtnZoomView());
	Thread.sleep(3000);
	waitUntilVisible(page.getReaderScreen().getBtnZoomView());
	touchAtCenterOfElement(page.getReaderScreen().getBtnZoomView());
	if(isElementDisplayed(page.getReaderScreen().getBtnZoomView()))
	{
		System.out.println("DRP Comic: Open DRP Comic and ZoomView works");
		System.out.println("Test Passed - C1697696");
		TestBase.addResultForTestCase("1697696", 1, "");
	}
	else
	{
		System.out.println("DRP Comic: Open DRP Comic and ZoomView works");
		System.out.println("Test Failed - C1697696");
		TestBase.addResultForTestCase("1697696", 5, "");
	}
	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=62)
public void epub3OpenAndRead() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("Elephant Child");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	if(isElementDisplayed(page.getLibraryScreen().getImgCloudIconSearchLib()))
	{
		waitUntilVisible(page.getLibraryScreen().getImgCloudIconSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCloudIconSearchLib());
		waitUntilInvisible(page.getLibraryScreen().getImgCancelDownloadSearchLib());
		Thread.sleep(30000);
		waitUntilVisible(page.getLibraryScreen().getImgCoverElephantChild());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverElephantChild());
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgCoverElephantChild());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverElephantChild());
	}
	Thread.sleep(5000);
	waitUntilVisible(page.getReaderScreen().getImgElephantChildReaderView());
	if(isElementDisplayed(page.getReaderScreen().getImgElephantChildReaderView()))
	{
		System.out.println("EPUB3: Open and read");
		System.out.println("Test Passed - C1697709");
		TestBase.addResultForTestCase("1697709", 1, "");
	}
	else
	{
		System.out.println("EPUB3: Open and read");
		System.out.println("Test Failed - C1697709");
		TestBase.addResultForTestCase("1697709", 5, "");
	}
	Thread.sleep(5000);
	if(isElementDisplayed(page.getReaderScreen().getBtnBackToLibrary())!=true)
	{
		touchAtCenterOfElement(page.getReaderScreen().getImgElephantChildReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=63)
public void drpSignOut() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
	waitUntilVisible(page.getAccountScreen().getBtnFavoriteCategories());
	swipeScreen(Direction.UP);
	Thread.sleep(3000);
	waitUntilVisible(page.getAccountScreen().getBtnSignOut());
	touchAtCenterOfElement(page.getAccountScreen().getBtnSignOut());
	waitUntilVisible(page.getAccountScreen().getBtnOKSignout());
	touchAtCenterOfElement(page.getAccountScreen().getBtnOKSignout());
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
	}
}
//@Test(priority=64)
public void bookStoreSignIn() throws Exception

{
	try
	{
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
	waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
	sendKeys("autacc_001@bn.com");
	waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
	sendKeys("Test1234");
	waitUntilVisible(page.getSignINScreen().getBtnLogin());
	touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
	waitUntilVisible(page.getSignINScreen().getBtnContinue());
	touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
	if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getSignINScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
	}
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
	waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=65)
public void downloadFreeSampleBook() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavEbooks());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavEbooks());
	Thread.sleep(5000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavEbooks());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavEbooks());
	Thread.sleep(3000);
	if(isElementDisplayed(page.getBookstoreScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getBookstoreScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getBookstoreScreen().getBtnNotNow());
	}
	waitUntilVisible(page.getBookstoreScreen().getBtnSearch());
	touchAtCenterOfElement(page.getBookstoreScreen().getBtnSearch());
	waitUntilVisible(page.getBookstoreScreen().getTxtBoxSearchBookstore());
	touchAtCenterOfElement(page.getBookstoreScreen().getTxtBoxSearchBookstore());
	sendKeys("9780307414168");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getBookstoreScreen().getImgCoverIntensity());
	touchAtCenterOfElement(page.getBookstoreScreen().getImgCoverIntensity());
//	Thread.sleep(10000);
//	new TouchAction(driver).tap(PointOption.point(345, 660)).perform();
//	//Touch not working
//	Thread.sleep(5000);
    waitUntilVisible(page.getPdpScreen().getBtnFreeSample());
	touchAtCenterOfElement(page.getPdpScreen().getBtnFreeSample());
	//new TouchAction(driver).tap(PointOption.point(273, 409)).perform();
	waitUntilInvisible(page.getPdpScreen().getBtnCancelBy());
	Thread.sleep(15000);
	waitUntilVisible(page.getPdpScreen().getBtnReadSample());
	touchAtCenterOfElement(page.getPdpScreen().getBtnBack());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getImgCoverIntensity());
	if(isElementDisplayed(page.getLibraryScreen().getImgCoverIntensity()))
	{
		System.out.println("Bookstore: Download free sample book");
		System.out.println("Test Passed - C1697702");
		TestBase.addResultForTestCase("1697702", 1, "");
	}
	else
	{
		System.out.println("Bookstore: Download free sample book");
		System.out.println("Test Failed - C1697702");
		TestBase.addResultForTestCase("1697702", 5, "");
	}
	longPress(page.getLibraryScreen().getImgCoverIntensity());
	waitUntilVisible(page.getLibraryScreen().getBtnArchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnArchive());
	waitUntilVisible(page.getLibraryScreen().getBtnArchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnArchive());
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnViewArchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnViewArchive());
	waitUntilVisible(page.getLibraryScreen().getImgCoverIntensity());
	longPress(page.getLibraryScreen().getImgCoverIntensity());
	waitUntilVisible(page.getLibraryScreen().getBtnPermenantlyDelete());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnPermenantlyDelete());
	waitUntilVisible(page.getLibraryScreen().getBtnPermenantlyDelete());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnPermenantlyDelete());
	waitUntilVisible(page.getLibraryScreen().getBtnBack());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBack());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=66)
public void addBookToWishlist() throws Exception

{
	try
	{
		
	//Dont show this again tip
		
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavEbooks());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavEbooks());
	Thread.sleep(3000);
	if(isElementDisplayed(page.getBookstoreScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getBookstoreScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getBookstoreScreen().getBtnNotNow());
	}
	waitUntilVisible(page.getBookstoreScreen().getBtnSearch());
	touchAtCenterOfElement(page.getBookstoreScreen().getBtnSearch());
	waitUntilVisible(page.getBookstoreScreen().getTxtBoxSearchBookstore());
	touchAtCenterOfElement(page.getBookstoreScreen().getTxtBoxSearchBookstore());
	sendKeys("9780307414168");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getBookstoreScreen().getImgCoverIntensity());
	touchAtCenterOfElement(page.getBookstoreScreen().getImgCoverIntensity());
	waitUntilVisible(page.getPdpScreen().getBtnAddToWishlist());
	touchAtCenterOfElement(page.getPdpScreen().getBtnAddToWishlist());
	waitUntilVisible(page.getPdpScreen().getBtnOkWishlist());
	touchAtCenterOfElement(page.getPdpScreen().getBtnOkWishlist());
	touchAtCenterOfElement(page.getPdpScreen().getBtnBack());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	waitUntilVisible(page.getBookstoreScreen().getBtnWishlist());
	touchAtCenterOfElement(page.getBookstoreScreen().getBtnWishlist());
	waitUntilVisible(page.getBookstoreScreen().getImgCoverIntensity());
	if(isElementDisplayed(page.getBookstoreScreen().getImgCoverIntensity()))
	{
		System.out.println("BookStore: Add book to wishlist");
		System.out.println("Test Passed - C1736753");
		TestBase.addResultForTestCase("1736753", 1, "");
	}
	else
	{
		System.out.println("BookStore: Add book to wishlist");
		System.out.println("Test Failed - C1736753");
		TestBase.addResultForTestCase("1736753", 5, "");
	}
	longPress(page.getBookstoreScreen().getImgCoverIntensity());
	waitUntilVisible(page.getBookstoreScreen().getBtnRemoveFromWishlist());
	touchAtCenterOfElement(page.getBookstoreScreen().getBtnRemoveFromWishlist());
	if(isElementDisplayed(page.getPdpScreen().getBtnOkWishlist()))
	{
		waitUntilVisible(page.getPdpScreen().getBtnOkWishlist());
		touchAtCenterOfElement(page.getPdpScreen().getBtnOkWishlist());
	}
	waitUntilVisible(page.getPdpScreen().getBtnBack());
	touchAtCenterOfElement(page.getPdpScreen().getBtnBack());
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=67)
public void currentReadFromNavigationBar() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	sendKeys("2940160684147");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverTime1());
	if(isElementDisplayed(page.getLibraryScreen().getImgCloudIconSearchLib()))
	{
		waitUntilVisible(page.getLibraryScreen().getImgCloudIconSearchLib());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCloudIconSearchLib());
		waitUntilVisible(page.getLibraryScreen().getImgDownloadXMobile());
		waitUntilInvisible(page.getLibraryScreen().getImgXDownload());
		Thread.sleep(50000);
		System.out.println("Download Complete");
		waitUntilVisible(page.getLibraryScreen().getImgCoverTime1());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverTime1());
		
	}
	else
	{
		waitUntilVisible(page.getLibraryScreen().getImgCoverTime1());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverTime1());
	}
	Thread.sleep(5000);
	if(isElementDisplayed(page.getReaderScreen().getImgSwipeLeftTipMagazine()))
	{
		swipeScreen(Direction.LEFT);
		Thread.sleep(3000);
		swipeScreen(Direction.RIGHT);
		waitUntilVisible(page.getReaderScreen().getImgCenterTapTipMagazine());
		touchAtCenterOfElement(page.getReaderScreen().getImgCenterTapTipMagazine());
	}
	Thread.sleep(10000);
    if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
    { 
    	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
    	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
    }
	waitUntilVisible(page.getReaderScreen().getBtnContentsDrp());
	touchAtCenterOfElement(page.getReaderScreen().getBtnContentsDrp());
	waitUntilVisible(page.getReaderScreen().getTxtTabContentsDrp());
	touchAtCenterOfElement(page.getReaderScreen().getTxtTabContentsDrp());
	waitUntilVisible(page.getReaderScreen().getTxtPage5Drp());
	touchAtCenterOfElement(page.getReaderScreen().getTxtPage5Drp());
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavCurrentRead());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavCurrentRead());
	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
    if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
    { 
    	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
    	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
    }
	if(isElementDisplayed(page.getReaderScreen().getTxtPage5DrpView()))
	{
		System.out.println("Current Read from Bottom Navigation Bar");
		System.out.println("Test Passed - C1697657");
		TestBase.addResultForTestCase("1697657", 1, "");
	}
	else
	{
		System.out.println("Current Read from Bottom Navigation Bar");
		System.out.println("Test Failed - C1697657");
		TestBase.addResultForTestCase("1697657", 5, "");
	}
	Thread.sleep(5000);
	if(isElementDisplayed(page.getReaderScreen().getBtnBackToLibrary())!=true)
	{
    	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
	}
	waitUntilVisible(page.getReaderScreen().getBtnContentsDrp());
	touchAtCenterOfElement(page.getReaderScreen().getBtnContentsDrp());
	waitUntilVisible(page.getReaderScreen().getTxtTabContentsDrp());
	touchAtCenterOfElement(page.getReaderScreen().getTxtTabContentsDrp());
	waitUntilVisible(page.getReaderScreen().getTxtPage0Drp());
	touchAtCenterOfElement(page.getReaderScreen().getTxtPage0Drp());
    if(isElementDisplayed(page.getReaderScreen().getBtnMoreOptions())!=true)
    { 
    	waitUntilVisible(page.getReaderScreen().getImgPdfReaderView());
    	touchAtCenterOfElement(page.getReaderScreen().getImgPdfReaderView());
    }
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=68)
public void bookstoreSignOut() throws Exception
{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
	waitUntilVisible(page.getAccountScreen().getBtnFavoriteCategories());
//	driver.findElement(MobileBy.iOSNsPredicateString("scrollTo(\"name CONTAINS 'SIGN OUT'\")"));
	swipeScreen(Direction.UP);
	Thread.sleep(3000);
	waitUntilVisible(page.getAccountScreen().getBtnSignOut());
	touchAtCenterOfElement(page.getAccountScreen().getBtnSignOut());
	waitUntilVisible(page.getAccountScreen().getBtnOKSignout());
	touchAtCenterOfElement(page.getAccountScreen().getBtnOKSignout());
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
	}
}
//@Test(priority=69)
public void profileSignIn() throws Exception

{
	try
	{
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
	waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
	sendKeys("autacc_001@bn.com");
	waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
	sendKeys("Test1234");
	waitUntilVisible(page.getSignINScreen().getBtnLogin());
	touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
	waitUntilVisible(page.getSignINScreen().getBtnContinue());
	touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
	if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getSignINScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
	}
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
	waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	Thread.sleep(3000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(3000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());	
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
}
//@Test(priority=70)
public void enableOrDisablePasscode() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
	waitUntilVisible(page.getAccountScreen().getBtnManageProfiles());
	touchAtCenterOfElement(page.getAccountScreen().getBtnManageProfiles());
	if(isElementDisplayed(page.getAccountScreen().getBtnAddPasscodeLater()))
	{
		touchAtCenterOfElement(page.getAccountScreen().getBtnAddPasscodeLater());
		
	}
	waitUntilVisible(page.getAccountScreen().getBtnChildPasscode());
	touchAtCenterOfElement(page.getAccountScreen().getBtnChildPasscode());
	waitUntilVisible(page.getAccountScreen().getBtn0());
	touchAtCenterOfElement(page.getAccountScreen().getBtn0());
	Thread.sleep(2500);
	waitUntilVisible(page.getAccountScreen().getBtn0());
	touchAtCenterOfElement(page.getAccountScreen().getBtn0());
	Thread.sleep(2500);
	waitUntilVisible(page.getAccountScreen().getBtn0());
	touchAtCenterOfElement(page.getAccountScreen().getBtn0());
	Thread.sleep(2500);
	waitUntilVisible(page.getAccountScreen().getBtn0());
	touchAtCenterOfElement(page.getAccountScreen().getBtn0());
	Thread.sleep(2500);
	waitUntilVisible(page.getAccountScreen().getBtn0());
	touchAtCenterOfElement(page.getAccountScreen().getBtn0());
	Thread.sleep(2500);
	waitUntilVisible(page.getAccountScreen().getBtn0());
	touchAtCenterOfElement(page.getAccountScreen().getBtn0());
	Thread.sleep(2500);
	waitUntilVisible(page.getAccountScreen().getBtn0());
	touchAtCenterOfElement(page.getAccountScreen().getBtn0());
	Thread.sleep(2500);
	waitUntilVisible(page.getAccountScreen().getBtn0());
	touchAtCenterOfElement(page.getAccountScreen().getBtn0());
	Thread.sleep(2500);
	waitUntilVisible(page.getAccountScreen().getBtnChildPasscode());
	String child=page.getAccountScreen().getBtnChildPasscode().getAttribute("value");
	System.out.println(child);
	boolean passcode=child.equalsIgnoreCase("1");
	if(passcode)
	{
		System.out.println("Profile: Enable/Disable passcode in Profile");
		System.out.println("Test Passed - C1713394");
		TestBase.addResultForTestCase("1713394", 1, "");
	}
	else
	{
		System.out.println("Profile: Enable/Disable passcode in Profile");
		System.out.println("Test Failed - C1713394");
		TestBase.addResultForTestCase("1713394", 5, "");
	}
	waitUntilVisible(page.getAccountScreen().getBtnChildPasscode());
	touchAtCenterOfElement(page.getAccountScreen().getBtnChildPasscode());
	waitUntilVisible(page.getAccountScreen().getBtn0());
	touchAtCenterOfElement(page.getAccountScreen().getBtn0());
	Thread.sleep(2500);
	waitUntilVisible(page.getAccountScreen().getBtn0());
	touchAtCenterOfElement(page.getAccountScreen().getBtn0());
	Thread.sleep(2500);
	waitUntilVisible(page.getAccountScreen().getBtn0());
	touchAtCenterOfElement(page.getAccountScreen().getBtn0());
	Thread.sleep(2500);
	waitUntilVisible(page.getAccountScreen().getBtn0());
	touchAtCenterOfElement(page.getAccountScreen().getBtn0());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
		waitUntilVisible(page.getAccountScreen().getBtnManageProfiles());
		touchAtCenterOfElement(page.getAccountScreen().getBtnManageProfiles());
		if(isElementDisplayed(page.getAccountScreen().getBtnAddPasscodeLater()))
		{
			touchAtCenterOfElement(page.getAccountScreen().getBtnAddPasscodeLater());
			
		}
	}
}
//@Test(priority=71)
public void createNewProfile() throws Exception

{
	try
	{
	waitUntilVisible(page.getAccountScreen().getBtnAddProfile());
	touchAtCenterOfElement(page.getAccountScreen().getBtnAddProfile());
	waitUntilVisible(page.getAccountScreen().getTxtBoxProfileName());
	touchAtCenterOfElement(page.getAccountScreen().getTxtBoxProfileName());
	sendKeys("Test");
	waitUntilVisible(page.getAccountScreen().getBtnReturn());
	touchAtCenterOfElement(page.getAccountScreen().getBtnReturn());
	waitUntilVisible(page.getAccountScreen().getBtnCreateNewProfile());
	touchAtCenterOfElement(page.getAccountScreen().getBtnCreateNewProfile());
	waitUntilVisible(page.getAccountScreen().getTxtProfileTest());
	if(isElementDisplayed(page.getAccountScreen().getTxtProfileTest()))
	{
		System.out.println("Profile: Create new Profile");
		System.out.println("Test Passed - C1729643");
		TestBase.addResultForTestCase("1729643", 1, "");

	}
	else
	{
		System.out.println("Profile: Create new Profile");
		System.out.println("Test Failed - C1729643");
		TestBase.addResultForTestCase("1729643", 5, "");
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
		waitUntilVisible(page.getAccountScreen().getBtnManageProfiles());
		touchAtCenterOfElement(page.getAccountScreen().getBtnManageProfiles());
		if(isElementDisplayed(page.getAccountScreen().getBtnAddPasscodeLater()))
		{
			touchAtCenterOfElement(page.getAccountScreen().getBtnAddPasscodeLater());
			
		}
	}
}
//@Test(priority=72)
public void manageContentForProfile() throws Exception

{
	try
	{
	waitUntilVisible(page.getAccountScreen().getBtnEditTestProfile());
	touchAtCenterOfElement(page.getAccountScreen().getBtnEditTestProfile());
	waitUntilVisible(page.getAccountScreen().getBtnManageContent());
	touchAtCenterOfElement(page.getAccountScreen().getBtnManageContent());
	waitUntilVisible(page.getAccountScreen().getBtnDone());
	touchAtCenterOfElement(page.getAccountScreen().getBtnDone());
	String cont=page.getAccountScreen().getTxtNoOfContents().getAttribute("value");
	System.out.println(cont);
	boolean contents=cont.equalsIgnoreCase("980 visible items");
	if(contents)
	{
	    System.out.println("Profile: Manage content for Profile");
	    System.out.println("Test passed - C1697705");
		TestBase.addResultForTestCase("1697705", 1, "");
	}
	else
	{
	    System.out.println("Profile: Manage content for Profile");
		System.out.println("Test Failed - C1697705");
		TestBase.addResultForTestCase("1697705", 5, "");
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
		waitUntilVisible(page.getAccountScreen().getBtnManageProfiles());
		touchAtCenterOfElement(page.getAccountScreen().getBtnManageProfiles());
		if(isElementDisplayed(page.getAccountScreen().getBtnAddPasscodeLater()))
		{
			touchAtCenterOfElement(page.getAccountScreen().getBtnAddPasscodeLater());
			
		}
	}
}
//@Test(priority=73)
public void deleteProfile() throws Exception

{
	try
	{
	waitUntilVisible(page.getAccountScreen().getBtnEditTestProfile());
	touchAtCenterOfElement(page.getAccountScreen().getBtnEditTestProfile());
	waitUntilVisible(page.getAccountScreen().getBtnDeleteProfile());
	touchAtCenterOfElement(page.getAccountScreen().getBtnDeleteProfile());
	waitUntilVisible(page.getAccountScreen().getBtnOk());
	touchAtCenterOfElement(page.getAccountScreen().getBtnOk());
	if(isElementDisplayed(page.getAccountScreen().getBtnYes()))
	{
		touchAtCenterOfElement(page.getAccountScreen().getBtnYes());
	}
	if(isElementDisplayed(page.getAccountScreen().getTxtProfileTest())!=true)
	{
		System.out.println("Profile: Delete Profile");
		System.out.println("Test Passed - C1729644");
		TestBase.addResultForTestCase("1729644", 1, "");
	}
	else
	{
		System.out.println("Profile: Delete Profile");
		System.out.println("Test Failed - C1729644");
		TestBase.addResultForTestCase("1729644", 5, "");
	}
	waitUntilVisible(page.getAccountScreen().getBtnBack());
	touchAtCenterOfElement(page.getAccountScreen().getBtnBack());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
	}
}
//@Test(priority=74)
public void launchSettingsFromProfilePage() throws Exception

{
	try
	{
	waitUntilVisible(page.getAccountScreen().getBtnFavoriteCategories());
	Thread.sleep(3500);
	swipeScreen(Direction.UP);
	waitUntilVisible(page.getAccountScreen().getBtnAppSettings());
	touchAtCenterOfElement(page.getAccountScreen().getBtnAppSettings());
	waitUntilVisible(page.getAccountScreen().getTxtTitleAppSettings());
	if(isElementDisplayed(page.getAccountScreen().getTxtTitleAppSettings()))
	{
		System.out.println("Settings: Launch Settings from Profile page");
		System.out.println("Test Passed - C1736719");
		TestBase.addResultForTestCase("1736719", 1, "");
	}
	else
	{
		System.out.println("Settings: Launch Settings from Profile page");
		System.out.println("Test Failed - C1736719");
		TestBase.addResultForTestCase("1736719", 5, "");
	}
	waitUntilVisible(page.getAccountScreen().getBtnBack());
	touchAtCenterOfElement(page.getAccountScreen().getBtnBack());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		Thread.sleep(40000);
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(3000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
	}
}
//@Test(priority=75)
public void profileSignOut() throws Exception

{
	try
	{
	waitUntilVisible(page.getAccountScreen().getBtnSignOut());
	touchAtCenterOfElement(page.getAccountScreen().getBtnSignOut());
	waitUntilVisible(page.getAccountScreen().getBtnOKSignout());
	touchAtCenterOfElement(page.getAccountScreen().getBtnOKSignout());
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	if(isElementDisplayed(page.getSignINScreen().getBtnSignIn()))
	{
		System.out.println("Sign Out");
		System.out.println("Test Passed - C1697706");
		TestBase.addResultForTestCase("1697706", 1, "");
	}
	else
	{
		System.out.println("Sign Out");
		System.out.println("Test Failed - C1697706");
		TestBase.addResultForTestCase("1697706", 5, "");
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
	}
}
//@Test(priority=76)
public void audioBooksSignIn() throws Exception

{
	try
	{
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
	waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
	sendKeys("autacc_001@bn.com");
	waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
	sendKeys("Test1234");
	waitUntilVisible(page.getSignINScreen().getBtnLogin());
	touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
	waitUntilVisible(page.getSignINScreen().getBtnContinue());
	touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
	if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getSignINScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
	}
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
	waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	Thread.sleep(3000);
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	}
}
//@Test(priority=77)
public void archiveAudioBook() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByAudioBooks());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByAudioBooks());
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	waitUntilVisible(page.getLibraryScreen().getTxtBoxSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtBoxSearch());
	sendKeys("2940177163635");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getTxtCoverComeJoinUsSearchLib());
	longPress(page.getLibraryScreen().getTxtCoverComeJoinUsSearchLib());
	waitUntilVisible(page.getLibraryScreen().getBtnArchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnArchive());
	waitUntilVisible(page.getLibraryScreen().getBtnArchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnArchive());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
    waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnViewArchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnViewArchive());
	waitUntilVisible(page.getLibraryScreen().getImgCoverComeJoinUsABArchive());
	if(isElementDisplayed(page.getLibraryScreen().getImgCoverComeJoinUsABArchive()))
	{
		System.out.println("Archive an audiobook from Library");
		System.out.println("Test Passed - C1738321");
		TestBase.addResultForTestCase("1738321", 1, "");
	}
	else
	{
		System.out.println("Archive an audiobook from Library");
		System.out.println("Test Failed - C1738321");
		TestBase.addResultForTestCase("1738321", 5, "");
	}
	waitUntilVisible(page.getLibraryScreen().getImgCoverComeJoinUsABArchive());
	longPress(page.getLibraryScreen().getImgCoverComeJoinUsABArchive());
	waitUntilVisible(page.getLibraryScreen().getBtnUnarchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnUnarchive());
	waitUntilVisible(page.getLibraryScreen().getBtnUnarchive());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnUnarchive());
	waitUntilVisible(page.getLibraryScreen().getBtnBack());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBack());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	}
}
//@Test(priority=78)
public void createShelfWithBooksAndAb() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getTxtTabShelves());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtTabShelves());
	Thread.sleep(3500);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnAddShelf());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnAddShelf());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByBooks());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByBooks());
	waitUntilVisible(page.getLibraryScreen().getImgCoverPosition1Shelf());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverPosition1Shelf());
	waitUntilVisible(page.getLibraryScreen().getImgCoverPosition2Shelf());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverPosition2Shelf());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByAudioBooks());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByAudioBooks());
	waitUntilVisible(page.getLibraryScreen().getImgCoverPosition1Shelf());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverPosition1Shelf());
	waitUntilVisible(page.getLibraryScreen().getBtnNextShelfTab());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnNextShelfTab());
	sendKeys("Nook");
	waitUntilVisible(page.getLibraryScreen().getBtnSaveShelf());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSaveShelf());
	waitUntilVisible(page.getLibraryScreen().getTxtShelfNook());
	if(isElementDisplayed(page.getLibraryScreen().getTxtShelfNook()))
	{
		System.out.println("Create new shelf with Books and audio books");
		System.out.println("Test Passed - C1738322");
		TestBase.addResultForTestCase("1738322", 1, "");
	}
	else
	{
		System.out.println("Create new shelf with Books and audio books");
		System.out.println("Test Failed - C1738322");
		TestBase.addResultForTestCase("1738322", 5, "");
	}
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
		waitUntilVisible(page.getLibraryScreen().getTxtTabShelves());
		touchAtCenterOfElement(page.getLibraryScreen().getTxtTabShelves());
	}
}
//@Test(priority=79)
public void removeAbFromWishlist() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getTxtShelfNook());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtShelfNook());
	waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
	waitUntilVisible(page.getLibraryScreen().getBtnDeleteShelf());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnDeleteShelf());
	waitUntilVisible(page.getLibraryScreen().getBtnConfirmDelete());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnConfirmDelete());
	waitUntilVisible(page.getLibraryScreen().getTxtTabAllTitles());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtTabAllTitles());
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAudioBooks());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAudioBooks());
	Thread.sleep(5000);
	if(isElementDisplayed(page.getBookstoreScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getBookstoreScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getBookstoreScreen().getBtnNotNow());
	}
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAudioBooks());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAudioBooks());
	Thread.sleep(3000);
	if(isElementDisplayed(page.getBookstoreScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getBookstoreScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getBookstoreScreen().getBtnNotNow());
	}
	waitUntilVisible(page.getAudiobooksScreen().getBtnSearch());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnSearch());
	Thread.sleep(3000);
	sendKeys("2940175192859");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getAudiobooksScreen().getTxtCoverTakenByDragonKing());
	touchAtCenterOfElement(page.getAudiobooksScreen().getTxtCoverTakenByDragonKing());
	Thread.sleep(5000);
	waitUntilVisible(page.getPdpScreen().getBtnAddToWishlist());
	touchAtCenterOfElement(page.getPdpScreen().getBtnAddToWishlist());
	waitUntilVisible(page.getPdpScreen().getBtnOkWishlist());
	touchAtCenterOfElement(page.getPdpScreen().getBtnOkWishlist());
	touchAtCenterOfElement(page.getPdpScreen().getBtnBack());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	waitUntilVisible(page.getBookstoreScreen().getBtnWishlist());
	touchAtCenterOfElement(page.getBookstoreScreen().getBtnWishlist());
	waitUntilVisible(page.getAudiobooksScreen().getTxtCoverTakenByDragonKing());
	longPress(page.getAudiobooksScreen().getTxtCoverTakenByDragonKing());
	waitUntilVisible(page.getBookstoreScreen().getBtnRemoveFromWishlist());
	touchAtCenterOfElement(page.getBookstoreScreen().getBtnRemoveFromWishlist());
	if(isElementDisplayed(page.getPdpScreen().getBtnOkWishlist()))
	{
		waitUntilVisible(page.getPdpScreen().getBtnOkWishlist());
		touchAtCenterOfElement(page.getPdpScreen().getBtnOkWishlist());
	}
	if(isElementDisplayed(page.getAudiobooksScreen().getTxtCoverTakenByDragonKing())!=true)
	{
		System.out.println("verify it can remove audiobook from Wishlist list");
		System.out.println("Test Passed - C1738325");
		TestBase.addResultForTestCase("1738325", 1, "");

	}
	else
	{
		System.out.println("verify it can remove audiobook from Wishlist list");
		System.out.println("Test Failed - C1738325");
		TestBase.addResultForTestCase("1738325", 5, "");
	}
	waitUntilVisible(page.getPdpScreen().getBtnBack());
	touchAtCenterOfElement(page.getPdpScreen().getBtnBack());
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	}
}
//@Test(priority=80)
public void audiobookTutorial() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	waitUntilVisible(page.getLibraryScreen().getTxtBoxSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtBoxSearch());
	sendKeys("2940177163635");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getTxtCoverComeJoinUsSearchLib());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtCoverComeJoinUsSearchLib());
	waitUntilVisible(page.getAudiobooksScreen().getTxtWelcomeToAb());
	boolean welcome=isElementDisplayed(page.getAudiobooksScreen().getTxtWelcomeToAb());
	boolean lets=isElementDisplayed(page.getAudiobooksScreen().getBtnLetsGo());
	if(welcome&&lets)
	{
		System.out.println("Verify the audiobook tutorial  when first time play");
		System.out.println("Test Passed - C1738335");
		TestBase.addResultForTestCase("1738335", 1, "");
	}
	else
	{
		System.out.println("Verify the audiobook tutorial  when first time play");
		System.out.println("Test Failed - C1738335");	
		TestBase.addResultForTestCase("1738335", 5, "");
	}
	waitUntilVisible(page.getAudiobooksScreen().getBtnSkip());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnSkip());
	waitUntilVisible(page.getAudiobooksScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnMoreOptions());
	waitUntilVisible(page.getAudiobooksScreen().getBtnCloseAb());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnCloseAb());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	}
}
//@Test(priority=81)
public void playPauseFullPlayer() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	waitUntilVisible(page.getLibraryScreen().getTxtBoxSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtBoxSearch());
	sendKeys("2940177163635");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getTxtCoverComeJoinUsSearchLib());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtCoverComeJoinUsSearchLib());
	waitUntilVisible(page.getAudiobooksScreen().getBtnPause());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnPause());
	waitUntilVisible(page.getAudiobooksScreen().getBtnPlay());
	if(isElementDisplayed(page.getAudiobooksScreen().getBtnPlay()))
	{
		System.out.println("Verify the Play/ Pause in full player");
		System.out.println("Test Passed - C1738329");
		TestBase.addResultForTestCase("1738329", 1, "");
	}
	else
	{
		System.out.println("Verify the Play/ Pause in full player");
		System.out.println("Test Failed - C1738329");
		TestBase.addResultForTestCase("1738329", 5, "");
	}
	waitUntilVisible(page.getAudiobooksScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnMoreOptions());
	waitUntilVisible(page.getAudiobooksScreen().getBtnCloseAb());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnCloseAb());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	}
}
//@Test(priority=82)
public void overFlowMenuFullPlayer() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	waitUntilVisible(page.getLibraryScreen().getTxtBoxSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtBoxSearch());
	sendKeys("2940177163635");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getTxtCoverComeJoinUsSearchLib());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtCoverComeJoinUsSearchLib());
	waitUntilVisible(page.getAudiobooksScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnMoreOptions());
	boolean close = isElementDisplayed(page.getAudiobooksScreen().getBtnCloseAb());
	boolean viewdetails = isElementDisplayed(page.getAudiobooksScreen().getBtnViewDetails());
	if(close&&viewdetails)
	{
		touchAtCenterOfElement(page.getAudiobooksScreen().getBtnViewDetails());
	}
	waitUntilVisible(page.getAudiobooksScreen().getTxtOverView());
	if(isElementDisplayed(page.getAudiobooksScreen().getTxtOverView()))
	{
		System.out.println("Verify the overflow menu in full player");
		System.out.println("Test Passed - C1738332");
		TestBase.addResultForTestCase("1738332", 1, "");
	}
	else
	{
		System.out.println("Verify the overflow menu in full player");
		System.out.println("Test Failed - C1738332");
		TestBase.addResultForTestCase("1738332", 5, "");
	}
	waitUntilVisible(page.getPdpScreen().getBtnBack());
	touchAtCenterOfElement(page.getPdpScreen().getBtnBack());
	waitUntilVisible(page.getAudiobooksScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnMoreOptions());
	waitUntilVisible(page.getAudiobooksScreen().getBtnCloseAb());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnCloseAb());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	}
}
//@Test(priority=83)
public void playPauseMiniPlayer() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	waitUntilVisible(page.getLibraryScreen().getTxtBoxSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtBoxSearch());
	sendKeys("2940177163635");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getTxtCoverComeJoinUsSearchLib());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtCoverComeJoinUsSearchLib());
	waitUntilVisible(page.getAudiobooksScreen().getBtnPause());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnMinimize());
	waitUntilVisible(page.getAudiobooksScreen().getBtnPause());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnPause());
	waitUntilVisible(page.getAudiobooksScreen().getBtnPlay());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnPlay());
	waitUntilVisible(page.getAudiobooksScreen().getBtnPause());
	if(isElementDisplayed(page.getAudiobooksScreen().getBtnPause()))
	{
		System.out.println("Verify the Play/Pause from mini player");
		System.out.println("Test Passed - C1738336");
		TestBase.addResultForTestCase("1738336", 1, "");
	}
	else
	{
		System.out.println("Verify the Play/Pause from mini player");
		System.out.println("Test Failed - C1738336");
		TestBase.addResultForTestCase("1738336", 5, "");
	}
	waitUntilVisible(page.getLibraryScreen().getTxtCoverComeJoinUsSearchLib());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtCoverComeJoinUsSearchLib());
	waitUntilVisible(page.getAudiobooksScreen().getBtnMoreOptions());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnMoreOptions());
	waitUntilVisible(page.getAudiobooksScreen().getBtnCloseAb());
	touchAtCenterOfElement(page.getAudiobooksScreen().getBtnCloseAb());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	}
}
//@Test(priority=84)
public void singleDownloadAb() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearch());
	waitUntilVisible(page.getLibraryScreen().getTxtBoxSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtBoxSearch());
	sendKeys("2940175387439");
	waitUntilVisible(page.getLibraryScreen().getBtnSearchIosKeyboard());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnSearchIosKeyboard());
	waitUntilVisible(page.getLibraryScreen().getImgCoverTheBequest());
	if(isElementDisplayed(page.getLibraryScreen().getBtnListViewSearchLib()))
	{
		touchAtCenterOfElement(page.getLibraryScreen().getBtnListViewSearchLib());
	}
	waitUntilVisible(page.getLibraryScreen().getImgCloudIconSearchLibLstView());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCloudIconSearchLibLstView());
	Thread.sleep(4000);
	if(isElementDisplayed(page.getLibraryScreen().getBtnTapToPlay()))
	{
		System.out.println("Verify Single Download for audiobooks");
		System.out.println("Test Passed - C1738320");
		TestBase.addResultForTestCase("1738320", 1, "");
	}
	else
	{
		System.out.println("Verify Single Download for audiobooks");
		System.out.println("Test Failed - C1738320");
		TestBase.addResultForTestCase("1738320", 5, "");
	}
	waitUntilVisible(page.getLibraryScreen().getBtnCancelDownloadAB());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelDownloadAB());
	waitUntilVisible(page.getLibraryScreen().getBtnCancelSearch());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnCancelSearch());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("autacc_001@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	}
}
//@Test(priority=85)
public void abSignOut() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
	waitUntilVisible(page.getAccountScreen().getBtnFavoriteCategories());
	swipeScreen(Direction.UP);
	Thread.sleep(3000);
	waitUntilVisible(page.getAccountScreen().getBtnSignOut());
	touchAtCenterOfElement(page.getAccountScreen().getBtnSignOut());
	waitUntilVisible(page.getAccountScreen().getBtnOKSignout());
	touchAtCenterOfElement(page.getAccountScreen().getBtnOKSignout());
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
	}
}
//@Test(priority=86)
public void newlyAddedCasesSignIn() throws Exception

{
	try
	{
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
	waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
	sendKeys("aut_november07112024@bn.com");
	waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
	sendKeys("Test1234");
	waitUntilVisible(page.getSignINScreen().getBtnLogin());
	touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
	waitUntilVisible(page.getSignINScreen().getBtnContinue());
	touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
	if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getSignINScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
	}
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
	Thread.sleep(40000);
}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("aut_november07112024@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	}







}

//@Test(priority=87)
public void moveBulkToCloud() throws Exception

{
	try
	{
		waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
		touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
		waitUntilVisible(page.getLibraryScreen().getTxtFilterByBooks());
		touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByBooks());
		waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
		waitUntilVisible(page.getLibraryScreen().getBtnManageStorage());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnManageStorage());
		waitUntilVisible(page.getLibraryScreen().getImgCoverPosition1ManageStorage());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverPosition1ManageStorage());
		waitUntilVisible(page.getLibraryScreen().getImgCoverPosition2ManageStorage());
		touchAtCenterOfElement(page.getLibraryScreen().getImgCoverPosition2ManageStorage());
		waitUntilVisible(page.getLibraryScreen().getBtnMove2Items());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnMove2Items());
		waitUntilVisible(page.getLibraryScreen().getBtnMoveToCloud());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnMoveToCloud());
		waitUntilVisible(page.getLibraryScreen().getImgCloudIconSearchLibLstView());
		if(isElementDisplayed(page.getLibraryScreen().getImgCloudIconSearchLibLstView()))
		{
			System.out.println("Library: Manage Storage - Move bulk of downloaded items to Cloud");
			System.out.println("Test Passed - C1735166");
			TestBase.addResultForTestCase("1735166", 1, "");
		}
		else
		{
			System.out.println("Library: Manage Storage - Move bulk of downloaded items to Cloud");
			System.out.println("Test Failed - C1735166");
			TestBase.addResultForTestCase("1735166", 5, "");
		}	
		waitUntilVisible(page.getLibraryScreen().getBtnMoreOptions());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnMoreOptions());
		waitUntilVisible(page.getLibraryScreen().getBtnViewArchive());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnViewArchive());
		waitUntilVisible(page.getLibraryScreen().getBtnBack());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBack());
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
		waitUntilVisible(page.getAccountScreen().getBtnFavoriteCategories());
		swipeScreen(Direction.UP);
		Thread.sleep(3000);
		waitUntilVisible(page.getAccountScreen().getBtnSignOut());
		touchAtCenterOfElement(page.getAccountScreen().getBtnSignOut());
		waitUntilVisible(page.getAccountScreen().getBtnOKSignout());
		touchAtCenterOfElement(page.getAccountScreen().getBtnOKSignout());
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	
    }
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
	}



	}

//@Test(priority=88)
public void newlyAddedCasesReSignIn() throws Exception

{
	try
	{
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
	waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
	sendKeys("aut_november07112024@bn.com");
	waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
	sendKeys("Test1234");
	waitUntilVisible(page.getSignINScreen().getBtnLogin());
	touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
	waitUntilVisible(page.getSignINScreen().getBtnContinue());
	touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
	if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
	{
		waitUntilVisible(page.getSignINScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
	}
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
	Thread.sleep(40000);
}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("aut_november07112024@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	}
	
}

//@Test(priority=89)
public void accountOptionsCheck() throws Exception

{
	try
	{
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
		boolean daysreading = isElementDisplayed(page.getAccountScreen().getTxtDaysReading());
		boolean dayslistening = isElementDisplayed(page.getAccountScreen().getTxtDaysListening());
		boolean wishlist = isElementDisplayed(page.getAccountScreen().getTxtWishlist());
		boolean favcategories = isElementDisplayed(page.getAccountScreen().getTxtFavoriteCategories());
		boolean manageprofiles = isElementDisplayed(page.getAccountScreen().getTxtManageProfiles());
		boolean accsettings=isElementDisplayed(page.getAccountScreen().getTxtAccountSettings());
		boolean payments=isElementDisplayed(page.getAccountScreen().getTxtPayments());
		boolean appsettings=isElementDisplayed(page.getAccountScreen().getTxtAppSettings());
		if(daysreading&&dayslistening&&wishlist&&favcategories&&manageprofiles&&accsettings&&payments)
		{
			swipeScreen(Direction.UP);
			if(appsettings)
			{
				System.out.println("Account: Options check");
				System.out.println("Test Passed - C1746011");
				TestBase.addResultForTestCase("1746011", 1, "");
			}
			else
			{
				System.out.println("Account: Options check");
				System.out.println("Test Failed - C1746011");
				TestBase.addResultForTestCase("1746011", 5, "");
			}		
		}	
		
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
        Dimension size = driver.manage().window().getSize();
        int screenHeight = size.height;
        int screenWidth = size.width;

        // Scroll to halfway point
        int middleY = screenHeight / 2;
        int startX = screenWidth / 2;
        int endY = screenHeight / 4; 

        Point startPoint = new Point(startX, middleY);
        Point endPoint = new Point(startX, endY);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint.x, startPoint.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
                .release()
                .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
		waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
		sendKeys("aut_november07112024@bn.com");
		waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
		touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
		sendKeys("Test1234");
		waitUntilVisible(page.getSignINScreen().getBtnLogin());
		touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
		waitUntilVisible(page.getSignINScreen().getBtnContinue());
		touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
		if(isElementDisplayed(page.getSignINScreen().getBtnNotNow()))
		{
			waitUntilVisible(page.getSignINScreen().getBtnNotNow());
			touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
		}
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		Thread.sleep(7000);
		waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
		touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
		waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
		waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	}
	
	
}

//@Test(priority=90)
public void newlyAddedCasesSignOut() throws Exception

{
	try
	{
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
	waitUntilVisible(page.getAccountScreen().getBtnFavoriteCategories());
	swipeScreen(Direction.UP);
	Thread.sleep(3000);
	waitUntilVisible(page.getAccountScreen().getBtnSignOut());
	touchAtCenterOfElement(page.getAccountScreen().getBtnSignOut());
	waitUntilVisible(page.getAccountScreen().getBtnOKSignout());
	touchAtCenterOfElement(page.getAccountScreen().getBtnOKSignout());
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	}
	catch (Exception e) {
		getScreenshot();
		waitUntilVisible(page.getSignINScreen().getBtnSignIn());
		driver.terminateApp(bundleId);
		driver.activateApp("com.apple.Preferences");
		WebElement elementToScrollTo = driver.findElement(MobileBy.xpath("//XCUIElementTypeCell[@name=\"B&N NOOK\"]"));
		String elementId = ((RemoteWebElement) elementToScrollTo).getId();
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("element", elementId);
		scrollObject.put("toVisible", true);
		driver.executeScript("mobile:scroll", scrollObject);
		waitUntilVisible(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getTxtNookApplicationSettings());
		waitUntilVisible(page.getIosSettingsScreen().getTxtTitleBandNNook());

	     // Get screen dimensions
      Dimension size = driver.manage().window().getSize();
      int screenHeight = size.height;
      int screenWidth = size.width;

      // Scroll to halfway point
      int middleY = screenHeight / 2;
      int startX = screenWidth / 2;
      int endY = screenHeight / 4; 

      Point startPoint = new Point(startX, middleY);
      Point endPoint = new Point(startX, endY);

      TouchAction touchAction = new TouchAction(driver);
      touchAction.press(PointOption.point(startPoint.x, startPoint.y))
              .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
              .moveTo(PointOption.point(endPoint.x - startPoint.x, endPoint.y - startPoint.y))
              .release()
              .perform();
		waitUntilVisible(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnLogoutOnLaunch());
		waitUntilVisible(page.getIosSettingsScreen().getBtnBackIosSettings());
		touchAtCenterOfElement(page.getIosSettingsScreen().getBtnBackIosSettings());
		driver.activateApp(bundleId);
	}
}
























//dont uncomment or include this for now
 ////@Test(priority=8)
public void SideLoad() throws Exception
{
	 
	 //Make sure you have the same sideloaded contents in your Iphone.
	 //you can find the sideloaded contents under sideloaded folder in the project.
	 //use apple configurator to add sideloads to iphone, add it to the nook folder under files app in iphone.

	IOSDriver driver1 = (IOSDriver) driver;

	waitUntilVisible(page.getSignINScreen().getBtnSignIn());
	touchAtCenterOfElement(page.getSignINScreen().getBtnSignIn());
	waitUntilVisible(page.getSignINScreen().getTxtBoxEmailId());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxEmailId());
	sendKeys("autacc_001@bn.com");
	waitUntilVisible(page.getSignINScreen().getTxtBoxPassword());
	touchAtCenterOfElement(page.getSignINScreen().getTxtBoxPassword());
	sendKeys("Test1234");
	waitUntilVisible(page.getSignINScreen().getBtnLogin());
	touchAtCenterOfElement(page.getSignINScreen().getBtnLogin());
	waitUntilVisible(page.getSignINScreen().getBtnContinue());
	touchAtCenterOfElement(page.getSignINScreen().getBtnContinue());
	if (isElementDisplayed(page.getSignINScreen().getBtnNotNow())) {
		waitUntilVisible(page.getSignINScreen().getBtnNotNow());
		touchAtCenterOfElement(page.getSignINScreen().getBtnNotNow());
	}
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(7000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	waitUntilVisible(page.getLibraryScreen().getTxtTitleLibrary());
	waitUntilInvisible(page.getLibraryScreen().getImgcoverSyncingLibBy());
	Thread.sleep(3000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());
	Thread.sleep(3000);
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavLibrary());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavLibrary());

	
//	String workingDir = System.getProperty("user.dir");
//	String System_Path02 =System.getProperty("user.dir") + "/Sideloaded/";
//	System.out.println(System_Path02);
//	System.out.println(driver.getFileDetector().toString());
//	
//
//	driver1.pushFile("On My iPhone⁩/B&N NOOK", new File(System_Path02+"2940000920275_t1_epib.epub"));

	waitUntilVisible(page.getLibraryScreen().getTxtFilterMediaTypes());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterMediaTypes());
	waitUntilVisible(page.getLibraryScreen().getTxtFilterByMyFiles());
	touchAtCenterOfElement(page.getLibraryScreen().getTxtFilterByMyFiles());
	waitUntilVisible(page.getLibraryScreen().getImgCoverSideloadEpub());
	touchAtCenterOfElement(page.getLibraryScreen().getImgCoverSideloadEpub());
	Thread.sleep(3000);
	if (isElementDisplayed(page.getReaderScreen().getImgSwipeTipLeftReader())) {
		swipeScreen(Direction.LEFT);
		Thread.sleep(3000);
		swipeScreen(Direction.RIGHT);
		waitUntilVisible(page.getReaderScreen().getImgCenterTapTip());
		touchAtCenterOfElement(page.getReaderScreen().getImgCenterTapTip());
	}
	waitUntilVisible(page.getReaderScreen().getImgReaderViewSideload());
	if(isElementDisplayed(page.getReaderScreen().getImgReaderViewSideload()))
	{
		System.out.println("Sideload File: Open sideload EPUB/PDF file");
		System.out.println("Test Passed - C1697667");
		TestBase.addResultForTestCase("1697667", 1, "");

	}
	else
	{
		System.out.println("Sideload File: Open sideload EPUB/PDF file");
		System.out.println("Test Failed - C1697667");
		TestBase.addResultForTestCase("1697667", 5, "");

	}
	
	
	if (isElementDisplayed(page.getReaderScreen().getBtnContents()) != true) {
		touchAtCenterOfElement(page.getReaderScreen().getImgReaderViewSideload());
	}
	waitUntilVisible(page.getReaderScreen().getBtnBackToLibrary());
	touchAtCenterOfElement(page.getReaderScreen().getBtnBackToLibrary());
	waitUntilVisible(page.getLibraryScreen().getBtnBottomNavAccounts());
	touchAtCenterOfElement(page.getLibraryScreen().getBtnBottomNavAccounts());
	waitUntilVisible(page.getAccountScreen().getBtnFavoriteCategories());
//	driver.findElement(MobileBy.iOSNsPredicateString("scrollTo(\"name CONTAINS 'SIGN OUT'\")"));
	swipeScreen(Direction.UP);
	Thread.sleep(3000);
	waitUntilVisible(page.getAccountScreen().getBtnSignOut());
	touchAtCenterOfElement(page.getAccountScreen().getBtnSignOut());
	waitUntilVisible(page.getAccountScreen().getBtnOKSignout());
	touchAtCenterOfElement(page.getAccountScreen().getBtnOKSignout());
	waitUntilVisible(page.getSignINScreen().getBtnSignIn());


	
	
	
	
}










}


	

	
	
	
	
	
	
	

	
	
	



















	
	

	
	
	
	
	
	
	
	
	
	
