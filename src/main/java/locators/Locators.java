package locators;

public class Locators {
    //Common Locator Identifiers
    public static final String ANCHOR_LINK="//a[text()='#0#']";
    public static final String INPUT_FIELD_WITH_LABEL="//*[text()='#0#']/following::input[1]";
    public static final String TAG_WITH_ATTRIBUTE="//#0#[@#1#='#2#']";
    public static final String ANCHOR_LINK_UNDER_LI_TAG="//ul[@class='#0#']/li/a[text()='#1#']";
}