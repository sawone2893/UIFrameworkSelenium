package appTest;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.PageTitles;
import pagesobject.PageObjectsManager;
import utilities.Config;

public class TestLoginFlow extends BaseTest{

	@Test
	public void test() {
		PageObjectsManager
					.goToHomePage(PageTitles.HOME_PAGE_TITLE)
					.customerLogin(Config.get("USER_NAME"), Config.get("PASSWORD"));
	}

}
