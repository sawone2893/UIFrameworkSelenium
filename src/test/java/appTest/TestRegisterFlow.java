package appTest;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.PageTitles;
import pagesObject.PageObjectsManager;

public class TestRegisterFlow extends BaseTest{
	
	@Test
	public void test() {
		PageObjectsManager
					.goToHomePage(PageTitles.HOME_PAGE_TITLE)
					.verifyHomePageLinksDisplayed("Register")
					.clickHomePageLink("Register");
		PageObjectsManager
					.goToRegisterPage(PageTitles.REGISTER_PAGE_TITLE)
					.registerCustomer("");
	}

}
