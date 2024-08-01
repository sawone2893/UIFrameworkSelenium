package pages;

import base.BaseClass;
import locators.Locators;
import org.testng.Assert;
import utilities.LocatorGenerator;

public class HomePage {

    private static HomePage homePage = null;
    private HomePage(String pageTitle) {
        System.out.println("HomePage is Instantiated...");
        Assert.assertEquals(BaseClass.getPageTitle(),pageTitle);
    }
    public static HomePage getInstance(String pageTitle) {
        if (homePage == null) {
            homePage = new HomePage(pageTitle);
        }
        return homePage;
    }

    public HomePage customerLogin(String username, String password) {
        BaseClass.enterText(
                "XPATH",
                LocatorGenerator.generateLocator(Locators.INPUT_FIELD_WITH_LABEL, "Username"),
                username);
        BaseClass.enterText("XPATH",
                LocatorGenerator.generateLocator(Locators.INPUT_FIELD_WITH_LABEL, "Password"),
                password);
        BaseClass.click("XPATH",
                LocatorGenerator.generateLocator(Locators.TAG_WITH_ATTRIBUTE, "input~value~Log In"));
        return this;
    }

    public HomePage clickHomePageLink(String linkName) {
        BaseClass.click("LINKTEXT", linkName);
        return this;
    }
}