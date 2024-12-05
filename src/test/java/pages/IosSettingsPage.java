package pages;

import org.openqa.selenium.support.PageFactory;

import functionalLibrary.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class IosSettingsPage extends TestBase{
	
	public IosSettingsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"B&N NOOK\"]")
	private MobileElement txtNookApplicationSettings;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Environment\"]")
	private MobileElement txtEnvironment;
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Debug Settings\"]")
	private MobileElement txtDebugSettings;
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeNavigationBar[@name=\"B&N NOOK\"]")
	private MobileElement txtTitleBandNNook;
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeCell[@name=\"Production (bncs)\"]")
	private MobileElement txtProduction;
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeCell[@name=\"QA (csqa)\"]")
	private MobileElement txtCsqa;
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeCell[@name=\"QA2 (csqa2)\"]")
	private MobileElement txtCsqa2;
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeCell[@name=\"PoolB (bncs-b)\"]")
	private MobileElement txtPoolb;
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeCell[@name=\"WB (bncs-wb)\"]")
	private MobileElement txtWestbury;
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name=\"B&N NOOK\"]")
	private MobileElement btnBackEnv;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Master Reset\"]")
	private MobileElement txtMasterReset;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeSwitch[@value=\"0\"])[8]")
	private MobileElement btnLogoutOnLaunch;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Settings\"]")
	private MobileElement btnBackIosSettings;
	

	public MobileElement getTxtNookApplicationSettings() {
		return txtNookApplicationSettings;
	}

	public MobileElement getTxtEnvironment() {
		return txtEnvironment;
	}

	public MobileElement getTxtDebugSettings() {
		return txtDebugSettings;
	}

	public MobileElement getTxtTitleBandNNook() {
		return txtTitleBandNNook;
	}

	public MobileElement getTxtProduction() {
		return txtProduction;
	}

	public MobileElement getTxtCsqa() {
		return txtCsqa;
	}

	public MobileElement getTxtCsqa2() {
		return txtCsqa2;
	}

	public MobileElement getTxtPoolb() {
		return txtPoolb;
	}

	public MobileElement getTxtWestbury() {
		return txtWestbury;
	}

	public MobileElement getBtnBackEnv() {
		return btnBackEnv;
	}

	public MobileElement getTxtMasterReset() {
		return txtMasterReset;
	}

	public MobileElement getBtnLogoutOnLaunch() {
		return btnLogoutOnLaunch;
	}

	public MobileElement getBtnBackIosSettings() {
		return btnBackIosSettings;
	}
	
	
	
	

}
