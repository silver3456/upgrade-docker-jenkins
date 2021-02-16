package com.usa.web.pages.personal_info_components;

import com.usa.web.pages.BasePage;
import com.usa.web.selenium.utils.WaitUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.usa.web.selenium.utils.WaitUtil.Options.CLICKABLE;
import static com.usa.web.selenium.utils.WaitUtil.Options.VISIBLE;

public class ContactPage extends BasePage {


    @FindBy(css = "input[name=borrowerFirstName]")
    private WebElement firstName;

    @FindBy(css = "input[name=borrowerLastName]")
    private WebElement lastName;

    @FindBy(css = "input[name=borrowerStreet]")
    private WebElement homeAddress;

    @FindBy(css = "input[name=borrowerCity]")
    private WebElement city;

    @FindBy(css = "input[name^=borrowerState]")
    private WebElement state;

    @FindBy(css = "input[name=borrowerZipCode]")
    private WebElement zipCode;


    @FindBy(css = "input[name^=borrowerDateOfBirth]")
    private WebElement dateOfBirth;

    @FindBy(css = "button[type=submit]")
    private WebElement continueButton;

    @FindBy(css = "ul.geosuggest__suggests")
    private WebElement addressesList;

    private static final String PATTERN_ADDRESS = "//*[@class = 'geosuggest__item__matched-text']";


    public ContactPage(WebDriver driver) {
        super(driver);
        refresh();
    }


    @Step("Enter first name")
    public ContactPage enterFirstName(String fName) {
        helper.enterText(firstName, fName);
        return this;
    }

    @Step("Enter last name")
    public ContactPage enterLastName(String lName) {
        helper.enterText(lastName, lName);
        return this;
    }

    @Step("Enter home address")
    public ContactPage enterHomeAddress(String address) {
        WaitUtil.waitForElementWithOption(driver, continueButton, CLICKABLE);
        helper.enterText(homeAddress, address);
        WaitUtil.waitForElementWithOption(driver, addressesList, VISIBLE);
        driver.findElement(By.xpath((String.format(PATTERN_ADDRESS, address)))).click();
        return this;
    }

    @Step("Enter city name")
    public ContactPage enterCityName(String cityName) {
        helper.enterText(city, cityName);
        return this;
    }

    @Step("Enter state")
    public ContactPage enterState(String stateName) {
        helper.enterText(state, stateName);
        return this;
    }

    @Step("Enter zip code")
    public ContactPage enterZipCode(int zip) {
        helper.enterText(zipCode, String.valueOf(zip));
        return this;
    }

    @Step("Enter date of birth")
    public ContactPage enterDateOfBirth(String dob) {
        helper.enterText(dateOfBirth, dob);
        return this;
    }

    @Step("Click Continue button")
    public void clickContinue() {
        helper.clickOnElement(continueButton);
    }

}
