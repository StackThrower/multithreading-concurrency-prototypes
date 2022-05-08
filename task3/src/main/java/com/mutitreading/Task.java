package com.mutitreading;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Task {


    public static LinkedList<String> bus = new LinkedList<>();

    public static String encodeInput(long input) {
        return "Value: " + input + " date:" + new Date(input);
    }

    public static void main(String[] args) {

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        executor.submit(() -> {
            while (true) {
                String value = encodeInput(System.currentTimeMillis());
                executor.submit(() -> {

                    bus.add(value);
                    System.out.println("ADD - " + Thread.currentThread().getName() + " value:" + value);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.printf(e.getMessage());
                    }
                });

                Thread.sleep(50);
            }
        });

        executor.submit(() -> {
            while (true) {
                executor.submit(() -> {
                    try {
                        String value = bus.pop();

                        System.out.println("POP" + Thread.currentThread().getName() + " value:" + value);

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            System.out.printf(e.getMessage());
                        }
                    } catch (NoSuchElementException e) {
                        System.out.println(Thread.currentThread().getName() + " no elements");
                    }
                });

                Thread.sleep(50);
            }
        });


        System.out.println(executor.getPoolSize());
        System.out.println(executor.getQueue().size());


    }
}
