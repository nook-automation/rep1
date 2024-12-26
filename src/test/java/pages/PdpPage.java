package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import functionalLibrary.TestBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PdpPage extends TestBase{
	private By btnCancelBy = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"CANCEL\"]");


	public PdpPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
	private MobileElement btnBack;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Manage\"]")
	private MobileElement btnManage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"READ\"]")
	private MobileElement btnRead;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"MOVE TO CLOUD\"]")
	private MobileElement btnMoveToCloud;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Customer Reviews\"]")
	private MobileElement txtTtlCustomerReviews;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OVERVIEW\"]")
	private MobileElement txtTtlOverview;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"MORE\"]")
	private MobileElement btnMore;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"EDITORIAL REVIEWS\"]")
	private MobileElement txtTtlEditorialReviews;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Share\"]")
	private MobileElement btnShare;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Mark as Completed\"]")
	private MobileElement btnMarkAsCompleted;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Archive\"]")
	private MobileElement btnArchive;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"PLAY SAMPLE\"]")
	private MobileElement btnPlaySample;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ADD TO WISHLIST\"]")
	private MobileElement btnAddToWishlist;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"eBook\"]")
	private MobileElement btnLinkedEbook;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Audiobook\"]")
	private MobileElement btnLinkedAb;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"FREE\"]")
	private MobileElement btnFree;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONFIRM\"]")
	private MobileElement btnConfirm;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"FREE SAMPLE\"]")
	private MobileElement btnFreeSample;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"READ SAMPLE\"]")
	private MobileElement btnReadSample;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
	private MobileElement btnOkWishlist;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Audiobook']")
	private MobileElement btnAudioBook;

	
	
	
	
	
	

	public MobileElement getBtnBack() {
		return btnBack;
	}

	public MobileElement getBtnManage() {
		return btnManage;
	}

	public MobileElement getBtnRead() {
		return btnRead;
	}

	public MobileElement getBtnMoveToCloud() {
		return btnMoveToCloud;
	}

	public MobileElement getTxtTtlCustomerReviews() {
		return txtTtlCustomerReviews;
	}

	public MobileElement getTxtTtlOverview() {
		return txtTtlOverview;
	}

	public MobileElement getBtnMore() {
		return btnMore;
	}

	public MobileElement getTxtTtlEditorialReviews() {
		return txtTtlEditorialReviews;
	}

	public MobileElement getBtnShare() {
		return btnShare;
	}

	public MobileElement getBtnMarkAsCompleted() {
		return btnMarkAsCompleted;
	}

	public MobileElement getBtnArchive() {
		return btnArchive;
	}

	public MobileElement getBtnPlaySample() {
		return btnPlaySample;
	}

	public MobileElement getBtnAddToWishlist() {
		return btnAddToWishlist;
	}

	public MobileElement getBtnLinkedEbook() {
		return btnLinkedEbook;
	}

	public MobileElement getBtnLinkedAb() {
		return btnLinkedAb;
	}

	public MobileElement getBtnFree() {
		return btnFree;
	}

	public MobileElement getBtnConfirm() {
		return btnConfirm;
	}

	public By getBtnCancelBy() {
		return btnCancelBy;
	}

	public MobileElement getBtnFreeSample() {
		return btnFreeSample;
	}

	public MobileElement getBtnReadSample() {
		return btnReadSample;
	}

	public MobileElement getBtnOkWishlist() {
		return btnOkWishlist;
	}

	public MobileElement getBtnAudioBook() {
		return btnAudioBook;
	}
	
	
	
	
}
