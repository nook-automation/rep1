package pages;

import org.aspectj.weaver.ast.Test;
import org.openqa.selenium.support.PageFactory;

import functionalLibrary.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CreateAccountPage extends TestBase{
	
	public CreateAccountPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"First Name\"]")
	private MobileElement txtBoxFirstName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Last Name\"]")
	private MobileElement txtBoxLastName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Email\"]")
	private MobileElement txtBoxEmail;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField[@name=\"CREDENTIALS_PASSWORD_TEXTFIELD\"])[1]")
	private MobileElement txtBoxPassword;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Confirm Password']")
	private MobileElement txtBoxConfirmPassword;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Security Question\"]")
	private MobileElement txtTtlSecurityQuestion;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Answer\"]")
	private MobileElement txtBoxSecurityAnswer;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Create Account\"]")
	private MobileElement btnCreateAccount;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")
	private MobileElement btnCancel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Accept\"]")
	private MobileElement btnAccept;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTINUE\"]")
	private MobileElement btnContinue;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"TUTORIAL_ONBOARDING_WELCOME_DONE_BUTTON\"]")
	private MobileElement btnNotNow;
	
	
	
	
	

	public MobileElement getTxtBoxFirstName() {
		return txtBoxFirstName;
	}

	public MobileElement getTxtBoxLastName() {
		return txtBoxLastName;
	}

	public MobileElement getTxtBoxEmail() {
		return txtBoxEmail;
	}

	public MobileElement getTxtBoxPassword() {
		return txtBoxPassword;
	}

	public MobileElement getTxtBoxConfirmPassword() {
		return txtBoxConfirmPassword;
	}

	public MobileElement getTxtTtlSecurityQuestion() {
		return txtTtlSecurityQuestion;
	}

	public MobileElement getTxtBoxSecurityAnswer() {
		return txtBoxSecurityAnswer;
	}

	public MobileElement getBtnCreateAccount() {
		return btnCreateAccount;
	}

	public MobileElement getBtnCancel() {
		return btnCancel;
	}

	public MobileElement getBtnAccept() {
		return btnAccept;
	}

	public MobileElement getBtnContinue() {
		return btnContinue;
	}

	public MobileElement getBtnNotNow() {
		return btnNotNow;
	}
	
	
	
	
	
	
	
	

}
