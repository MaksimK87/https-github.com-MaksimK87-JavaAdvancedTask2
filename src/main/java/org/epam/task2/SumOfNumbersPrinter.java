package org.epam.task2;

import java.util.List;

public class SumOfNumbersPrinter extends Thread {

    private List<Integer> numbers;
    private Object lock;

    public SumOfNumbersPrinter(List<Integer> numbers, Object lock) {

        this.numbers = numbers;
        this.lock = lock;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (lock) {
                int sum = numbers.stream().mapToInt(Integer::intValue).sum();
                System.out.println("Sum: " + sum);
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
