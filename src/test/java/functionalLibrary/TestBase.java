package functionalLibrary;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import api.APIClient;
import api.APIException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import tests.TestApp;




public class TestBase {
	
	public static String TEST_RUN_ID = "91648";
	public static String TESTRAIL_USERNAME = "Kvengattan@bn.com";
	public static String TESTRAIL_PASSWORD = "March2020";
	public static String RAILS_ENGINE_URL = "https://nook.testrail.com";
	public static final int TEST_CASE_PASSED_STATUS = 1;
	public static final int TEST_CASE_FAILED_STATUS = 5;
	public static final int TEST_CASE_RETEST = 4;
	public static final int TEST_CASE_NOTAPPLICABLE_STATUS = 6;
    public static AppiumDriver<MobileElement> driver;
	protected static HashMap<String, String> propertyMap;

	//Configuration method
	
	public void setup(DesiredCapabilities desiredCaps) throws MalformedURLException {

		  //DesiredCapabilities caps=new DesiredCapabilities();
		
//		  URL appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
//		  IOSDriver driver = new IOSDriver(appiumServerURL,desiredCaps);
		  
		  driver=new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723"),desiredCaps);
	}
	
	public void baseDriverwait(int waitTiming) {
		driver.manage().timeouts().implicitlyWait(waitTiming, TimeUnit.SECONDS);

	}
	

	
	@SuppressWarnings("rawtypes")
	public TouchAction touchAtCenterOfElement(MobileElement element) {

		System.out.println("Touch at Center Of Element");
		TouchAction action = new TouchAction(driver);
		action.tap(TapOptions.tapOptions().withElement(ElementOption.element(element)));
		action.perform();

		return action;
	}
	
