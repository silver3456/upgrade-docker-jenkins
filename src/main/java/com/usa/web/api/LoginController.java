package com.usa.web.api;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class LoginController {

    ValidatableResponse login(UserDto user) {
        return RestAssured.given()
                .log().all()
                .header("x-cf-source-id", "coding-challenge")
                .header("x-cf-corr-id", "27fbee9f-0d78-44bf-9f74-ac8556e879bf")
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post("https://credapi.credify.tech/api/brportorch/v2/login")
                .then();

    }

}
