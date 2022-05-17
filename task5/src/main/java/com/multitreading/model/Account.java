package com.multitreading.model;

import java.util.List;
import java.util.Set;

public class Account {

    private Set<Wallet> wallets;

    public Account(Set<Wallet> wallets) {
        this.wallets = wallets;
    }

    public Set<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(Set<Wallet> wallets) {
        this.wallets = wallets;
    }
}
