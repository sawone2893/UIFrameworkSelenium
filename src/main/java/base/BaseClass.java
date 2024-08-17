package base;

import config.ConfigProp;
import core.IActionUI;
import core.ToolFactory;

public class BaseClass {
    private static IActionUI globalDriver;

    public static void initDriver(){
        globalDriver= ToolFactory.getToolInstance(ConfigProp.TOOL_NAME);
        globalDriver.initializeDriver(ConfigProp.BROWSER_TYPE,ConfigProp.IS_HEADLESS_MODE);
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