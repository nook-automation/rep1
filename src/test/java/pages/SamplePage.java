package pages;

import org.openqa.selenium.support.PageFactory;

import functionalLibrary.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SamplePage extends TestBase{
	
	public SamplePage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SIGN IN\"]")
	private MobileElement btnSignIn;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"CREDENTIALS_EMAIL_TEXTFIELD\"]")
	private MobileElement TxtBoxEmailId;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"CREDENTIALS_PASSWORD_TEXTFIELD\"]")
	private MobileElement TxtBoxPassword;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SIGN IN\"]")
	private MobileElement btnLogin;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTINUE\"]")
	private MobileElement btnContinue;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"TUTORIAL_ONBOARDING_WELCOME_DONE_BUTTON\"]")
	private MobileElement btnNotNow;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tap here to sort or filter All Titles.\"]")
	private MobileElement TxtTip1Lib;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tap here to view more Library settings and view your Archive.\"]")
	private MobileElement TxtTip2Lib;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LIBRARY\"]")
	private MobileElement btnBottomNavLibrary;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ACCOUNT\"]")
	private MobileElement btnBottomNavAccounts;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SIGN OUT\"]")
	private MobileElement btnSignOut;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Favorite Categories\"]")
	private MobileElement btnFavoriteCategories;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
	private MobileElement btnOK;
	
	
	
	
	
	
	

	public MobileElement getBtnSignIn() {
		return btnSignIn;
	}

	public MobileElement getTxtBoxEmailId() {
		return TxtBoxEmailId;
	}

	public MobileElement getTxtBoxPassword() {
		return TxtBoxPassword;
	}

	public MobileElement getBtnLogin() {
		return btnLogin;
	}

	public MobileElement getBtnContinue() {
		return btnContinue;
	}

	public MobileElement getBtnNotNow() {
		return btnNotNow;
	}

	public MobileElement getTxtTip1Lib() {
		return TxtTip1Lib;
	}

	public MobileElement getTxtTip2Lib() {
		return TxtTip2Lib;
	}

	public MobileElement getBtnBottomNavLibrary() {
		return btnBottomNavLibrary;
	}

	public MobileElement getBtnBottomNavAccounts() {
		return btnBottomNavAccounts;
	}

	public MobileElement getBtnSignOut() {
		return btnSignOut;
	}

	public MobileElement getBtnFavoriteCategories() {
		return btnFavoriteCategories;
	}

	public MobileElement getBtnOK() {
		return btnOK;
	}
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	

