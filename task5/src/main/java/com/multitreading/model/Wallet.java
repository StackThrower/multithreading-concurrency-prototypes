package com.multitreading.model;

import com.multitreading.Currency;

import java.math.BigDecimal;

public class Wallet {

    private Currency currency;
    private BigDecimal amount;

    public Wallet(Currency currency, double amount) {
        this.currency = currency;
        this.amount = BigDecimal.valueOf(amount);
    }

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

    @Override
    public boolean equals(Object object) {

        Wallet wallet = (Wallet) object;

        return this.amount.equals(wallet.getAmount()) &&
                this.currency.equals(wallet.getCurrency());
    }

    @Override
    public int hashCode() {
        return 53 * amount.hashCode() + currency.hashCode();
    }
}
