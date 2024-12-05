package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import functionalLibrary.TestBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LibraryPage extends TestBase{
	
private By imgcoverBoyFriendEffectSearchLibBy = MobileBy.xpath("(//XCUIElementTypeButton[@value='The Boyfriend Effect'])[2]");
private By imgcoverSyncingLibBy = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"Syncing Library...\"]");
private By imgCancelDownloadSearchLib=MobileBy.xpath("//XCUIElementTypeApplication[@name=\"B&N NOOK\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeImage[2]");
private By imgDownloadProgressSearchLib=MobileBy.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]");
private By imgCheckMarkPng=MobileBy.xpath("//XCUIElementTypeImage[@name=\"com.bn.NookLibrary.checkmark_bg.png\"]");
private By imgXDownload=MobileBy.xpath("//XCUIElementTypeApplication[@name=\"B&N NOOK\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeImage[2]");
	public LibraryPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Search\"]")
	private MobileElement btnSearch;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Library\"]")
	private MobileElement txtTitleLibrary;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"More Options\"]")
	private MobileElement btnMoreOptions;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Manage Storage\"]")
	private MobileElement btnManageStorage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CANCEL\"]")
	private MobileElement btnCancelSearch;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Search Library\"]")
	private MobileElement txtBoxSearch;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"RECENT\"]")
	private MobileElement txtTabRecents;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ALL TITLES\"]")
	private MobileElement txtTabAllTitles;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SHELVES\"]")
	private MobileElement txtTabShelves;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ACCESSIBILITY_LABEL_FILTER_SELECT_BUTTON\"]")
	private MobileElement txtFilterMediaTypes;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ACCESSIBILITY_LABEL_SORT_SELECT_BUTTON\"]")
	private MobileElement txtFilterSortType;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"BOOK_COUNT\"]")
	private MobileElement txtBookCount;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Grid Layout\"]")
	private MobileElement btnGridView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"List Layout\"]")
	private MobileElement btnListView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
	private MobileElement swcOnlyShowDownloadedItems;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[1]")
	private MobileElement imgCoverPosition1Lib;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tap here to sort or filter All Titles.\"]")
	private MobileElement TxtTip1Lib;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tap here to view more Library settings and view your Archive.\"]")
	private MobileElement TxtTip2Lib;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LIBRARY\"]")
	private MobileElement btnBottomNavLibrary;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ACCOUNT\"]")
	private MobileElement btnBottomNavAccounts;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"EBOOKS\"]")
	private MobileElement btnBottomNavEbooks;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CURRENT READ\"]")
	private MobileElement btnBottomNavCurrentRead;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"AUDIOBOOKS\"]")
	private MobileElement btnBottomNavAudioBooks;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"RECENT READS\"]")
	private MobileElement txtTabRecentReads;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"RECENT PURCHASES\"]")
	private MobileElement txtTabRecentPurchases;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='LIBRARY_GRID_VIEW_CELL_COVER_IMAGE_VIEW'])[1]")
	private MobileElement txtTabRecentReadsBook1;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='LIBRARY_GRID_VIEW_CELL_COVER_IMAGE_VIEW'])[5]")
	private MobileElement txtTabRecentPurchasesBook1;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"All Types filter button\"]")
	private MobileElement txtFilterByAllTypes;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Audiobooks filter button\"]")
	private MobileElement txtFilterByAudioBooks;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Books filter button\"]")
	private MobileElement txtFilterByBooks;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Catalogs filter button\"]")
	private MobileElement txtFilterByCatalog;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Comics filter button\"]")
	private MobileElement txtFilterByComic;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Kids filter button\"]")
	private MobileElement txtFilterByKids;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Magazines filter button\"]")
	private MobileElement txtFilterByMagazines;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"My Files filter button\"]")
	private MobileElement txtFilterByMyFiles;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Newspapers filter button\"]")
	private MobileElement txtFilterByNewspaper;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Most Recent sort button\"]")
	private MobileElement txtFilterSortByMostRecent;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='LIBRARY_LIST_VIEW_CELL_TITLE_LABEL']")
	private MobileElement txtBookNamesLibrary;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Title sort button\"]")
	private MobileElement txtFilterSortByTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='The Adventures of Pinocchio (NOOK Edition)']")
	private MobileElement imgCoverAdventuresOfPinocchio;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Author sort button\"]")
	private MobileElement txtFilterSortByAuthor;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='AUTHOR_VIEW_AUTHOR_LABEL']")
	private MobileElement txtBookNamesSortedByAuthor;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Search\"]")
	private MobileElement btnSearchIosKeyboard;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='The Boyfriend Effect']")
	private MobileElement imgCoverBoyfriendEffectSearchLib;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@value='The Boyfriend Effect'])[2]")
	private MobileElement imgCoverBoyfriendEffectSearchLibLongPress;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@value='The Boyfriend Effect'])[1]")
	private MobileElement imgCoverBoyfriendEffectSearchLibEpub;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LIBRARY_GRID_VIEW_CELL_COVER_IMAGE_VIEW\"]")
	private MobileElement imgCoverBfEffect;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"View Details\"]")
	private MobileElement btnViewDetails;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='Nordstrom - January 2016 Fresh Start']")
	private MobileElement imgCatalogNordStorm;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Archive\"]")
	private MobileElement btnArchive;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"View Archive\"]")
	private MobileElement btnViewArchive;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Unarchive\"]")
	private MobileElement btnUnarchive;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
	private MobileElement btnBack;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='All This Time: A Contemporary Romance Novel']")
	private MobileElement imgCoverAllThisTimeLibrary;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Permanently Delete\"]")
	private MobileElement btnPermenantlyDelete;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"View ...\"]")
	private MobileElement btnView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Annotations\"]")
	private MobileElement btnAnnotations;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypePopover/XCUIElementTypeOther[2]/XCUIElementTypeOther")
	private MobileElement txtTipViewAnnotations;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Boyfriend\"]")
	private MobileElement txtAnnotationBoyfriend;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"It is a good word hear at anytime\"]")
	private MobileElement txtNoteForRelief;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add\"]")
	private MobileElement btnAddShelf;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='LIBRARY_LIST_VIEW_CELL_TITLE_LABEL'])[1]")
	private MobileElement imgCoverPosition1Shelf;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='LIBRARY_LIST_VIEW_CELL_TITLE_LABEL'])[2]")
	private MobileElement imgCoverPosition2Shelf;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='LIBRARY_LIST_VIEW_CELL_TITLE_LABEL'])[3]")
	private MobileElement imgCoverPosition3Shelf;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Next\"]")
	private MobileElement btnNextShelfTab;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save\"]")
	private MobileElement btnSaveShelf;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='December']")
	private MobileElement txtShelfDecember;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='Nook']")
	private MobileElement txtShelfNook;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Rename Shelf\"]")
	private MobileElement btnRenameShelf;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"New Year. found 3 items \"]")
	private MobileElement txtShelfNewYear;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='New Year']")
	private MobileElement txtShelfNameNewYear;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Manage Content\"]")
	private MobileElement btnManageContent;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
	private MobileElement btnDoneShelf;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"New Year. found 2 items \"]")
	private MobileElement txtShelfNewYear2Contents;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Delete Shelf\"]")
	private MobileElement btnDeleteShelf;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Delete\"]")
	private MobileElement btnConfirmDeleteShelf;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Details\"]")
	private MobileElement btnDetails;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Delete\"]")
	private MobileElement btnConfirmDelete;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Manage Progress\"]")
	private MobileElement btnManageProgress;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='TIME The Power of Joy']")
	private MobileElement imgCoverTimeMagazineManageProgress;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Completed (0)\"]")
	private MobileElement btnCompletedManageProgress;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirm\"]")
	private MobileElement btnConfirm;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Completed\"]")
	private MobileElement imgCompletedBadge;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"MARK AS NOT STARTED\"]")
	private MobileElement txtTabMarkAsNotStarted;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Not Started (0)\"]")
	private MobileElement btnNotStarted;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Library Settings\"]")
	private MobileElement btnLibrarySettings;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"UNREAD ITEMS ONLY\"]")
	private MobileElement btnUnreadItemsOnly;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"PopoverDismissRegion\"]")
	private MobileElement imgDismissLibrarySettings;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='Download']")
	private MobileElement imgCloudIconLibrary;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@label='Download'])[1]")
	private MobileElement imgCloudIconLibraryPos1;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"DOWNLOADED ITEMS ONLY\"]")
	private MobileElement swcDownloadedItemsOnly;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"ANNOTATED ITEMS ONLY\"]")
	private MobileElement swcAnnotatedItemsOnly;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='Diary of a Wimpy Kid (Diary of a Wimpy Kid Series #1)']")
	private MobileElement imgCoverWimpyKid;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='SHEILA SWEENY HIGGINSON']")
	private MobileElement imgCoverMinniesValentine;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"SHOW SAMPLES\"]")
	private MobileElement swcShowSamples;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"SHOW SHELVED ITEMS\"]")
	private MobileElement swcShowItemsInShelves;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"VIEW RESULTS\"]")
	private MobileElement btnViewResults;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"UNDOWNLOAD_ICON\"]")
	private MobileElement imgCloudIconSearchLib;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='Saltwater Cove']")
	private MobileElement imgCoverSaltwaterCoveSearchLib;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@value='Saltwater Cove'])[2]")
	private MobileElement imgCoverSaltwaterCoveSearchLib2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='Defiance: The Essential Guide']")
	private MobileElement imgCoverDefianceSearchLib;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@value='Defiance: The Essential Guide'])[2]")
	private MobileElement imgCoverDefianceSearchLib1;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='TIME The Power of Joy']")
	private MobileElement imgCoverTime;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LIBRARY_GRID_VIEW_CELL_COVER_IMAGE_VIEW\"]")
	private MobileElement imgCoverTime1;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TIME The Power of Joy\"]")
	private MobileElement txtCoverTimeSearchLib;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@value='TIME The Power of Joy'])[2]")
	private MobileElement imgCoverTime2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='Onion - 12/14/23']")
	private MobileElement imgCoverOnionDec12;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LIBRARY_GRID_VIEW_CELL_COVER_IMAGE_VIEW\"]")
	private MobileElement imgCoverSearchLib;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Onion - 12/14/23\"]")
	private MobileElement txtCoverOnionDec12;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='Sisters: Free Sneak Preview']")
	private MobileElement imgCoverSistersComic;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"The Elephant's Child: How the Elephant Got His Trunk\"]")
	private MobileElement imgCoverElephantChild;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='Intensity']")
	private MobileElement imgCoverIntensity;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='Come Join Us By the Fire']")
	private MobileElement imgCoverComeJoinUsAB;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='Come Join Us By the Fire: 35 Short Horror Tales from Nightfire Books']")
	private MobileElement imgCoverComeJoinUsABArchive;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@value='Come Join Us By the Fire'])[1]")
	private MobileElement imgCoverComeJoinUsSearchLib;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Come Join Us By the Fire: 35 Short Horror Tales from Nightfire Books\"]")
	private MobileElement txtCoverComeJoinUsSearchLib;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"List Layout\"]")
	private MobileElement btnListViewSearchLib;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@value='The Bequest'])[2]")
	private MobileElement imgCoverTheBequest;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@value='Tap to Play'])[2]")
	private MobileElement btnTapToPlay;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Cancel'])[2]")
	private MobileElement btnCancelDownloadAB;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"UNDOWNLOAD_ICON\"]")
	private MobileElement imgCloudIconSearchLibLstView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"com.bn.NookLibrary.ToolTips.png\"]")
	private MobileElement txtNookTips;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"B&N NOOK\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton")
	private MobileElement btnCancelNookTips;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='A Deeper Blue']")
	private MobileElement imgCoverSideloadEpub;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\\\"B&N NOOK\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeImage[2]")
	private MobileElement imgDownloadXMobile;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Skip\"]")
	private MobileElement btnSkip;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='LIBRARY_GRID_VIEW_CELL_COVER_IMAGE_VIEW'])[1]")
	private MobileElement imgCoverPosition1ManageStorage;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='LIBRARY_GRID_VIEW_CELL_COVER_IMAGE_VIEW'])[2]")
	private MobileElement imgCoverPosition2ManageStorage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Move (0)\"]")
	private MobileElement btnMove2Items;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Move to Cloud\"]")
	private MobileElement btnMoveToCloud;
	
	
	

	public MobileElement getBtnMove2Items() {
		return btnMove2Items;
	}

	public MobileElement getBtnCompletedManageProgress() {
		return btnCompletedManageProgress;
	}

	public MobileElement getBtnSearch() {
		return btnSearch;
	}

	public MobileElement getTxtTitleLibrary() {
		return txtTitleLibrary;
	}

	public MobileElement getBtnMoreOptions() {
		return btnMoreOptions;
	}

	public MobileElement getBtnCancelSearch() {
		return btnCancelSearch;
	}

	public MobileElement getTxtBoxSearch() {
		return txtBoxSearch;
	}

	public MobileElement getTxtTabRecents() {
		return txtTabRecents;
	}

	public MobileElement getTxtTabAllTitles() {
		return txtTabAllTitles;
	}

	public MobileElement getTxtTabShelves() {
		return txtTabShelves;
	}

	public MobileElement getTxtFilterMediaTypes() {
		return txtFilterMediaTypes;
	}

	public MobileElement getTxtFilterSortType() {
		return txtFilterSortType;
	}

	public MobileElement getTxtBookCount() {
		return txtBookCount;
	}

	public MobileElement getBtnGridView() {
		return btnGridView;
	}

	public MobileElement getBtnListView() {
		return btnListView;
	}

	public MobileElement getSwcOnlyShowDownloadedItems() {
		return swcOnlyShowDownloadedItems;
	}

	public MobileElement getImgCoverPosition1Lib() {
		return imgCoverPosition1Lib;
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

	public MobileElement getBtnBottomNavEbooks() {
		return btnBottomNavEbooks;
	}

	public MobileElement getBtnBottomNavCurrentRead() {
		return btnBottomNavCurrentRead;
	}

	public MobileElement getBtnBottomNavAudioBooks() {
		return btnBottomNavAudioBooks;
	}

	public MobileElement getTxtTabRecentReads() {
		return txtTabRecentReads;
	}

	public MobileElement getTxtTabRecentPurchases() {
		return txtTabRecentPurchases;
	}

	public MobileElement getTxtTabRecentReadsBook1() {
		return txtTabRecentReadsBook1;
	}

	public MobileElement getTxtTabRecentPurchasesBook1() {
		return txtTabRecentPurchasesBook1;
	}

	public MobileElement getTxtFilterByAllTypes() {
		return txtFilterByAllTypes;
	}

	public MobileElement getTxtFilterByAudioBooks() {
		return txtFilterByAudioBooks;
	}

	public MobileElement getTxtFilterByBooks() {
		return txtFilterByBooks;
	}

	public MobileElement getTxtFilterByCatalog() {
		return txtFilterByCatalog;
	}

	public MobileElement getTxtFilterByComic() {
		return txtFilterByComic;
	}

	public MobileElement getTxtFilterByKids() {
		return txtFilterByKids;
	}

	public MobileElement getTxtFilterByMagazines() {
		return txtFilterByMagazines;
	}

	public MobileElement getTxtFilterByMyFiles() {
		return txtFilterByMyFiles;
	}

	public MobileElement getTxtFilterByNewspaper() {
		return txtFilterByNewspaper;
	}

	public MobileElement getTxtFilterSortByMostRecent() {
		return txtFilterSortByMostRecent;
	}

	public MobileElement getTxtFilterSortByTitle() {
		return txtFilterSortByTitle;
	}

	public MobileElement getImgCoverAdventuresOfPinocchio() {
		return imgCoverAdventuresOfPinocchio;
	}

	public MobileElement getTxtFilterSortByAuthor() {
		return txtFilterSortByAuthor;
	}

	public MobileElement getTxtBookNamesLibrary() {
		return txtBookNamesLibrary;
	}

	public MobileElement getTxtBookNamesSortedByAuthor() {
		return txtBookNamesSortedByAuthor;
	}

	public MobileElement getBtnSearchIosKeyboard() {
		return btnSearchIosKeyboard;
	}

	public MobileElement getImgCoverBoyfriendEffectSearchLib() {
		return imgCoverBoyfriendEffectSearchLib;
	}

	public By getImgcoverBoyFriendEffectSearchLibBy() {
		return imgcoverBoyFriendEffectSearchLibBy;
	}

	public MobileElement getBtnViewDetails() {
		return btnViewDetails;
	}

	public MobileElement getImgCatalogNordStorm() {
		return imgCatalogNordStorm;
	}

	public MobileElement getBtnArchive() {
		return btnArchive;
	}

	public MobileElement getBtnViewArchive() {
		return btnViewArchive;
	}

	public MobileElement getBtnUnarchive() {
		return btnUnarchive;
	}

	public MobileElement getBtnBack() {
		return btnBack;
	}

	public By getImgcoverSyncingLibBy() {
		return imgcoverSyncingLibBy;
	}

	public MobileElement getImgCoverAllThisTimeLibrary() {
		return imgCoverAllThisTimeLibrary;
	}

	public MobileElement getBtnPermenantlyDelete() {
		return btnPermenantlyDelete;
	}

	public MobileElement getBtnView() {
		return btnView;
	}

	public MobileElement getBtnAnnotations() {
		return btnAnnotations;
	}

	public MobileElement getTxtTipViewAnnotations() {
		return txtTipViewAnnotations;
	}

	public MobileElement getTxtAnnotationBoyfriend() {
		return txtAnnotationBoyfriend;
	}

	public MobileElement getTxtNoteForRelief() {
		return txtNoteForRelief;
	}

	public MobileElement getBtnAddShelf() {
		return btnAddShelf;
	}

	public MobileElement getImgCoverPosition1Shelf() {
		return imgCoverPosition1Shelf;
	}

	public MobileElement getImgCoverPosition2Shelf() {
		return imgCoverPosition2Shelf;
	}

	public MobileElement getImgCoverPosition3Shelf() {
		return imgCoverPosition3Shelf;
	}

	public MobileElement getBtnNextShelfTab() {
		return btnNextShelfTab;
	}

	public MobileElement getBtnSaveShelf() {
		return btnSaveShelf;
	}

	public MobileElement getTxtShelfDecember() {
		return txtShelfDecember;
	}

	public MobileElement getBtnRenameShelf() {
		return btnRenameShelf;
	}

	public MobileElement getTxtShelfNewYear() {
		return txtShelfNewYear;
	}

	public MobileElement getTxtShelfNameNewYear() {
		return txtShelfNameNewYear;
	}

	public MobileElement getBtnManageContent() {
		return btnManageContent;
	}

	public MobileElement getBtnDoneShelf() {
		return btnDoneShelf;
	}

	public MobileElement getTxtShelfNewYear2Contents() {
		return txtShelfNewYear2Contents;
	}

	public MobileElement getBtnDeleteShelf() {
		return btnDeleteShelf;
	}

	public MobileElement getBtnConfirmDeleteShelf() {
		return btnConfirmDeleteShelf;
	}

	public MobileElement getBtnDetails() {
		return btnDetails;
	}

	public MobileElement getBtnConfirmDelete() {
		return btnConfirmDelete;
	}

	public MobileElement getBtnManageProgress() {
		return btnManageProgress;
	}

	public MobileElement getImgCoverTimeMagazineManageProgress() {
		return imgCoverTimeMagazineManageProgress;
	}

	public MobileElement getBtnConfirm() {
		return btnConfirm;
	}

	public MobileElement getImgCompletedBadge() {
		return imgCompletedBadge;
	}

	public MobileElement getTxtTabMarkAsNotStarted() {
		return txtTabMarkAsNotStarted;
	}

	public MobileElement getBtnNotStarted() {
		return btnNotStarted;
	}

	public MobileElement getBtnLibrarySettings() {
		return btnLibrarySettings;
	}

	public MobileElement getBtnUnreadItemsOnly() {
		return btnUnreadItemsOnly;
	}

	public MobileElement getImgDismissLibrarySettings() {
		return imgDismissLibrarySettings;
	}

	public MobileElement getImgCloudIconLibrary() {
		return imgCloudIconLibrary;
	}

	public MobileElement getSwcDownloadedItemsOnly() {
		return swcDownloadedItemsOnly;
	}

	public MobileElement getSwcAnnotatedItemsOnly() {
		return swcAnnotatedItemsOnly;
	}

	public MobileElement getImgCoverWimpyKid() {
		return imgCoverWimpyKid;
	}

	public MobileElement getImgCoverMinniesValentine() {
		return imgCoverMinniesValentine;
	}

	public MobileElement getSwcShowSamples() {
		return swcShowSamples;
	}

	public MobileElement getSwcShowItemsInShelves() {
		return swcShowItemsInShelves;
	}

	public MobileElement getBtnViewResults() {
		return btnViewResults;
	}

	public MobileElement getImgCloudIconSearchLib() {
		return imgCloudIconSearchLib;
	}

	public By getImgCancelDownloadSearchLib() {
		return imgCancelDownloadSearchLib;
	}

	public MobileElement getImgCoverSaltwaterCoveSearchLib() {
		return imgCoverSaltwaterCoveSearchLib;
	}

	public MobileElement getImgCoverDefianceSearchLib() {
		return imgCoverDefianceSearchLib;
	}

	public MobileElement getImgCoverTime() {
		return imgCoverTime;
	}

	public MobileElement getImgCoverOnionDec12() {
		return imgCoverOnionDec12;
	}

	public MobileElement getImgCoverSistersComic() {
		return imgCoverSistersComic;
	}

	public MobileElement getImgCoverElephantChild() {
		return imgCoverElephantChild;
	}

	public MobileElement getImgCoverIntensity() {
		return imgCoverIntensity;
	}

	public MobileElement getImgCloudIconLibraryPos1() {
		return imgCloudIconLibraryPos1;
	}

	public MobileElement getImgCoverComeJoinUsAB() {
		return imgCoverComeJoinUsAB;
	}

	public MobileElement getImgCoverComeJoinUsSearchLib() {
		return imgCoverComeJoinUsSearchLib;
	}

	public MobileElement getTxtShelfNook() {
		return txtShelfNook;
	}

	public MobileElement getBtnListViewSearchLib() {
		return btnListViewSearchLib;
	}

	public MobileElement getImgCoverTheBequest() {
		return imgCoverTheBequest;
	}

	public MobileElement getBtnTapToPlay() {
		return btnTapToPlay;
	}

	public MobileElement getBtnCancelDownloadAB() {
		return btnCancelDownloadAB;
	}

	public MobileElement getImgCloudIconSearchLibLstView() {
		return imgCloudIconSearchLibLstView;
	}

	public MobileElement getTxtNookTips() {
		return txtNookTips;
	}

	public MobileElement getBtnCancelNookTips() {
		return btnCancelNookTips;
	}

	public MobileElement getImgCoverBoyfriendEffectSearchLibEpub() {
		return imgCoverBoyfriendEffectSearchLibEpub;
	}

	public MobileElement getImgCoverTime2() {
		return imgCoverTime2;
	}

	public By getImgDownloadProgressSearchLib() {
		return imgDownloadProgressSearchLib;
	}

	public MobileElement getTxtCoverTimeSearchLib() {
		return txtCoverTimeSearchLib;
	}

	public MobileElement getImgCoverSideloadEpub() {
		return imgCoverSideloadEpub;
	}

	public MobileElement getImgCoverBoyfriendEffectSearchLibLongPress() {
		return imgCoverBoyfriendEffectSearchLibLongPress;
	}

	public MobileElement getImgCoverDefianceSearchLib1() {
		return imgCoverDefianceSearchLib1;
	}

	public By getImgCheckMarkPng() {
		return imgCheckMarkPng;
	}

	public MobileElement getTxtCoverOnionDec12() {
		return txtCoverOnionDec12;
	}

	public MobileElement getImgCoverSearchLib() {
		return imgCoverSearchLib;
	}

	public MobileElement getImgCoverSaltwaterCoveSearchLib2() {
		return imgCoverSaltwaterCoveSearchLib2;
	}

	public By getImgXDownload() {
		return imgXDownload;
	}

	public MobileElement getImgDownloadXMobile() {
		return imgDownloadXMobile;
	}

	public MobileElement getTxtCoverComeJoinUsSearchLib() {
		return txtCoverComeJoinUsSearchLib;
	}

	public MobileElement getImgCoverComeJoinUsABArchive() {
		return imgCoverComeJoinUsABArchive;
	}

	public MobileElement getBtnSkip() {
		return btnSkip;
	}

	public MobileElement getImgCoverBfEffect() {
		return imgCoverBfEffect;
	}

	public MobileElement getImgCoverTime1() {
		return imgCoverTime1;
	}

	public MobileElement getImgCoverPosition1ManageStorage() {
		return imgCoverPosition1ManageStorage;
	}

	public MobileElement getImgCoverPosition2ManageStorage() {
		return imgCoverPosition2ManageStorage;
	}

	public MobileElement getBtnManageStorage() {
		return btnManageStorage;
	}

	public MobileElement getBtnMoveToCloud() {
		return btnMoveToCloud;
	}





	
	
}
