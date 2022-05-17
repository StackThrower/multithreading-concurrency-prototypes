package com.multitreading.model;

import com.multitreading.Currency;

import java.math.BigDecimal;

public class Wallet {

    private Currency currency;
    private BigDecimal amount;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
