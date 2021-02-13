package com.usa.web.api;

import com.usa.web.pages.OfferDto;

import java.util.Objects;

public class UserDto {
    private String username;
    private String password;
    private String recaptchaToken;


    public String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    public String getRecaptchaToken() {
        return recaptchaToken;
    }

    void setRecaptchaToken(String recaptchaToken) {
        this.recaptchaToken = recaptchaToken;
    }


}
