package pages;

import org.openqa.selenium.support.PageFactory;

import functionalLibrary.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ReadoutsPage extends TestBase{
	
	public ReadoutsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONTINUE\"]")
	private MobileElement btnContinue;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BLOGS & EXCERPTS\"]")
	private MobileElement btnBlogsAndExcerpts;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SERIAL READS\"]")
	private MobileElement btnSerialReads;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEE YESTERDAY'S PICKS\"]")
	private MobileElement btnSeeYesterdaysPick;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VIEW DETAILS\"]")
	private MobileElement btnViewDetails;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"LESS\"]")
	private MobileElement btnLess;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"START READING\"]")
	private MobileElement btnStartReading;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEE PAST TITLES\"]")
	private MobileElement btnSeePastTitles;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Chapter One\"]")
	private MobileElement btnChapterOne;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
	private MobileElement btnBack;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Text Options\"]")
	private MobileElement btnTextOptions;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Larger Font\"]")
	private MobileElement btnFontSizeLarger;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Smaller Font\"]")
	private MobileElement btnFontSizeSmaller;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"Book Cover\"])[1]")
	private MobileElement imgCover1BlogAndExcerpts;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Share\"]")
	private MobileElement btnShareBlog;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BLOGS & EXCERPTS\"]")
	private MobileElement txtTabBlogsAndExcerpts;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SERIAL READS\"]")
	private MobileElement txtTabSerialReads;
	
	
	

	public MobileElement getBtnContinue() {
		return btnContinue;
	}

	public MobileElement getBtnBlogsAndExcerpts() {
		return btnBlogsAndExcerpts;
	}

	public MobileElement getBtnSerialReads() {
		return btnSerialReads;
	}

	public MobileElement getBtnSeeYesterdaysPick() {
		return btnSeeYesterdaysPick;
	}

	public MobileElement getBtnViewDetails() {
		return btnViewDetails;
	}

	public MobileElement getBtnLess() {
		return btnLess;
	}

	public MobileElement getBtnStartReading() {
		return btnStartReading;
	}

	public MobileElement getBtnSeePastTitles() {
		return btnSeePastTitles;
	}

	public MobileElement getBtnChapterOne() {
		return btnChapterOne;
	}

	public MobileElement getBtnBack() {
		return btnBack;
	}

	public MobileElement getBtnTextOptions() {
		return btnTextOptions;
	}

	public MobileElement getBtnFontSizeLarger() {
		return btnFontSizeLarger;
	}

	public MobileElement getBtnFontSizeSmaller() {
		return btnFontSizeSmaller;
	}

	public MobileElement getImgCover1BlogAndExcerpts() {
		return imgCover1BlogAndExcerpts;
	}

	public MobileElement getBtnShareBlog() {
		return btnShareBlog;
	}

	public MobileElement getTxtTabBlogsAndExcerpts() {
		return txtTabBlogsAndExcerpts;
	}

	public MobileElement getTxtTabSerialReads() {
		return txtTabSerialReads;
	}
	
	
	

}
