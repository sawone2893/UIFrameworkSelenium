package appTest;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.PageTitles;
import pagesObject.PageObjectsManager;

public class TestLoginFlow extends BaseTest{

	@Test
	public void test() {
		PageObjectsManager
					.goToHomePage(PageTitles.HOME_PAGE_TITLE)
					.customerLogin("Shab", "283");
	}

}
