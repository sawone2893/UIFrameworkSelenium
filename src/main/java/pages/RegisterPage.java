package pages;

import base.BaseClass;
import io.github.shabryn2893.utils.LoggerUtils;
import locators.Locators;

import org.slf4j.Logger;
import org.testng.Assert;
import utilities.LocatorGenerator;

public class RegisterPage {

	private static final Logger logger=LoggerUtils.getLogger(RegisterPage.class);
    private static RegisterPage registerPage = null;
    private RegisterPage(String pageTitle) {
       logger.info("Navigating to RegisterPage...");
        Assert.assertEquals(BaseClass.getPageTitle(),pageTitle);
    }
    public static RegisterPage getInstance(String pageTitle) {
        if (registerPage == null) {
            registerPage = new RegisterPage(pageTitle);
        }
        return registerPage;
    }
    public RegisterPage registerCustomer(String customerData){
        String []data=customerData.split("~");
        for (String fieldData:data) {
            String []field=fieldData.split(",");
            BaseClass.enterText(
                    "XPATH",
                    LocatorGenerator.generateLocator(Locators.INPUT_FIELD_WITH_LABEL, field[0]+":"),
                    field[1]);
        }
        BaseClass.click("XPATH",
                LocatorGenerator.generateLocator(Locators.TAG_WITH_ATTRIBUTE, "input~value~Register"));
        return this;
    }


}