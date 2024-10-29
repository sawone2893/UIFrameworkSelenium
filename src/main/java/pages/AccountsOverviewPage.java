package pages;

import org.slf4j.Logger;
import org.testng.Assert;
import base.BaseClass;
import io.github.shabryn2893.utils.LoggerUtils;

public class AccountsOverviewPage {

	private static final Logger logger=LoggerUtils.getLogger(AccountsOverviewPage.class);
	private static AccountsOverviewPage homePage = null;
    private AccountsOverviewPage(String pageTitle) {
    	logger.info("Navigating to AccountsOverviewPage...");
        Assert.assertEquals(BaseClass.getPageTitle(),pageTitle);
    }
    public static AccountsOverviewPage getInstance(String pageTitle) {
        if (homePage == null) {
            homePage = new AccountsOverviewPage(pageTitle);
        }
        return homePage;
    }
}