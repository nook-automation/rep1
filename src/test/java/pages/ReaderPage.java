package pages;

import org.openqa.selenium.support.PageFactory;

import functionalLibrary.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ReaderPage extends TestBase{

	public ReaderPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Swipe anywhere, or tap along the right edge, to go to the next page.\"]")
	private MobileElement imgSwipeTipLeftReader;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tap this area to bring up reader settings\"]")
	private MobileElement imgCenterTapTip;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[1]")
	private MobileElement imgReaderView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Contents\"]")
	private MobileElement btnContents;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Page 3\"]")
	private MobileElement txtPage3BfEffect;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='3 / 12']")
	private MobileElement txtPage3of12;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back to Library\"]")
	private MobileElement btnBackToLibrary;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSlider[@name=\"pageSlider\"]")
	private MobileElement imgScrubberSeekLine;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"More Options\"]")
	private MobileElement btnMoreOptions;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Go To Page\"]")
	private MobileElement btnGoToPage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[@name=\"7\"]")
	private MobileElement btn7IosKeyboard;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[@name=\"3\"]")
	private MobileElement btn3IosKeyboard;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Go\"]")
	private MobileElement btnGoIosKeyboard;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Back\"]")
	private MobileElement btnBackToPrevPage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add Bookmark\"]")
	private MobileElement btnAddBookmarkOverflow;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Remove Bookmark\"]")
	private MobileElement btnRemoveBookmarkOverflow;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")
	private MobileElement btnCancel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add Bookmark\"]")
	private MobileElement btnAddBookmarkReader;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Bookmark\"]")
	private MobileElement btnRemoveBookmarkReader;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@label='Contents'])[2]")
	private MobileElement txtTabContents;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Bookmarks\"]")
	private MobileElement txtTabBookmarks;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Annotations\"]")
	private MobileElement txtTabAnnotations;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")
	private MobileElement btnCancelContentsTab;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"See annotations across all of your books\"]")
	private MobileElement btnSeeAnnotationsAcross;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='com.bn.CommonReader.Notemark.normal.png']")
	private MobileElement btnAnnotationIconsInSeeAnnotationAcross;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
	private MobileElement btnBack;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Find in Book\"]")
	private MobileElement btnFindInBook;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Page 2\"]")
	private MobileElement txtPage2FindInBook;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='2 / 12']")
	private MobileElement txtPage2of12Boyfriend;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Search this eBook\"]")
	private MobileElement txtBoxFindInBook;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"View Details\"])[2]")
	private MobileElement btnViewDetails;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Settings\"]")
	private MobileElement btnSettings;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Reader Settings\"]")
	private MobileElement txtReaderSettings;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Close\"]")
	private MobileElement btnCloseReaderSettings;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Text Settings\"]")
	private MobileElement btnTextSettings;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"A+andA-: 5\"]")
	private MobileElement btnIncreaseFontSize;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"A+andA-: 6\"]")
	private MobileElement btnIncreaseFontSize5;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Smaller font\"]")
	private MobileElement btnDecreaseFontSize;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Original Font\"]")
	private MobileElement txtOriginalFont;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Georgia\"]")
	private MobileElement txtFontGeorgia;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
	private MobileElement btnBackFont;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Margins\"]")
	private MobileElement txtTabMargins;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LargeMargin\"]")
	private MobileElement imgMargin3;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"MediumMargin\"]")
	private MobileElement imgMargin2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Line Spacing\"]")
	private MobileElement txtTabLineSpacing;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SingleLineSpacing\"]")
	private MobileElement imgLineSpacing1;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OneAndHalfLinesSpacing\"]")
	private MobileElement imgLineSpacing2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Justification\"]")
	private MobileElement txtTabJustification;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Justify\"]")
	private MobileElement imgJustify3;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"AutoJustification\"]")
	private MobileElement imgJustify2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"GOTO_PAGE_TEXTFIELD\"")
	private MobileElement txtBoxGotoPage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"BACK TO LIBRARY\"]")
	private MobileElement btnBackToLibraryEob;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"MOVE TO CLOUD\"]")
	private MobileElement btnMoveToCloudEob;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Saltwater Cove\"]")
	private MobileElement txtTitleSaltWaterEob;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Move to Cloud\"]")
	private MobileElement btnConfirmMoveToCloudEob;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage")
	private MobileElement imgPdfReaderView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Swipe anywhere, or tap along the right edge, to go to the next page.\"]")
	private MobileElement imgSwipeLeftTipMagazine;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tap this area to bring up reader settings\"]")
	private MobileElement imgCenterTapTipMagazine;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[@name=\"PagesScrollView: 0\"]")
	private MobileElement imgPage0Magazine;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"PAGEVIEW_BOOKMARK_BUTTON\"]")
	private MobileElement imgBookmarkDrp;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='Remove bookmark']")
	private MobileElement imgRemoveBookmarkDrp;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='Add bookmark']")
	private MobileElement imgAddBookmarkDrp;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Contents\"]")
	private MobileElement btnContentsDrp;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Page 5\"]")
	private MobileElement txtPage5Drp;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Contents'])[2]")
	private MobileElement txtTabContentsDrp;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Page 0 (Cover)']")
	private MobileElement txtPage0Drp;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='ArticleView']")
	private MobileElement btnArticleView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"THE POWER OF JOY\"]")
	private MobileElement txtTitleArticleView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Close\"]")
	private MobileElement btnCloseArticleView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Text Settings\"]")
	private MobileElement btnTextSettingsArticleView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Dutch\"]")
	private MobileElement txtFontDutch;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[@name=\"PagesScrollView: 5\"]")
	private MobileElement txtPage5DrpView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"View Details\"]")
	private MobileElement btnViewDetailsDrp;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[1]")
	private MobileElement imgOnionReaderView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tip: Press the ZoomView button or double tap the screen to read this title. Turn on letterboxing in Settings.\"]")
	private MobileElement txtTipZoomView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ZoomView\"]")
	private MobileElement btnZoomView;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[1]")
	private MobileElement imgElephantChildReaderView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"CONTENT_ID (1)\"]")
	private MobileElement imgReaderViewSideload;
	

	
	
	

	public MobileElement getImgPdfReaderView() {
		return imgPdfReaderView;
	}

	public MobileElement getBtnConfirmMoveToCloudEob() {
		return btnConfirmMoveToCloudEob;
	}

	public MobileElement getTxtTabJustification() {
		return txtTabJustification;
	}

	public MobileElement getTxtOriginalFont() {
		return txtOriginalFont;
	}

	public MobileElement getTxtPage3of12() {
		return txtPage3of12;
	}

	public MobileElement getImgSwipeTipLeftReader() {
		return imgSwipeTipLeftReader;
	}

	public MobileElement getImgCenterTapTip() {
		return imgCenterTapTip;
	}

	public MobileElement getImgReaderView() {
		return imgReaderView;
	}

	public MobileElement getBtnContents() {
		return btnContents;
	}

	public MobileElement getTxtPage3BfEffect() {
		return txtPage3BfEffect;
	}

	public MobileElement getBtnBackToLibrary() {
		return btnBackToLibrary;
	}

	public MobileElement getImgScrubberSeekLine() {
		return imgScrubberSeekLine;
	}

	public MobileElement getBtnMoreOptions() {
		return btnMoreOptions;
	}

	public MobileElement getBtnGoToPage() {
		return btnGoToPage;
	}

	public MobileElement getBtn7IosKeyboard() {
		return btn7IosKeyboard;
	}

	public MobileElement getBtnGoIosKeyboard() {
		return btnGoIosKeyboard;
	}

	public MobileElement getBtnBackToPrevPage() {
		return btnBackToPrevPage;
	}

	public MobileElement getBtnAddBookmarkOverflow() {
		return btnAddBookmarkOverflow;
	}

	public MobileElement getBtnRemoveBookmarkOverflow() {
		return btnRemoveBookmarkOverflow;
	}

	public MobileElement getBtnCancel() {
		return btnCancel;
	}

	public MobileElement getBtnAddBookmarkReader() {
		return btnAddBookmarkReader;
	}

	public MobileElement getBtnRemoveBookmarkReader() {
		return btnRemoveBookmarkReader;
	}

	public MobileElement getTxtTabContents() {
		return txtTabContents;
	}

	public MobileElement getTxtTabBookmarks() {
		return txtTabBookmarks;
	}

	public MobileElement getTxtTabAnnotations() {
		return txtTabAnnotations;
	}

	public MobileElement getBtnCancelContentsTab() {
		return btnCancelContentsTab;
	}

	public MobileElement getBtnSeeAnnotationsAcross() {
		return btnSeeAnnotationsAcross;
	}

	public MobileElement getBtnAnnotationIconsInSeeAnnotationAcross() {
		return btnAnnotationIconsInSeeAnnotationAcross;
	}

	public MobileElement getBtnBack() {
		return btnBack;
	}

	public MobileElement getBtn3IosKeyboard() {
		return btn3IosKeyboard;
	}

	public MobileElement getBtnFindInBook() {
		return btnFindInBook;
	}

	public MobileElement getTxtPage2FindInBook() {
		return txtPage2FindInBook;
	}

	public MobileElement getTxtPage2of12Boyfriend() {
		return txtPage2of12Boyfriend;
	}

	public MobileElement getTxtBoxFindInBook() {
		return txtBoxFindInBook;
	}

	public MobileElement getBtnViewDetails() {
		return btnViewDetails;
	}

	public MobileElement getBtnSettings() {
		return btnSettings;
	}

	public MobileElement getTxtReaderSettings() {
		return txtReaderSettings;
	}

	public MobileElement getBtnCloseReaderSettings() {
		return btnCloseReaderSettings;
	}

	public MobileElement getBtnTextSettings() {
		return btnTextSettings;
	}

	public MobileElement getBtnIncreaseFontSize() {
		return btnIncreaseFontSize;
	}

	public MobileElement getBtnIncreaseFontSize5() {
		return btnIncreaseFontSize5;
	}

	public MobileElement getBtnDecreaseFontSize() {
		return btnDecreaseFontSize;
	}

	public MobileElement getTxtFontGeorgia() {
		return txtFontGeorgia;
	}

	public MobileElement getBtnBackFont() {
		return btnBackFont;
	}

	public MobileElement getTxtTabMargins() {
		return txtTabMargins;
	}

	public MobileElement getImgMargin3() {
		return imgMargin3;
	}

	public MobileElement getImgMargin2() {
		return imgMargin2;
	}

	public MobileElement getTxtTabLineSpacing() {
		return txtTabLineSpacing;
	}

	public MobileElement getImgLineSpacing1() {
		return imgLineSpacing1;
	}

	public MobileElement getImgLineSpacing2() {
		return imgLineSpacing2;
	}

	public MobileElement getImgJustify3() {
		return imgJustify3;
	}

	public MobileElement getImgJustify2() {
		return imgJustify2;
	}

	public MobileElement getTxtBoxGotoPage() {
		return txtBoxGotoPage;
	}

	public MobileElement getBtnBackToLibraryEob() {
		return btnBackToLibraryEob;
	}

	public MobileElement getBtnMoveToCloudEob() {
		return btnMoveToCloudEob;
	}

	public MobileElement getTxtTitleSaltWaterEob() {
		return txtTitleSaltWaterEob;
	}

	public MobileElement getImgSwipeLeftTipMagazine() {
		return imgSwipeLeftTipMagazine;
	}

	public MobileElement getImgCenterTapTipMagazine() {
		return imgCenterTapTipMagazine;
	}

	public MobileElement getImgPage0Magazine() {
		return imgPage0Magazine;
	}

	public MobileElement getImgBookmarkDrp() {
		return imgBookmarkDrp;
	}

	public MobileElement getImgRemoveBookmarkDrp() {
		return imgRemoveBookmarkDrp;
	}

	public MobileElement getImgAddBookmarkDrp() {
		return imgAddBookmarkDrp;
	}

	public MobileElement getBtnContentsDrp() {
		return btnContentsDrp;
	}

	public MobileElement getTxtPage5Drp() {
		return txtPage5Drp;
	}

	public MobileElement getTxtTabContentsDrp() {
		return txtTabContentsDrp;
	}

	public MobileElement getTxtPage0Drp() {
		return txtPage0Drp;
	}

	public MobileElement getBtnArticleView() {
		return btnArticleView;
	}

	public MobileElement getTxtTitleArticleView() {
		return txtTitleArticleView;
	}

	public MobileElement getBtnCloseArticleView() {
		return btnCloseArticleView;
	}

	public MobileElement getBtnTextSettingsArticleView() {
		return btnTextSettingsArticleView;
	}

	public MobileElement getTxtFontDutch() {
		return txtFontDutch;
	}

	public MobileElement getTxtPage5DrpView() {
		return txtPage5DrpView;
	}

	public MobileElement getBtnViewDetailsDrp() {
		return btnViewDetailsDrp;
	}

	public MobileElement getImgOnionReaderView() {
		return imgOnionReaderView;
	}

	public MobileElement getTxtTipZoomView() {
		return txtTipZoomView;
	}

	public MobileElement getBtnZoomView() {
		return btnZoomView;
	}

	public MobileElement getImgElephantChildReaderView() {
		return imgElephantChildReaderView;
	}

	public MobileElement getImgReaderViewSideload() {
		return imgReaderViewSideload;
	}






	


	
	
	
	
	
	
}
