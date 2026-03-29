package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import utilities.Config;

public class BaseTest {

	@BeforeSuite
	public void initDriver() {
		BaseClass.initDriver(Config.get("BROWSER_TYPE"), Config.get("TOOL_NAME"), Config.getBool("IS_HEADLESS_MODE"));
	}

	@BeforeClass
	public void launchBrowser() {
		BaseClass.launchBrowser();
	}

	@AfterClass
	public void closeSession() {
		BaseClass.closeSession();
	}

	@AfterSuite
	public void tearDown() {
		BaseClass.closeBrowser();
	}
}