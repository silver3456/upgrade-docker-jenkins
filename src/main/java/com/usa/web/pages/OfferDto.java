package com.usa.web.pages;

import java.util.Objects;

public class OfferDto {

    private String loanAmount;
    private String monthlyPayment;
    private String term;
    private String interestRate;
    private String APR;


    private String getLoanAmount() {
        return loanAmount;
    }

    void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    private String getMonthlyPayment() {
        return monthlyPayment;
    }

    void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    private String getTerm() {
        return term;
    }

    void setTerm(String term) {
        this.term = term;
    }

    private String getInterestRate() {
        return interestRate;
    }

    void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    private String getAPR() {
        return APR;
    }

    void setAPR(String APR) {
        this.APR = APR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfferDto)) return false;
        OfferDto offerDto = (OfferDto) o;
        return Objects.equals(this.getLoanAmount(), offerDto.getLoanAmount())
                && Objects.equals(this.getMonthlyPayment(), offerDto.getMonthlyPayment())
                && Objects.equals(this.getTerm(), offerDto.getTerm())
                && Objects.equals(this.getInterestRate(), offerDto.getInterestRate())
                && Objects.equals(this.getAPR(), offerDto.getAPR());
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanAmount, monthlyPayment, term, interestRate, APR);
    }

}
