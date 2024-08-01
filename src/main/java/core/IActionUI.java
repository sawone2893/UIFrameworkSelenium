package core;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface IActionUI {
    public void initializeDriver(String browserType,boolean isHeadlessMode);

    public void openURL(String url);
    public void closeCurrentTabWindow();
    public void closeBrowser();
    public String getPageTitle();
    public WebElement findElement(String locatorType, String locator);
    public List<WebElement> findElements(String locatorType, String locator);
    public boolean isElementPresent(String locatorType,String locator);
    public boolean waitUntilElementAppear(String locatorType,String locator);
    public boolean waitUntilElementDisAppear(String locatorType,String locator);
    public void click(String locatorType,String locator);
    public void type(String locatorType,String locator,String textToEnter);
    public void switchToOpenedTabWindow(int tabWindowIndex);
    public void openNewTabWindowNSwitch(String tabWindowType);
    public void switchToParenTabWindow();
    public void switchFrame(String locatorType,String locator);
    public String getWebElementText(String locatorType,String locator);
    public String getWebElementAttribute(String locatorType,String locator,String attributeName);
    public void applyExplicitWait(String locatorType,String locator,String state);
    public WebElement applyFluentWait(String locatorType,String locator);
}