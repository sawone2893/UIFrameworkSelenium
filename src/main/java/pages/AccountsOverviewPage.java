package pages;

import org.testng.Assert;
import base.BaseClass;

public class AccountsOverviewPage {

    private static AccountsOverviewPage homePage = null;
    private AccountsOverviewPage(String pageTitle) {
        System.out.println("AccountsOverviewPage is Instantiated...");
        Assert.assertEquals(BaseClass.getPageTitle(),pageTitle);
    }
    public static AccountsOverviewPage getInstance(String pageTitle) {
        if (homePage == null) {
            homePage = new AccountsOverviewPage(pageTitle);
        }
        return homePage;
    }
}