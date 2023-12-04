package org.epam.task1;

import java.util.Map;
import java.util.Map.Entry;

public class Thread2 extends Thread {

    private Map<Integer, Integer> integerMap;
    private ThreadSafeIntegerMap integerSafeMap;

    Thread2(Map<Integer, Integer> integerMap) {

        this.integerMap = integerMap;
    }

    Thread2(ThreadSafeIntegerMap integerSafeMap) {

        this.integerSafeMap = integerSafeMap;
    }

    @Override
    public void run() {

        int sum = 0;
        if (integerMap != null) {
            for (Entry<Integer, Integer> entry : integerMap.entrySet()) {
                sum = sum + entry.getKey() + entry.getValue();
            }
        } else {
            sum = integerSafeMap.getSum();
        }
        System.out.println("SUM: " + sum);
    }
}
