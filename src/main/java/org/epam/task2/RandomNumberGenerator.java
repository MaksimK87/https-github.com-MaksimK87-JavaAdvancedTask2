package org.epam.task2;

import java.util.List;
import java.util.Random;

public class RandomNumberGenerator extends Thread {

    private List<Integer> numbers;
    private Object lock;

    public RandomNumberGenerator(List<Integer> numbers, Object lock) {

        this.numbers = numbers;
        this.lock = lock;
    }

    @Override
    public void run() {

        final Random random = new Random();
        while (true) {
            int randomNumber = random.nextInt(100);
            synchronized (lock) {
                numbers.add(randomNumber);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
