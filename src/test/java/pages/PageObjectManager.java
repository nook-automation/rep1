package pages;

public class PageObjectManager {
	
	SamplePage sampleScreen;
	SignInPage signINScreen;
	LibraryPage libraryScreen;
	CreateAccountPage createAccountScreen;
	BookstorePage bookstoreScreen;
	ReadoutsPage readoutsScreen;
	AudiobooksPage audiobooksScreen;
	PdpPage pdpScreen;
	SettingsPage settingsScreen;
	AccountPage accountScreen;
	ReaderPage readerScreen;
	IosSettingsPage iosSettingsScreen;	
	
	public SamplePage getsampleScreen() {
		return (sampleScreen == null)?
				sampleScreen = new SamplePage() :
				sampleScreen;
	}
	
	public SignInPage getSignINScreen() {
		return (signINScreen==null)?
				signINScreen=new SignInPage():
				signINScreen;
	}
	
	public LibraryPage getLibraryScreen() {
		return (libraryScreen==null)?
				libraryScreen=new LibraryPage():
				libraryScreen;
	}

	public CreateAccountPage getCreateAccountScreen() {
		return (createAccountScreen==null)?
				createAccountScreen=new CreateAccountPage():
				createAccountScreen;
	}

	public BookstorePage getBookstoreScreen() {
		return (bookstoreScreen==null)?
				bookstoreScreen=new BookstorePage():
				bookstoreScreen;
	}

	public ReadoutsPage getReadoutsScreen() {
		return (readoutsScreen==null)?
				readoutsScreen=new ReadoutsPage():
				readoutsScreen;
	}

	public AudiobooksPage getAudiobooksScreen() {
		return (audiobooksScreen==null)?
				audiobooksScreen=new AudiobooksPage():
				audiobooksScreen;
	}

	public SettingsPage getSettingsScreen() {
		return (settingsScreen==null)?
				settingsScreen=new SettingsPage():
				settingsScreen;
	}

	public PdpPage getPdpScreen() {
		return (pdpScreen==null)?
				pdpScreen=new PdpPage():
				pdpScreen;
	}

	public AccountPage getAccountScreen() {
		return (accountScreen==null)?
				accountScreen=new AccountPage():
				accountScreen;
	}

	public ReaderPage getReaderScreen() {
		return (readerScreen==null)?
				readerScreen=new ReaderPage():
				readerScreen;
	}

	public IosSettingsPage getIosSettingsScreen() {
		return (iosSettingsScreen==null)?
				iosSettingsScreen=new IosSettingsPage():
				iosSettingsScreen;
	}
	
	




	
	
	
	
	
	

}
