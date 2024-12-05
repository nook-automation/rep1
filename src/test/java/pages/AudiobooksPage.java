package pages;

import org.openqa.selenium.support.PageFactory;

import functionalLibrary.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AudiobooksPage extends TestBase {
	
	public AudiobooksPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Not Now\"]")
	private MobileElement btnNotNow;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name=\"BROWSE CATEGORIES\"]")
	private MobileElement btnBrowseCategories;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"LET'S GO!\"])[1]")
	private MobileElement btnLetsGoFavoriteCategories;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Wishlist\"]")
	private MobileElement btnWishlist;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Search\"]")
	private MobileElement btnSearch;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"CANCEL\"])[2]")
	private MobileElement btnCancel;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeSearchField[@name=\"Search Catalog\"])[2]")
	private MobileElement TxtBoxSearchAB;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeSearchField[@name=\"Search Catalog\"])[2]")
	private MobileElement TxtBoxSearchABBookstore;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[7]")
	private MobileElement TxtSearchResult1AbStore;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[1]")
	private MobileElement TxtpdpTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Taken by the Dragon King\"]")
	private MobileElement TxtCoverTakenByDragonKing;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WELCOME TO B&N AUDIOBOOKS\"]")
	private MobileElement TxtWelcomeToAb;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LET'S GO!\"]")
	private MobileElement btnLetsGo;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SKIP\"]")
	private MobileElement btnSkip;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"PlayerOverflowIcon\"]")
	private MobileElement btnMoreOptions;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Close Audiobook\"]")
	private MobileElement btnCloseAb;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Pause\"]")
	private MobileElement btnPause;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Play\"]")
	private MobileElement btnPlay;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"View Details\"]")
	private MobileElement btnViewDetails;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OVERVIEW\"]")
	private MobileElement txtOverView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"PlayerMinimizeIcon\"]")
	private MobileElement btnMinimize;
	

	
	
	
	
	

	public MobileElement getBtnNotNow() {
		return btnNotNow;
	}

	public MobileElement getBtnBrowseCategories() {
		return btnBrowseCategories;
	}

	public MobileElement getBtnLetsGoFavoriteCategories() {
		return btnLetsGoFavoriteCategories;
	}

	public MobileElement getBtnWishlist() {
		return btnWishlist;
	}

	public MobileElement getBtnSearch() {
		return btnSearch;
	}

	public MobileElement getBtnCancel() {
		return btnCancel;
	}

	public MobileElement getTxtBoxSearchAB() {
		return TxtBoxSearchAB;
	}

	public MobileElement getTxtBoxSearchABBookstore() {
		return TxtBoxSearchABBookstore;
	}

	public MobileElement getTxtSearchResult1AbStore() {
		return TxtSearchResult1AbStore;
	}

	public MobileElement getTxtpdpTitle() {
		return TxtpdpTitle;
	}

	public MobileElement getTxtCoverTakenByDragonKing() {
		return TxtCoverTakenByDragonKing;
	}

	public MobileElement getTxtWelcomeToAb() {
		return TxtWelcomeToAb;
	}

	public MobileElement getBtnLetsGo() {
		return btnLetsGo;
	}

	public MobileElement getBtnSkip() {
		return btnSkip;
	}

	public MobileElement getBtnMoreOptions() {
		return btnMoreOptions;
	}

	public MobileElement getBtnCloseAb() {
		return btnCloseAb;
	}

	public MobileElement getBtnPause() {
		return btnPause;
	}

	public MobileElement getBtnPlay() {
		return btnPlay;
	}

	public MobileElement getBtnViewDetails() {
		return btnViewDetails;
	}

	public MobileElement getTxtOverView() {
		return txtOverView;
	}

	public MobileElement getBtnMinimize() {
		return btnMinimize;
	}


	


	
	
	
	
	
}
