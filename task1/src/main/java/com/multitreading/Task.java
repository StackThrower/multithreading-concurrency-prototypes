package com.multitreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.sleep;

public class Task {

    // HashMap has been replaced by ConcurrentHashMap
    final static Map<Integer, Integer> mapNumbers = new ConcurrentHashMap<>();
    final static List<Long> times = new ArrayList<>();
    final static Integer MAX_KEY = Integer.MAX_VALUE;
    final static Integer MAX_VALUE = 10;

    static class MyTaskIncrementer implements Runnable {

        @Override
        public void run() {

            Random random = new Random();
            long endTime, startTime, diffTime;

            while (true) {
                Integer key = random.nextInt(MAX_KEY) + 1;
                Integer value = random.nextInt(MAX_VALUE) + 1;


                startTime = System.currentTimeMillis();

                mapNumbers.put(key, value);

                endTime = System.currentTimeMillis();

                diffTime = endTime - startTime;

                System.out.println("endTime:" + endTime + ", startTime:" + startTime + " diffTime:" + (diffTime));

                times.add(diffTime);

                System.out.println("Added new value key:" + key + ", value:" + value);

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyTaskCounter implements Runnable {

        @Override
        public void run() {

            while (true) {

                Integer count = 0;

                for (Map.Entry<Integer, Integer> entry : mapNumbers.entrySet()) {
                    count += entry.getValue();

                }

                long averageTime =  times.stream().reduce(0L, Long::sum) / times.size();

                System.out.println("Current total:" + count + " av time:" + averageTime);

                try {
                    sleep(500);
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
