package pagesobject;

import pages.AccountsOverviewPage;
import pages.HomePage;
import pages.RegisterPage;

public class PageObjectsManager {
	
	private PageObjectsManager() {}
	
	public static HomePage goToHomePage(String pageTitle) {
		return HomePage.getInstance(pageTitle);
	}

	public static RegisterPage goToRegisterPage(String pageTitle) {
		return RegisterPage.getInstance(pageTitle);
	}

	public static AccountsOverviewPage goToAccountsOverviewPage(String pageTitle) {
		return AccountsOverviewPage.getInstance(pageTitle);
	}

}