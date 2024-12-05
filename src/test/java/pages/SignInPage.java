package pages;

import org.openqa.selenium.support.PageFactory;

import functionalLibrary.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SignInPage extends TestBase{
	
	public SignInPage() {
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
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Create Account\"]")
	private MobileElement btnCreateAccount;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name=\"By continuing, I accept the NOOK End User License Agreement, Digital Content Terms of Sale, Terms and Conditions of Use and Privacy Policy.\"]")
	private MobileElement lnkTermsAndConditions;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Close\"]")
	private MobileElement btnClose;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"com.bn.NookApplication.logo_nook_bybn_login.png\"]")
	private MobileElement imgBnLogoSignIn;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Forgot Password?\"]")
	private MobileElement lnkForgotPassword;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Having trouble signing in?\"]")
	private MobileElement lnkTroubleSigningIn;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Don’t have an account? Create an Account\"]")
	private MobileElement lnkCreateAnAccount;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"View FAQs\"")
	private MobileElement btnViewFaqs;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
	private MobileElement btnOk;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Email']")
	private MobileElement txtBoxEmailForgotPassword;;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Forgot Password\"]")
	private MobileElement txtTitleForgotPassword;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Email Me a Reset Link\"]")
	private MobileElement btnEmailMeResetLink;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Answer a Security Question\"]")
	private MobileElement btnAnswerSecurityQuestions;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeSecureTextField[@name=\"CREDENTIALS_PASSWORD_TEXTFIELD\"])[1]")
	private MobileElement txtBoxNewPassword;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeSecureTextField[@name=\"CREDENTIALS_PASSWORD_TEXTFIELD\"])[2]")
	private MobileElement txtBoxConfirmNewPassword;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Submit\"]")
	private MobileElement btnSubmitResetPassword;
	
	
	
	
	
	
	

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



	public MobileElement getBtnCreateAccount() {
		return btnCreateAccount;
	}



	public MobileElement getLnkTermsAndConditions() {
		return lnkTermsAndConditions;
	}



	public MobileElement getBtnClose() {
		return btnClose;
	}



	public MobileElement getImgBnLogoSignIn() {
		return imgBnLogoSignIn;
	}



	public MobileElement getLnkForgotPassword() {
		return lnkForgotPassword;
	}



	public MobileElement getLnkTroubleSigningIn() {
		return lnkTroubleSigningIn;
	}



	public MobileElement getLnkCreateAnAccount() {
		return lnkCreateAnAccount;
	}



	public MobileElement getBtnViewFaqs() {
		return btnViewFaqs;
	}



	public MobileElement getBtnOk() {
		return btnOk;
	}



	public MobileElement getTxtTitleForgotPassword() {
		return txtTitleForgotPassword;
	}



	public MobileElement getBtnEmailMeResetLink() {
		return btnEmailMeResetLink;
	}



	public MobileElement getBtnAnswerSecurityQuestions() {
		return btnAnswerSecurityQuestions;
	}



	public MobileElement getTxtBoxNewPassword() {
		return txtBoxNewPassword;
	}



	public MobileElement getTxtBoxConfirmNewPassword() {
		return txtBoxConfirmNewPassword;
	}



	public MobileElement getBtnSubmitResetPassword() {
		return btnSubmitResetPassword;
	}



	public MobileElement getTxtBoxEmailForgotPassword() {
		return txtBoxEmailForgotPassword;
	}

	
	
	
	
	
	
}
