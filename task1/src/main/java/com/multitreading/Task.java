package com.multitreading;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Task {

    static Map<Integer, Integer> map = new HashMap<>();
    final static Integer MAX_KEY = Integer.MAX_VALUE;
    final static Integer MAX_VALUE = 10;

    static class MyTaskIncrementer implements Runnable {

        @Override
        public void run() {

            Random random = new Random();

            while (true) {
                Integer key = random.nextInt(MAX_KEY) + 1;
                Integer value = random.nextInt(MAX_VALUE) + 1;

                map.put(key, value);

                System.out.println("Added new value key:" + key + ", value:" + value);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class MyTaskCounter implements Runnable {

        @Override
        public void run() {

            while (true) {

                Integer count = 0;

                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    count += entry.getValue();

                }

                System.out.println("Current total:" + count);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }




    public static void main(String[] args) {

        Thread threadIncrementer = new Thread(new MyTaskIncrementer());
        Thread threadCounter = new Thread(new MyTaskCounter());

        threadIncrementer.start();
        threadCounter.start();


    }


}
