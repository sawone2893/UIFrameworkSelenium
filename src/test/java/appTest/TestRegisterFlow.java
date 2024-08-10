package appTest;

import org.testng.annotations.Test;

import base.BaseTest;
import pageInstanceFactory.PageInstanceFactory;
import pages.PageTitles;

public class TestRegisterFlow extends BaseTest{
	
	@Test
	public void test() {
		PageInstanceFactory
					.goToHomePage(PageTitles.HOME_PAGE_TITLE)
					.verifyHomePageLinksDisplayed("Register")
					.clickHomePageLink("Register");
		PageInstanceFactory
					.goToRegisterPage(PageTitles.REGISTER_PAGE_TITLE)
					.registerCustomer("");
	}

}
