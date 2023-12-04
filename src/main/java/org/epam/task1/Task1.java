package org.epam.task1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Task1 {

    public static void main(String[] args) {

        final Map<Integer, Integer> map = new HashMap<>();
        final Map<Integer, Integer> integerMap = new ConcurrentHashMap<>();
       //Map<Integer, Integer> integerMap = Collections.synchronizedMap(map);
        Thread1 thread1 = new Thread1(integerMap);
        thread1.start();
        Thread2 thread2 = new Thread2(integerMap);
        thread2.start();
    }

}