	public boolean waitUntilVisible(MobileElement element) {

		boolean check;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(element));
			check = true;
		} catch (Exception e) {
			check = false;
		}
		return check;
	}
	
	@SuppressWarnings("deprecation")
	public void sendKeys(String keys) {
		System.out.println(String.format("Send keys: %s", keys));

		driver.getKeyboard().sendKeys(keys);

	}
	
	public enum Direction {
		UP, DOWN, LEFT, RIGHT;
	}
	
	@SuppressWarnings("rawtypes")
	public void swipeScreen(Direction dir) {
		System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

		// Animation default time:
		// - Android: 300 ms
		// - iOS: 200 ms
		// final value depends on your app and could be greater
		final int ANIMATION_TIME = 200; // ms

		final int PRESS_TIME = 200; // ms

		int edgeBorder = 5; // better avoid edges
		PointOption pointOptionStart, pointOptionEnd;

		// init screen variables
		Dimension dims = driver.manage().window().getSize();

		// init start point = center of screen
		pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

		switch (dir) {
		case DOWN: // center of footer
			pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
			break;
		case UP: // center of header
			pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
			break;
		case LEFT: // center of left side
			pointOptionEnd = PointOption.point((edgeBorder / 2), dims.height / 2);
			break;
		case RIGHT: // center of right side
			pointOptionEnd = PointOption.point(dims.width - (edgeBorder / 2), dims.height / 2);
			break;
		default:
			throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
		}

		// execute swipe using TouchAction
		try {
			new TouchAction(driver).press(pointOptionStart)
					// a bit more reliable when we add small wait
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME))).moveTo(pointOptionEnd).release()
					.perform();
		} catch (Exception e) {
			System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
			return;
		}

		// always allow swipe action to complete
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
			// ignore
		}
	}
	
	
	public void scrollToMobileElement(MobileElement element, String direction) {

		
	    final int maximumScrolls = 5;

	    for (int i = 0; i < maximumScrolls; i++) {
	        try {
	            if (findElementsByPredicateString("label CONTAINS \"" + element + "\"").size() > 0)
	            // PredicateString & label is the locator strategy that I used. It can be changed to others as needed for your app.
	                break;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        scroll(direction);
	    }
	}

	private void scroll(String direction) {
	    final HashMap<String, String> scrollObject = new HashMap<String, String>();
	    scrollObject.put("direction", direction);
	    driver.executeScript("mobile:scroll", scrollObject);
	}

	public List<MobileElement> findElementsByPredicateString(String predicateString) {
	    return driver.findElements(MobileBy.iOSNsPredicateString(predicateString));
	}
	
	public static void textCheck(String txt) {
	    // Create an ArrayList of texts to check
	    List<String> textsToCheck = new ArrayList<>();
	    textsToCheck.add(txt);
	    textsToCheck.add(txt);
	    textsToCheck.add(txt);

	    // Check each text in the ArrayList
	    for (String text : textsToCheck) {
	        // Create XPath using the text
	        String xpath = "//*[@text='" + text + "']";
	        List<MobileElement> elements = driver.findElements(By.xpath(xpath));

	        // Check if the element exists
	        if (!elements.isEmpty()) {
	            System.out.println("Element with text '" + text + "' found.");
	        } else {
	            System.out.println("Element with text '" + text + "' not found.");
	        }
	    }
	}
	
	
	
	
	
	public boolean isElementDisplayed(MobileElement element) {
		boolean check = false;
		try {
			boolean displayed = element.isDisplayed();
			if (displayed == true) {
				check = true;
			} else {
				check = false;
			}
		} catch (Exception ex) {
			check = false;
		}
		return check;
	}
	
	
	public boolean isElementDisplayed (By locator){

		MobileElement element = driver.findElement(locator);
		boolean check = false;
		try {
			boolean displayed = element.isDisplayed();
			if (displayed == true) {
				check = true;
			} else {
				check = false;
			}
		} catch (Exception ex) {
			check = false;
		}
		return check;
		
	}
	
	public boolean waitUntilInvisible(By locator) {

		boolean check = false;
		try {
			boolean element = isElementDisplayed(locator);
			if (element == true) {
				System.out.println("Element Found");
				WebDriverWait wait = new WebDriverWait(driver, 350);
				Boolean until = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
				check = until;
			} else if (element == false) {
				System.out.println("Wait to Invisible of the Element is not Located");
				check = false;
			}
		} catch (Exception e) {
			
		}
		return check;
	}
	
	

	public class IOSKeyHandler {

	    public  void main(String[] args) {
	        try {
	            press(IOS_PRESS_TYPES.ENTER);
	            // You can call press() with other IOS_PRESS_TYPES as needed
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void press(IOS_PRESS_TYPES type) throws Exception {
	        System.out.println(String.format("Press on %s key", type));

	        switch (type) {
	            case HOME:
	                pressIOSKey("HomeKey");
	                break;

	            case BACK:
	                pressIOSKey("BackKey");
	                break;

	            case POWER:
	                pressIOSKey("PowerKey");
	                break;

	            case APP_SWITCH:
	                pressIOSKey("AppSwitchKey");
	                break;

	            case ENTER:
	                pressIOSKey("EnterKey");
	                break;

	            case DELETE:
	                pressIOSKey("DeleteKey");
	                break;

	            default:
	                throw new Exception(String.format("Don't support press %s key on iOS", type));
	        }
	    }

	    private void pressIOSKey(String key) {
	        // Implement the logic to simulate key press on iOS
	        System.out.println(String.format("Simulating key press on iOS: %s", key));
	        // You would need to use the appropriate API or library for iOS automation
	    }
	}

	// Enum definition
	public enum IOS_PRESS_TYPES {
	    HOME, BACK, POWER, APP_SWITCH, ENTER, DELETE
	}
	
	
	public static String date() {
		DateFormat dateFormat = new SimpleDateFormat("ddMM");
		Date date = new Date();
		String dt = String.valueOf(dateFormat.format(date));
		// Calendar cal = Calendar.getInstance();
		SimpleDateFormat time = new SimpleDateFormat("HHmmss");
		String tm = String.valueOf(time.format(new Date()));// time in 24 hour format
		String id = dt + tm;
		return id;
	}
	
	public void longPress(MobileElement element) {

//		AndroidTouchAction touch = new AndroidTouchAction(driver);
//		touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element))).perform();

		
		@SuppressWarnings("rawtypes")
		TouchAction touchAction=new TouchAction(driver);
		touchAction.longPress((LongPressOptions.longPressOptions().withElement(ElementOption.element(element)))).release().perform();
		System.out.println("LongPressed Tapped");

	}
	
	@SuppressWarnings("rawtypes")
	public void tapLeftSideofScreen() {
		Dimension size = driver.manage().window().getSize();
		int yAxis = (int) (size.height * 0.50);
		int xAxis = (int) (size.width * 0.03);

		new TouchAction(driver).tap(PointOption.point(xAxis, yAxis)).perform();

		System.out.println("Tap Left Side");
	}
	
	@SuppressWarnings("rawtypes")
	public void tapRightSideofScreen() {
		Dimension size = driver.manage().window().getSize();
		int yAxis = (int) (size.height * 0.50);
		int xAxis = (int) (size.width * 0.97);

		new TouchAction(driver).tap(PointOption.point(xAxis, yAxis)).perform();

		System.out.println("Tap Right Side");
	}
	

	public void testSeekBar(MobileElement element)throws  Exception

    {    
		// get start co-ordinate of seekbar
	    int start = element.getLocation().getX();
	    System.out.println(start);
	    // Get width of seekbar
	    int end = element.getSize().getWidth();
	    System.out.println(end);
	    // get location of seekbar vertically
	    int y = element.getLocation().getY();
	    System.out.println(start);

	    // Select till which position you want to move the seekbar
	    TouchAction action = new TouchAction(driver);

	    // Move it 40%
	    int moveToXDirectionAt = (int) (end * 0.4);
	    System.out.println("Moving seek bar at " + moveToXDirectionAt+" In X direction.");
	    action.longPress(PointOption.point(0, y)).moveTo(PointOption.point(moveToXDirectionAt, y)).release().perform();

}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void addResultForTestCase(String testCaseId, int status, String error)
			throws IOException, APIException {
		try {
			String testRunId = TEST_RUN_ID;

			APIClient client = new APIClient(RAILS_ENGINE_URL);
			client.setUser(TESTRAIL_USERNAME);
			client.setPassword(TESTRAIL_PASSWORD);
			Map data = new HashMap();

			data.put("status_id", status);
			data.put("comment", "Test Executed - Iphone 13 (Automation), Appversion - 6.7.2.6,"+"Test Run Date : "+date());
			client.sendPost("add_result_for_case/" + testRunId + "/" + testCaseId + "", data);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getStackTrace());
		}
	}

	public void getScreenshot() {
	    TakesScreenshot screenshot = (TakesScreenshot) driver;
	    File source = screenshot.getScreenshotAs(OutputType.FILE);
	    File targetDir = new File(System.getProperty("user.dir") + "/Screenshots");
	    if (!targetDir.exists()) {
	        targetDir.mkdirs();
	    }
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    File target = new File(targetDir, "screenshot_" + timestamp + ".png");

	    try {
	        FileUtils.copyFile(source, target);
	        System.out.println("Screenshot saved: " + target.getAbsolutePath());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
    public static void printMethodName() {
        // Get the current stack trace
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        
        // The method name will be the second element in the stack trace
        String methodName = stackTrace[2].getMethodName();
        
        // Print the method name
        System.out.println("Current method: " + methodName);
    }
    
}
	
	
	


 

    


	
	

