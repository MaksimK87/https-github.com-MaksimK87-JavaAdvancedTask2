package org.epam.task2;

import java.util.ArrayList;
import java.util.List;

public class Task2Main {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        Object lock = new Object();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(integers, lock);
        SumOfNumbersPrinter sumOfNumbersPrinter = new SumOfNumbersPrinter(integers, lock);
        SquareRootOfSumPrinter squareRootOfSumPrinter = new SquareRootOfSumPrinter(integers, lock);
        randomNumberGenerator.start();
        sumOfNumbersPrinter.start();
        squareRootOfSumPrinter.start();
    }
}
