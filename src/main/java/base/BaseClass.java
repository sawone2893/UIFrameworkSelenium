package base;

import config.ConfigProp;
import io.github.shabryn2893.selAutoCore.uiCore.IActionUI;
import io.github.shabryn2893.selAutoCore.uiCore.UIToolFactory;

public class BaseClass {
    private static IActionUI globalDriver;
    private static int maxWaitTime=ConfigProp.MAX_WAIT_TIME;

    public static void initDriver(){
        globalDriver= UIToolFactory.getToolInstance(ConfigProp.TOOL_NAME);
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