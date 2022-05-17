package com.multitreading;

import com.multitreading.model.Account;
import com.multitreading.model.Wallet;

import java.util.*;

public class Market {

    public static final int MAX_ACCOUNT_COUNT = 10;
    public static final int MIN_ACCOUNT_COUNT = 2;

    List<Account> accounts = new ArrayList<>();

    private void initRandomAccounts() {
        Random random = new Random();
        int account_count;
        do {
            account_count = random.nextInt(MAX_ACCOUNT_COUNT);
        } while (account_count < MIN_ACCOUNT_COUNT);

        for (int i = 0; i < account_count; i++) {
            Set<Wallet> wallets = new HashSet<>();
            wallets.add(new Wallet(Currency.USD, random.nextDouble()));
            wallets.add(new Wallet(Currency.EUR, random.nextDouble()));

            accounts.add(new Account(wallets));
        }
    }

    private void saveAccounts() {

    }


    public void demo() {
        initRandomAccounts();
    }

    public static void main(String[] args) {
        Market market = new Market();
        market.demo();
    }
}
