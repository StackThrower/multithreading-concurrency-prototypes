package com.multitreading;

import com.multitreading.model.Account;
import com.multitreading.model.ExchangeRate;
import com.multitreading.model.Wallet;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Trading {

    public static final double TRANSACTION_AMOUNT = 0.01;

    public static void trade(Set<ExchangeRate> exchangeRates, List<Account> accounts) {

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        while (true) {

            for (Account account : accounts) {


                executor.submit(() -> {


                    Set<Wallet> wallets = account.getWallets();
                    Object[] walletsArr = wallets.toArray();

                    if (walletsArr.length >= 2) {
                        for (int i = 0; i < walletsArr.length - 1; i++) {
                            Wallet walletFrom = (Wallet) walletsArr[i];
                            Wallet walletTo = (Wallet) walletsArr[i + 1];

                            System.out.println("Wallet from amount:" + walletFrom.getAmount());
                            System.out.println("Wallet to amount:" + walletTo.getAmount());

                            if (walletFrom.getAmount().doubleValue() > Trading.TRANSACTION_AMOUNT) {

                                ExchangeRate exchangeRate = exchangeRates.stream()
                                        .filter(f -> f.equals(new ExchangeRate(walletFrom.getCurrency(),
                                                walletTo.getCurrency())))
                                        .findFirst().orElseThrow();
                                double tranaction = walletFrom.getAmount().doubleValue() * exchangeRate.getRate().doubleValue();
                                System.out.println("Transaction - from:" + walletFrom.getCurrency().label + " to:" +
                                        walletTo.getCurrency().label + " amount:" + tranaction);
                                walletFrom.setAmount(walletFrom.getAmount().subtract(BigDecimal.valueOf(tranaction)));
                                walletTo.setAmount(walletTo.getAmount().add(BigDecimal.valueOf(tranaction)));
                            } else {
                                System.out.println("No money for transaction");
                            }
                        }
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                });

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

            }
        }

    }
}
