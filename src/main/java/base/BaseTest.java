package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void initDriver(){
        BaseClass.initDriver();
    }

    @BeforeClass
    public void launchBrowser(){
        BaseClass.launchBrowser();
    }

    @AfterClass
    public void closeSession(){
        //BaseClass.closeSession();
    }

    @AfterSuite
    public void tearDown(){
        //BaseClass.closeBrowser();
    }
}