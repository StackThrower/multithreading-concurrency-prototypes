package com.multitreading.model;

import com.multitreading.Currency;

import java.math.BigDecimal;

public class ExchangeRate {
    private Currency primary;
    private Currency secondary;
    private BigDecimal rate;

    public Currency getPrimary() {
        return primary;
    }

    public void setPrimary(Currency primary) {
        this.primary = primary;
    }

    public Currency getSecondary() {
        return secondary;
    }

    public void setSecondary(Currency secondary) {
        this.secondary = secondary;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
