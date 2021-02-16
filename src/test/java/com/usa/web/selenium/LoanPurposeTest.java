package com.usa.web.selenium;

import static com.usa.web.selenium.utils.PropertyLoader.getBaseUrl;
import static com.usa.web.selenium.utils.PropertyLoader.getLoginUrl;

import com.usa.web.pages.LandingPage;
import com.usa.web.pages.OfferDto;
import com.usa.web.pages.personal_info_components.ContactPage;
import com.usa.web.pages.LoginPage;
import com.usa.web.pages.OfferPage;
import com.usa.web.pages.personal_info_components.CredentialsPage;
import com.usa.web.pages.personal_info_components.IncomePage;
import com.usa.web.selenium.utils.StringRandomGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoanPurposeTest extends TestRunner {

    private static final String BASE_URL = getBaseUrl();
    private static final String LOGIN_URL = getLoginUrl();


    @Test(testName = "testLoanPrequalificationForm")
    public void testLoanPrequalificationForm()  {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.open(BASE_URL);
        landingPage.goToLoanPurposePage(2000, "Large Purchase");

        String email = StringRandomGenerator.generateEmail();
        String password = StringRandomGenerator.provideValidPassword(10);

        ContactPage contactPage = new ContactPage(driver);
        contactPage
                .enterFirstName("Alex")
                .enterLastName("Smith")
                .enterHomeAddress("2227 Clement Street")
                .enterCityName("San Francisco")
                .enterState("CA")
                .enterZipCode(94121)
                .enterDateOfBirth("12/11/1983")
                .clickContinue();

        IncomePage incomePage = new IncomePage(driver);
        incomePage.goToCredentialsPage(150000, 6000);

        CredentialsPage credentialsPage = new CredentialsPage(driver);
        credentialsPage.checkYourRate(email, password);

        OfferPage offerPage = new OfferPage(driver);
        OfferDto initialOffer = offerPage.getOfferDetails();

        offerPage.logOut();

        landingPage.open(LOGIN_URL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(email, password);

        OfferDto confirmedOffer = offerPage.reFatchOfferDetails();
        Assert.assertEquals(initialOffer, confirmedOffer, "Initial and final offers do not match");
    }

}
