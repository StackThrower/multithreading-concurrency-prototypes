package com.multitreading.model;

import com.multitreading.Currency;

import java.math.BigDecimal;

public class ExchangeRate {
    private Currency primary;
    private Currency secondary;
    private BigDecimal rate;

    public ExchangeRate(Currency primary, Currency secondary, double rate) {
        this.primary = primary;
        this.secondary =secondary;
        this.rate = BigDecimal.valueOf(rate);
    }

    public ExchangeRate(Currency primary, Currency secondary) {
        this.primary = primary;
        this.secondary =secondary;
        this.rate = BigDecimal.valueOf(0);
    }
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

    @Override
    public boolean equals(Object object) {

        ExchangeRate exchangeRate = (ExchangeRate) object;

        return this.primary.equals(exchangeRate.getPrimary()) &&
                this.secondary.equals(exchangeRate.getSecondary());
    }

    @Override
    public int hashCode() {
        return 53 * primary.hashCode() + secondary.hashCode();
    }
}
