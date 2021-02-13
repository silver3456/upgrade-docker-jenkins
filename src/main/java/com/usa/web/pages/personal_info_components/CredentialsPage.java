package com.usa.web.pages.personal_info_components;

import com.usa.web.pages.BasePage;
import com.usa.web.selenium.utils.WaitUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class CredentialsPage extends BasePage {

    @FindBy(css = "input[autocomplete=email]")
    private WebElement emailAddressField;

    @FindBy(css = "input[type=password]")
    private WebElement passwordField;

    @FindBy(css = "button[type=submit]")
    private WebElement checkRateButton;

    @FindBy(css = "input[name=agreements]")
    private WebElement agreeCheckbox;


    private final String CHECK_RATE_BUTTON = "button[type=submit]";

    public CredentialsPage(WebDriver driver) {
        super(driver);
        refresh();
    }


    @Step("Enter email and password, then click Check Your Rate")
    public void checkYourRate(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        selectCheckbox(agreeCheckbox);
        helper.clickOnElement(checkRateButton);
        WaitUtil.waitForElement(driver, CHECK_RATE_BUTTON);
    }

    @Step("Enter email")
    private void enterEmail(String email) {
        helper.enterText(emailAddressField, email);
    }

    @Step("Enter password")
    private void enterPassword(String password) {
        helper.enterText(passwordField, password);
    }

    @Step("Check the box for Terms of Use")
    private void selectCheckbox(WebElement element) {
        Assert.assertTrue(helper.selectElementWithOffset(element), "Checkbox with acceptance of agreement is not selected");
    }

}
