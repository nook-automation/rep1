package config;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import common.Property;
import functionalLibrary.TestBase;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Config extends TestBase{

	public static final int IMPLICIT_WAIT_IN_SECOND = 30;
	public static final int DEVICE_WAITING_MAX_TRY_TIMES = 5;
	public static final int DEVICE_WAITING_INTERVAL_IN_MS = 30000;
	public static String SERVER_TYPE = "";
	public static String SESSION_NAME = "";
	public static String BA_App_Version = "";
	public static String DEVICE_NAME = "";
	public static String PLATFORM_VERSION = "";
	public static String PLATFORM_NAME = "";
	public static String APP_VERSION = "";
	public static String UDID = "";
	public static String fileNameEpub = "";
	public static String fileNamePDF = "";
	public static String fileNameEpib = "";
	public static String From_System = "";
	public static String To_Device ="";
	public static String bundleId ="";
	
	public static void getPropertyValues() {
 		//String propertyFileName = System.getProperty("user.dir") + "/device_Input/general.properties";
		String propertyFileName = System.getProperty("user.dir") +File.separator+"device_Input"+File.separator+"general.properties";
		propertyMap = new Property().getMap(propertyFileName);

		SERVER_TYPE = propertyMap.get("serverType");
		SESSION_NAME = propertyMap.get("sessionName");
		BA_App_Version = propertyMap.get("BA_App_Version");
		DEVICE_NAME = propertyMap.get("DEVICE_NAME");
		PLATFORM_VERSION = propertyMap.get("PLATFORM_VERSION");
		PLATFORM_NAME = propertyMap.get("PLATFORM_NAME");
		UDID = propertyMap.get("UDID");
		APP_VERSION = propertyMap.get(APP_VERSION);
		fileNameEpub = propertyMap.get(fileNameEpub);
		fileNamePDF = propertyMap.get(fileNamePDF);
		fileNameEpib = propertyMap.get(fileNameEpib);
		From_System = propertyMap.get(From_System);
		To_Device = propertyMap.get(To_Device);
		bundleId = propertyMap.get(bundleId);
		
	}
	
	
	public static DesiredCapabilities getIphone() throws MalformedURLException {

		getPropertyValues();

		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		caps.setCapability(MobileCapabilityType.UDID, UDID);
		caps.setCapability("appium:automationName", "XCUITest");
		//caps.setCapability("bundleId", "com.bnenterprise.B-N-eReader");
		caps.setCapability("bundleId", bundleId);
		//caps.setCapability("appium:app", System.getProperty("user.dir") + "/Application/Ios.ipa");
		caps.setCapability("noReset", true);
		caps.setCapability("fullReset", false);
		return caps;

	}




		

	  
	  
	


	}

