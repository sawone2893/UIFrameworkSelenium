package appTest;

import org.testng.annotations.Test;

import base.BaseTest;
import pageInstanceFactory.PageInstanceFactory;
import pages.PageTitles;

public class TestLoginFlow extends BaseTest{

	@Test
	public void test() {
		PageInstanceFactory
					.goToHomePage(PageTitles.HOME_PAGE_TITLE)
					.customerLogin("Shab", "283");
	}

}
