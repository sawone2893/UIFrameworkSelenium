package core;

import com.google.common.util.concurrent.Uninterruptibles;
import driverFactory.DriverManager;
import driverFactory.DriverManagerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

public class UiActionSelenium implements IActionUI {
    private DriverManager driverManager;
    private WebDriver driver;
    long maxWaitTime;

    @Override
    public void initializeDriver(String browserType, boolean isHeadlessMode) {
        driverManager= DriverManagerFactory.getManager(browserType);
        driver=driverManager.getDriver(isHeadlessMode);
    }

    @Override
    public void openURL(String url){
        driver.get(url);
    }
    @Override
    public void closeCurrentTabWindow(){
        driver.close();
    }
    @Override
    public void closeBrowser(){
        driver.quit();
    }
    @Override
    public String getPageTitle(){
        return driver.getTitle();
    }
    @Override
    public WebElement findElement(String locatorType, String locator) {
        WebElement element;
        switch(locatorType.toUpperCase()){
            case "ID":
                element=driver.findElement(By.id(locator));
                break;
            case "XPATH":
                element=driver.findElement(By.xpath(locator));
                break;
            case "LINKTEXT":
                element=driver.findElement(By.linkText(locator));
                break;
            case "CSS":
                element=driver.findElement(By.cssSelector(locator));
                break;
            case "NAME":
                element=driver.findElement(By.name(locator));
                break;
            case "TAG":
                element=driver.findElement(By.tagName(locator));
                break;
            case "PARTIALLINKTEXT":
                element=driver.findElement(By.partialLinkText(locator));
                break;
            default:
                element=driver.findElement(By.className(locator));
        }
        return element;
    }

    @Override
    public List<WebElement> findElements(String locatorType, String locator) {
        List<WebElement> elements;
        switch(locatorType.toUpperCase()){
            case "ID":
                elements=driver.findElements(By.id(locator));
                break;
            case "XPATH":
                elements=driver.findElements(By.xpath(locator));
                break;
            case "LINKTEXT":
                elements=driver.findElements(By.linkText(locator));
                break;
            case "CSS":
                elements=driver.findElements(By.cssSelector(locator));
                break;
            case "NAME":
                elements=driver.findElements(By.name(locator));
                break;
            case "TAG":
                elements=driver.findElements(By.tagName(locator));
                break;
            case "PARTIALLINKTEXT":
                elements=driver.findElements(By.partialLinkText(locator));
                break;
            default:
                elements=driver.findElements(By.className(locator));
        }
        return elements;
    }

    @Override
    public boolean isElementPresent(String locatorType, String locator) {
            boolean status=false;
            try{
                if(this.findElements(locatorType,locator).size()>0&&this.findElement(locatorType,locator).isDisplayed()&&this.findElement(locatorType,locator).isEnabled()){
                    status=true;
                }
            }catch (Exception e){
                status=false;
                e.printStackTrace();
            }
            return status;
    }
    @Override
    public boolean waitUntilElementAppear(String locatorType, String locator) {
        long startTime,endTime;
        boolean status=true;
        startTime=System.currentTimeMillis();
        try{
            while(!isElementPresent(locatorType,locator)){
                System.out.println("Waiting for WebElement ["+locator+"] to be appear...");
                Uninterruptibles.sleepUninterruptibly(Duration.ofMillis(500));
                endTime=System.currentTimeMillis();
                if((endTime-startTime)>maxWaitTime){
                    break;
                }
            }
        }catch(Exception e){
            status=false;
        }
        return status;
    }

    @Override
    public boolean waitUntilElementDisAppear(String locatorType, String locator) {
        long startTime,endTime;
        boolean status=true;
        startTime=System.currentTimeMillis();
        try{
            while(isElementPresent(locatorType,locator)){
                System.out.println("Waiting for WebElement ["+locator+"] to be disappear...");
                Uninterruptibles.sleepUninterruptibly(Duration.ofMillis(500));
                endTime=System.currentTimeMillis();
                if((endTime-startTime)>maxWaitTime){
                    break;
                }
            }
        }catch(Exception e){
            status=false;
        }
        return status;
    }
    @Override
    public void click(String locatorType, String locator) {
        if (waitUntilElementAppear(locatorType,locator)){
            findElement(locatorType,locator).click();
        }else{
            throw new NoSuchElementException("Web Element["+locator+"] is not appeared");
        }
    }

    @Override
    public void type(String locatorType, String locator, String textToEnter) {
        if (waitUntilElementAppear(locatorType,locator)){
            findElement(locatorType,locator).sendKeys(textToEnter);
        }else{
            throw new NoSuchElementException("Web Element["+locator+"] is not appeared");
        }
    }

    @Override
    public void switchToOpenedTabWindow(int tabWindowIndex){
        ArrayList<String> openWindows= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(openWindows.get(tabWindowIndex));
    }
    @Override
    public void openNewTabWindowNSwitch(String tabWindowType){
        if(tabWindowType.equalsIgnoreCase("Tab")){
            driver.switchTo().newWindow(WindowType.TAB);
        }else{
            driver.switchTo().newWindow(WindowType.WINDOW);
        }
    }

    @Override
    public void switchToParenTabWindow(){
        driver.switchTo().defaultContent();
    }

    @Override
    public void switchFrame(String locatorType, String locator) {

    }

    @Override
    public String getWebElementText(String locatorType, String locator) {
        String textValue = null;
        if (waitUntilElementAppear(locatorType,locator)){
            textValue=findElement(locatorType,locator).getText();
        }else{
            throw new NoSuchElementException("Web Element["+locator+"] is not appeared");
        }
        return textValue;
    }

    @Override
    public String getWebElementAttribute(String locatorType, String locator, String attributeName) {
        String value=null;
        if (waitUntilElementAppear(locatorType,locator)){
            value=findElement(locatorType,locator).getAttribute(attributeName);
        }else{
            throw new NoSuchElementException("Web Element["+locator+"] is not appeared");
        }
        return value;
    }

    @Override
    public void applyExplicitWait(String locatorType, String locator,String state) {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(maxWaitTime));
        switch(state.toUpperCase()){
            case "CLICKABLE":
                wait.until(ExpectedConditions.elementToBeClickable(this.findElement(locatorType,locator)));
                break;
            case "VISIBLE":
                wait.until(ExpectedConditions.visibilityOf(this.findElement(locatorType,locator)));
                break;
            case "INVISIBLE":
                wait.until(ExpectedConditions.invisibilityOf(this.findElement(locatorType,locator)));
                break;
            default:
                System.out.println("Invalid state"+state);
        }
    }

    @Override
    public WebElement applyFluentWait(String locatorType, String locator) {
        FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(maxWaitTime))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        WebElement element=wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return findElement(locatorType,locator);
            }
        });
        return element;
    }
}