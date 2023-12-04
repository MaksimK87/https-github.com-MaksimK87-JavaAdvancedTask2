package org.epam.task2;

import java.util.List;

public class SquareRootOfSumPrinter extends Thread {

    private List<Integer> numbers;
    private Object lock;

    public SquareRootOfSumPrinter(List<Integer> numbers, Object lock) {

        this.numbers = numbers;
        this.lock = lock;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (lock) {
                double sumOfSquares = numbers.stream().mapToDouble(value -> value * value).sum();
                double sqrt = Math.sqrt(sumOfSquares);
                System.out.println("Sqrt of sum of squares: " + sqrt);
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
