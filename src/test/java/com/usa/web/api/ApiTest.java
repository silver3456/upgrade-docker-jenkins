package com.usa.web.api;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {
    private LoginController loginController = new LoginController();

    private static final String EXPECTED_PRODUCT_TYPE = "PERSONAL_LOAN";

    @Test(testName = "positiveLoadLogin")
    public void positiveLoadLogin() {
        UserDto validUser = getValidUser();

        JsonPath jsonPath = loginController.login(validUser)
                .statusCode(200)
                .extract().jsonPath();

        String actualProductType = jsonPath.get("loansInReview[0].productType");
        Assert.assertEquals(actualProductType, EXPECTED_PRODUCT_TYPE, "Wrong Product Type in response");
    }


    @Test(testName = "negativeLoadLogin")
    public void negativeLoadLogin() {
        UserDto invalidUser = getInvalidUser();

        int actualStatusCode = loginController
                .login(invalidUser)
                .extract().statusCode();

        Assert.assertEquals(actualStatusCode, 401, "Wrong Status in response");
    }

    private UserDto getValidUser() {
        UserDto user = new UserDto();
        user.setUsername("coding.challenge.login@upgrade.com");
        user.setPassword("On$3XcgsW#9q");
        user.setRecaptchaToken("coding_challenge");
        return user;
    }

    private UserDto getInvalidUser() {
        UserDto user = new UserDto();
        user.setUsername("coding.challenge.login@asdasd.com");
        user.setPassword("On$3XcgsW#9q");
        user.setRecaptchaToken("coding_challenge");
        return user;
    }
}
