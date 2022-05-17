package com.multitreading;

import com.multitreading.model.Account;
import com.multitreading.model.ExchangeRate;
import com.multitreading.model.Wallet;

import java.util.*;

public class Market {

    public static final int MAX_ACCOUNT_COUNT = 10;
    public static final int MIN_ACCOUNT_COUNT = 2;

    List<Account> accounts = new ArrayList<>();
    Set<ExchangeRate> exchangeRates = new HashSet<>();

    private void initExchangeRates() {
        Random random = new Random();
        exchangeRates.add(new ExchangeRate(Currency.USD, Currency.EUR, random.nextDouble()));
        exchangeRates.add(new ExchangeRate(Currency.USD, Currency.GBP, random.nextDouble()));
        System.out.println("Rates have been initialized");
    }


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

        System.out.println("Accounts have been initialized");

    }

    private void saveAccounts() {

    }


    public void start() {
        initRandomAccounts();
        initExchangeRates();

        Trading.trade(exchangeRates, accounts);
    }

    public static void main(String[] args) {
        Market market = new Market();
        market.start();
    }
}
