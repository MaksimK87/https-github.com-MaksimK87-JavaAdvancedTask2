package org.epam.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeIntegerMap {

    private final Map<Integer, Integer> map = new HashMap<>();
    final Lock lock = new ReentrantLock();

    public Integer put(Integer key, Integer value) {

        lock.lock();
        Integer put = map.put(key, value);
        lock.unlock();
        return put;
    }

    public int getSum() {

        lock.lock();
        Set<Entry<Integer, Integer>> entries = this.map.entrySet();
        Integer sum = 0;
        for (Entry<Integer, Integer> entry : this.map.entrySet()) {
            sum = sum + entry.getKey() + entry.getValue();
        }
        lock.unlock();
        return sum;
    }
}
