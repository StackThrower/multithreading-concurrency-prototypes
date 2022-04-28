package com.multitreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Task {

    final static List<Integer> numbers = new ArrayList<>();
    final static Integer MAX_VALUE = 1000;

    static class NumberCreator implements Runnable {

        @Override
        public void run() {

            while (true) {

                Random random = new Random();
                numbers.add(random.nextInt(Task.MAX_VALUE));

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    static class NumberCounter implements Runnable {

        @Override
        public void run() {

            while (true) {

                Integer sum = numbers.stream().reduce(0, Integer::sum);

                System.out.println(Thread.currentThread().getName() + " - TOTAL:" + sum);

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class NumberSquareCounter implements Runnable {

        @Override
        public void run() {

            while (true) {

                Integer squareSum = numbers.stream().reduce(0, (subtotal, element) -> subtotal + (element * element));

                System.out.println(Thread.currentThread().getName() + " - Square sum:" + squareSum);
                System.out.println(Thread.currentThread().getName() + " - Square root of sum of squares of all numbers: " + Math.sqrt(squareSum));

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {

        Thread threadCreator = new Thread(new NumberCreator());
        Thread threadCounter = new Thread(new NumberCounter());
        Thread threadSquareCounter = new Thread(new NumberSquareCounter());

        threadCreator.start();
        threadCounter.start();
        threadSquareCounter.start();
    }

}
