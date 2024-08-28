package appTest;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.PageTitles;
import pagesObject.PageObjectsManager;

public class ValidateHomePageLinksDisplayed extends BaseTest{
	
	@Test
	public void testHomeLinks() {
		PageObjectsManager
					.goToHomePage(PageTitles.HOME_PAGE_TITLE)
					.verifyHomePageLinksDisplayed("leftmenu~About Us")
					.verifyHomePageLinksDisplayed("leftmenu~Services")
					.verifyHomePageLinksDisplayed("leftmenu~Products")
					.verifyHomePageLinksDisplayed("leftmenu~Locations")
					.verifyHomePageLinksDisplayed("leftmenu~Admin Page")
					.verifyHomePageLinksDisplayed("services~Withdraw Funds")
					.verifyHomePageLinksDisplayed("services~Transfer Funds")
					.verifyHomePageLinksDisplayed("services~Check Balances")
					.verifyHomePageLinksDisplayed("services~Make Deposits")
					.verifyHomePageLinksDisplayed("servicestwo~Bill Pay")
					.verifyHomePageLinksDisplayed("servicestwo~Account History")
					.verifyHomePageLinksDisplayed("servicestwo~Transfer Funds")
					.verifyHomePageLinksDisplayed("events~ParaBank Is Now Re-Opened")
					.verifyHomePageLinksDisplayed("events~New! Online Bill Pay")
					.verifyHomePageLinksDisplayed("events~New! Online Account Transfers")
					.verifyHomePageLinksDisplayed("Register")
					.verifyHomePageLinksDisplayed("Forgot login info?");
	}

}
