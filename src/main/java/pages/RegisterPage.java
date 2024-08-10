package pages;

import base.BaseClass;
import locators.Locators;
import org.testng.Assert;
import utilities.LocatorGenerator;

public class RegisterPage {

    private static RegisterPage registerPage = null;
    private RegisterPage(String pageTitle) {
        System.out.println("Navigating to RegisterPage...");
        Assert.assertEquals(BaseClass.getPageTitle(),pageTitle);
    }
    public static RegisterPage getInstance(String pageTitle) {
        if (registerPage == null) {
            registerPage = new RegisterPage(pageTitle);
        }
        return registerPage;
    }
    public RegisterPage registerCustomer(String customerData){
        String data[]=customerData.split("~");
        for (String fieldData:data) {
            String field[]=fieldData.split(",");
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