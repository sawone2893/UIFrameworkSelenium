package appTest;

import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigProp;
import pages.PageTitles;
import pagesobject.PageObjectsManager;

public class TestLoginFlow extends BaseTest{

	@Test
	public void test() {
		PageObjectsManager
					.goToHomePage(PageTitles.HOME_PAGE_TITLE)
					.customerLogin(ConfigProp.USER_NAME, ConfigProp.PASSWORD);
	}

}
