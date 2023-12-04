package org.epam.task1;

public class CustomMapTest {

    public static void main(String[] args) {

        final ThreadSafeIntegerMap integerMap = new ThreadSafeIntegerMap();
        Thread1 thread1 = new Thread1(integerMap);
        thread1.start();
        Thread2 thread2 = new Thread2(integerMap);
        thread2.start();
    }

}
