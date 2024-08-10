package base;

import config.EnvConfig;
import core.IActionUI;
import core.ToolFactory;

public class BaseClass {
    private static IActionUI globalDriver;

    public static void initDriver(){
        globalDriver= ToolFactory.getToolInstance(EnvConfig.TOOL_NAME);
        globalDriver.initializeDriver(EnvConfig.BROWSER_TYPE,EnvConfig.IS_HEADLESS_MODE);
    }
    public static void launchBrowser(){
        globalDriver.openURL(EnvConfig.APP_URL);
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
        globalDriver.click(locatorType,locator);
    }

    public static void enterText(String locatorType,String locator,String textToEnter){
        globalDriver.type(locatorType,locator,textToEnter);
    }

    public static String getPageTitle(){
        return globalDriver.getPageTitle();
    }
    
    public static boolean verifyVisibility(String locatorType,String locator) {
    	return globalDriver.isElementPresent(locatorType, locator);
    	
    }
}