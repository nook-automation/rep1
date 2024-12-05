package pages;

import org.openqa.selenium.support.PageFactory;

import functionalLibrary.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AccountPage extends TestBase{
	
	public AccountPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SIGN OUT\"]")
	private MobileElement btnSignOut;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Favorite Categories\"]")
	private MobileElement btnFavoriteCategories;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
	private MobileElement btnOKSignout;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Days Reading\"]")
	private MobileElement imgDaysReading;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Days Listening\"]")
	private MobileElement imgDaysListening;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Wishlist\"]")
	private MobileElement btnWishlist;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Manage Profiles\"]")
	private MobileElement btnManageProfiles;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Account Settings\"]")
	private MobileElement btnaccountSettings;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Payment\"]")
	private MobileElement btnPayment;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Subscriptions\"]")
	private MobileElement btnSubscriptions;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"App Settings\"]")
	private MobileElement btnAppSettings;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Later\"]")
	private MobileElement btnAddPasscodeLater;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Yes\"]")
	private MobileElement btnAddPasscodeNow;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"New Profile\"]")
	private MobileElement btnNewProfile;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Child Passcode\"]")
	private MobileElement btnChildPasscode;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"0\"]")
	private MobileElement btn0;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"New Profile\"]")
	private MobileElement btnAddProfile;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Enter First Name\"]")
	private MobileElement txtBoxProfileName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Return\"]")
	private MobileElement btnReturn;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CREATE NEW PROFILE\"]")
	private MobileElement btnCreateNewProfile;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Test']")
	private MobileElement txtProfileTest;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Edit Test's profile\"]")
	private MobileElement btnEditTestProfile;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Delete Profile\"]")
	private MobileElement btnDeleteProfile;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
	private MobileElement btnOk;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Yes\"]")
	private MobileElement btnYes;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Manage Content\"]")
	private MobileElement btnManageContent;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
	private MobileElement btnDone;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='PROFILE_CELL_SUBTITLE_LABEL'])[3]")
	private MobileElement txtNoOfContents;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
	private MobileElement btnBack;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Settings\"]")
	private MobileElement txtTitleAppSettings;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Days Reading\"]")
	private MobileElement txtDaysReading;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Days Listening\"]")
	private MobileElement txtDaysListening;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Wishlist\"]")
	private MobileElement txtWishlist;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Favorite Categories\"]")
	private MobileElement txtFavoriteCategories;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Manage Profiles\"]")
	private MobileElement txtManageProfiles;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Account Settings\"]")
	private MobileElement txtAccountSettings;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Payment\"]")
	private MobileElement txtPayments;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"App Settings\"]")
	private MobileElement txtAppSettings;
	
	
	

	public MobileElement getBtnManageContent() {
		return btnManageContent;
	}

	public MobileElement getBtnSignOut() {
		return btnSignOut;
	}

	public MobileElement getBtnFavoriteCategories() {
		return btnFavoriteCategories;
	}

	public MobileElement getBtnOKSignout() {
		return btnOKSignout;
	}

	public MobileElement getImgDaysReading() {
		return imgDaysReading;
	}

	public MobileElement getImgDaysListening() {
		return imgDaysListening;
	}

	public MobileElement getBtnWishlist() {
		return btnWishlist;
	}

	public MobileElement getBtnManageProfiles() {
		return btnManageProfiles;
	}

	public MobileElement getBtnaccountSettings() {
		return btnaccountSettings;
	}

	public MobileElement getBtnPayment() {
		return btnPayment;
	}

	public MobileElement getBtnSubscriptions() {
		return btnSubscriptions;
	}

	public MobileElement getBtnAppSettings() {
		return btnAppSettings;
	}

	public MobileElement getBtnAddPasscodeLater() {
		return btnAddPasscodeLater;
	}

	public MobileElement getBtnAddPasscodeNow() {
		return btnAddPasscodeNow;
	}

	public MobileElement getBtnNewProfile() {
		return btnNewProfile;
	}

	public MobileElement getBtnChildPasscode() {
		return btnChildPasscode;
	}

	public MobileElement getBtn0() {
		return btn0;
	}

	public MobileElement getBtnAddProfile() {
		return btnAddProfile;
	}

	public MobileElement getTxtBoxProfileName() {
		return txtBoxProfileName;
	}

	public MobileElement getBtnReturn() {
		return btnReturn;
	}

	public MobileElement getBtnCreateNewProfile() {
		return btnCreateNewProfile;
	}

	public MobileElement getTxtProfileTest() {
		return txtProfileTest;
	}

	public MobileElement getBtnEditTestProfile() {
		return btnEditTestProfile;
	}

	public MobileElement getBtnDeleteProfile() {
		return btnDeleteProfile;
	}

	public MobileElement getBtnOk() {
		return btnOk;
	}

	public MobileElement getBtnYes() {
		return btnYes;
	}

	public MobileElement getBtnDone() {
		return btnDone;
	}

	public MobileElement getTxtNoOfContents() {
		return txtNoOfContents;
	}

	public MobileElement getBtnBack() {
		return btnBack;
	}

	public MobileElement getTxtTitleAppSettings() {
		return txtTitleAppSettings;
	}

	public MobileElement getTxtDaysReading() {
		return txtDaysReading;
	}

	public MobileElement getTxtDaysListening() {
		return txtDaysListening;
	}

	public MobileElement getTxtWishlist() {
		return txtWishlist;
	}

	public MobileElement getTxtFavoriteCategories() {
		return txtFavoriteCategories;
	}

	public MobileElement getTxtManageProfiles() {
		return txtManageProfiles;
	}

	public MobileElement getTxtAccountSettings() {
		return txtAccountSettings;
	}

	public MobileElement getTxtPayments() {
		return txtPayments;
	}

	public MobileElement getTxtAppSettings() {
		return txtAppSettings;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
