package com.usa.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OfferPage extends BasePage {

    @FindBy(css = "span[data-auto=userLoanAmount]")
    private WebElement loanAmount;

    @FindBy(css = "span[data-auto=defaultMonthlyPayment]")
    private WebElement monthlyPayment;

    @FindBy(css = "div[data-auto=defaultLoanTerm]")
    private WebElement termElem;

    @FindBy(css = "div[data-auto=defaultLoanInterestRate]")
    private WebElement interestRate;

    @FindBy(css = "div[data-auto=defaultMoreInfoAPR]")
    private WebElement aprValue;

    @FindBy(css = "h1[class*=title--secondary]")
    private WebElement offerNewsTitle;

    @FindBy(css = "button[data-auto=getDefaultLoan]")
    private WebElement selectButton;

    @FindBy(css = "div.header-nav")
    private WebElement hamburgerMenu;

    @FindBy(css = "ul[class*=header-nav-menu]>li:nth-child(2) a")
    private WebElement signoutLink;


    public OfferPage(WebDriver driver) {
        super(driver);
        refresh();
    }

    @Step("Get loan offer details")
    public OfferDto getOfferDetails() {
        OfferDto offer = new OfferDto();
        offer.setLoanAmount(helper.getElementText(loanAmount));
        offer.setMonthlyPayment(helper.getElementText(monthlyPayment).substring(1));
        offer.setTerm(helper.getElementText(termElem).substring(0, 2).trim());
        offer.setInterestRate(getRateValue(interestRate));
        offer.setAPR(getRateValue(aprValue));
        return offer;
    }


    private String getRateValue(WebElement element) {
        String res;
        String s = helper.getElementText(element);
        Pattern p = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher m = p.matcher(s);
        if (m.find()) {
            res = m.group();
            return res;
        }
        return null;
    }


    public void logOut() {
        clickHamburgerMenu(hamburgerMenu);
        clickSignOut(signoutLink);
    }

    @Step("Click hamburger menu")
    private void clickHamburgerMenu(WebElement element) {
        helper.clickOnElement(element);
    }


   @Step("Click sign out link")
    private void clickSignOut(WebElement element) {
        helper.clickOnElement(element);
    }

    public OfferDto reFatchOfferDetails() {
        return getOfferDetails();
    }


}
