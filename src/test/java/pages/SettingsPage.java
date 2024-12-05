package pages;

import org.openqa.selenium.support.PageFactory;

import functionalLibrary.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SettingsPage extends TestBase{

	public SettingsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
	private MobileElement btnBack;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Library\"]")
	private MobileElement btnLibrary;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Download & Storage\"]")
	private MobileElement btnDownloadAndStorage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Reader\"]")
	private MobileElement btnReader;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Device Settings\"]")
	private MobileElement btnDeviceSettings;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Support & Help\"]")
	private MobileElement btnSupportAndHelp;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"FAQs\"]")
	private MobileElement btnFaqs;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Legal\"]")
	private MobileElement btnLegal;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Send Feedback\"]")
	private MobileElement btnSendFeedback;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"About\"]")
	private MobileElement btnAbout;
	
	
	
	
	

	public MobileElement getBtnBack() {
		return btnBack;
	}

	public MobileElement getBtnLibrary() {
		return btnLibrary;
	}

	public MobileElement getBtnDownloadAndStorage() {
		return btnDownloadAndStorage;
	}

	public MobileElement getBtnReader() {
		return btnReader;
	}

	public MobileElement getBtnDeviceSettings() {
		return btnDeviceSettings;
	}

	public MobileElement getBtnSupportAndHelp() {
		return btnSupportAndHelp;
	}

	public MobileElement getBtnFaqs() {
		return btnFaqs;
	}

	public MobileElement getBtnLegal() {
		return btnLegal;
	}

	public MobileElement getBtnSendFeedback() {
		return btnSendFeedback;
	}

	public MobileElement getBtnAbout() {
		return btnAbout;
	}
	
	
	
}
