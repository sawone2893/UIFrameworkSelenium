package base;

import config.ConfigProp;
import io.github.shabryn2893.uicore.IActionUI;
import io.github.shabryn2893.uidriverfactory.DriverFactory;
import io.github.shabryn2893.uidriverfactory.DriverManager;

public class BaseClass {
    private static IActionUI globalDriver;
    private static int maxWaitTime=ConfigProp.MAX_WAIT_TIME;

    private BaseClass() {
    	throw new UnsupportedOperationException("BaseClass class should not be instantiated");
    }
    
    public static void initDriver(){	
    	DriverManager driverManager=DriverFactory.getDriver(ConfigProp.BROWSER_TYPE, ConfigProp.TOOL_NAME, ConfigProp.IS_HEADLESS_MODE);
    	globalDriver=driverManager.createBrowser();
    }
    public static void launchBrowser(){
        globalDriver.openURL(ConfigProp.APP_URL);
    }
    public static void closeSession(){
        globalDriver.closeCurrentTabWindow();
        globalDriver=null;
    }
    public static void closeBrowser(){
        if(globalDriver!=null) {
            globalDriver.closeBrowser();
        }
    }

    public static  void click(String locatorType,String locator){
        globalDriver.click(locatorType,locator,maxWaitTime);
    }

    public static void enterText(String locatorType,String locator,String textToEnter){
        globalDriver.type(locatorType,locator,textToEnter,maxWaitTime);
    }

    public static String getPageTitle(){
        return globalDriver.getPageTitle();
    }
    
    public static boolean verifyVisibility(String locatorType,String locator) {
    	return globalDriver.isElementPresent(locatorType, locator);
    	
    }
}