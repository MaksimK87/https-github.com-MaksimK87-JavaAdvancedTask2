package org.epam.task1;

import java.util.Map;

public class Thread1 extends Thread {

    private Map<Integer, Integer> integerMap;
    private ThreadSafeIntegerMap integerSafeMap;

    Thread1(Map<Integer, Integer> integerMap) {

        this.integerMap = integerMap;
    }

    Thread1(ThreadSafeIntegerMap integerSafeMap) {

        this.integerSafeMap = integerSafeMap;
    }

    @Override
    public void run() {

        if (integerMap != null) {
            for (int i = 0; i < 10000; i++) {
                integerMap.put(i, i);
            }
        } else {
            for (int i = 0; i < 10000; i++) {
                integerSafeMap.put(i, i);
            }
        }
    }
}
