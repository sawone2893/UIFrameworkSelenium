package pages;

import base.BaseClass;
import io.github.shabryn2893.utils.LoggerUtils;
import locators.Locators;
import org.slf4j.Logger;
import org.testng.Assert;
import utilities.LocatorGenerator;

public class HomePage {

	private static final Logger logger=LoggerUtils.getLogger(HomePage.class);
	private static HomePage homePage = null;

	private HomePage(String pageTitle) {
		logger.info("Navigating to HomePage...");
		Assert.assertEquals(BaseClass.getPageTitle(), pageTitle);
	}

	public static HomePage getInstance(String pageTitle) {
		if (homePage == null) {
			homePage = new HomePage(pageTitle);
		}
		return homePage;
	}

	public HomePage customerLogin(String username, String password) {
		BaseClass.enterText("XPATH", LocatorGenerator.generateLocator(Locators.INPUT_FIELD_WITH_LABEL, "Username"),
				username);
		BaseClass.enterText("XPATH", LocatorGenerator.generateLocator(Locators.INPUT_FIELD_WITH_LABEL, "Password"),
				password);
		BaseClass.click("XPATH", LocatorGenerator.generateLocator(Locators.TAG_WITH_ATTRIBUTE, "input~value~Log In"));
		return this;
	}

	public HomePage clickHomePageLink(String linkName) {
		if (!linkName.contains("~")) {
			BaseClass.click("LINKTEXT", linkName);
		} else {
			BaseClass.click("XPATH", LocatorGenerator.generateLocator(Locators.ANCHOR_LINK_UNDER_LI_TAG, linkName));
		}
		return this;
	}
	
	public HomePage verifyHomePageLinksDisplayed(String linkName) {
		if (!linkName.contains("~")) {
			logger.info("Validating Home Page Link: {}",linkName);
			Assert.assertTrue(BaseClass.verifyVisibility("LINKTEXT", linkName))
			;
		}else {
			logger.info("Validating Home Page Link: {}",linkName);
			Assert.assertTrue(BaseClass.verifyVisibility("XPATH", LocatorGenerator.generateLocator(Locators.ANCHOR_LINK_UNDER_LI_TAG, linkName)));
		}
		
		return this;
	}
}