package pages;

import org.openqa.selenium.support.PageFactory;

import functionalLibrary.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class BookstorePage extends TestBase{
	
	public BookstorePage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Not Now\"]")
	private MobileElement btnNotNow;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Readouts\"]")
	private MobileElement btnReadouts;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Wishlist\"]")
	private MobileElement btnWishlist;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Search\"]")
	private MobileElement btnSearch;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name=\"BROWSE CATEGORIES\"]")
	private MobileElement btnBrowseCategories;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LET'S GO!\"]")
	private MobileElement btnLetsGoFavoriteCategories;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeSearchField[@name=\"Search Catalog\"])[2]")
	private MobileElement TxtBoxSearchBookstore;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"CANCEL\"])[2]")
	private MobileElement btnCancel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"All This Time: A Contemporary Romance Novel\"]")
	private MobileElement txtCoverAllThisTime;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypePopover/XCUIElementTypeOther[2]/XCUIElementTypeOther")
	private MobileElement txtTipBookstore;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='LIBRARY_GRID_VIEW_CELL_COVER_IMAGE_VIEW']")
	private MobileElement imgCoverBookstoreResults;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Intensity']")
	private MobileElement imgCoverIntensity;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Remove from Wishlist\"]")
	private MobileElement btnRemoveFromWishlist;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Skip\"]")
	private MobileElement btnSkip;
	
	


	


	
	
	
	

	public MobileElement getBtnNotNow() {
		return btnNotNow;
	}

	public MobileElement getBtnReadouts() {
		return btnReadouts;
	}

	public MobileElement getBtnWishlist() {
		return btnWishlist;
	}

	public MobileElement getBtnSearch() {
		return btnSearch;
	}

	public MobileElement getBtnBrowseCategories() {
		return btnBrowseCategories;
	}

	public MobileElement getBtnLetsGoFavoriteCategories() {
		return btnLetsGoFavoriteCategories;
	}

	public MobileElement getTxtBoxSearchBookstore() {
		return TxtBoxSearchBookstore;
	}

	public MobileElement getBtnCancel() {
		return btnCancel;
	}

	public MobileElement getTxtCoverAllThisTime() {
		return txtCoverAllThisTime;
	}

	public MobileElement getTxtTipBookstore() {
		return txtTipBookstore;
	}

	public MobileElement getImgCoverBookstoreResults() {
		return imgCoverBookstoreResults;
	}

	public MobileElement getImgCoverIntensity() {
		return imgCoverIntensity;
	}

	public MobileElement getBtnRemoveFromWishlist() {
		return btnRemoveFromWishlist;
	}

	public MobileElement getBtnSkip() {
		return btnSkip;
	}
	
	


	
	

}
